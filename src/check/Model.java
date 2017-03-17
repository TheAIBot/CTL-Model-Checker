package check;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Model {
	// it, as discussed before. Also, whether one can assume that there are no stuck states.
	public final HashMap<Integer, State> stateMap = new HashMap<Integer, State>();
	public final HashSet<State> states = new HashSet<State>();
	private final ArrayList<String> atomicPropositions;
	private final HashSet<State> initialStates = new HashSet<State>();

	/**
	 * TODO no comma as a character in the atomic propositions!
	 * 
	 * @param atomicPropositions
	 */
	public Model(String atomicPropositionsString) {
		Set<String> hs = new HashSet<String>();
		hs.addAll(Arrays.asList(atomicPropositionsString.split(",")));
		atomicPropositions = new ArrayList<String>(hs);
		atomicPropositions.sort(Comparator.naturalOrder());
	}

	public void setStartStates(String startStateNumbersString) {
		String[] startStateNumbers = startStateNumbersString.split(",");
		for (String stateNumberString : startStateNumbers) {
			if (!isInteger(stateNumberString)) {
				throw new Error("The start state string must only contain integers, not: " + stateNumberString);
			}
			
			int stateNumber = Integer.parseInt(stateNumberString);
			if (!stateMap.containsKey(stateNumber)) {
				throw new Error("Error: the declared start state " + stateNumber + " does not exist");
			}
			
			initialStates.add(stateMap.get(stateNumber));
		}
	}
	
	private boolean isInteger(String maybeInteger) {
		try {
			Integer.parseInt(maybeInteger);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isModelValid() {
		for (State state : states) {
			for (int edge : state.edges) {
				if (!stateMap.containsKey(edge)) {
					System.out.println("Model is not valid: state " + edge + " does not exist");
					return false;
				}
			}
		}
		return true;
	}

	public void initialize() {
		if (isModelValid()) {
			for (State state : states) {
				state.readyNeighborList();
			}
		}
	}

	public void addState(int stateNumber, String labelString, String edgeString) {
		if (stateNumber < 0) {
			throw new Error("Error: state numbers must not be less than zero");
		}
		if (stateMap.containsKey(stateNumber)) {
			throw new Error("Error: cannot insert state " + stateNumber + " twice.");
		}
		String[] labels = labelString.split(",");// (*) Remember to check for
													// duplicates!
		String[] edgesStrings = edgeString.split(",");
		Arrays.sort(labels); // Just for the heck of it.
		for (String label : labels) {
			if (!atomicPropositions.contains(label)) {
				throw new Error("Error: " + label + " is not an atomic proposition.");
			}
		}
		int[] edges = new int[edgesStrings.length];
		for (int i = 0; i < edges.length; i++) {
			if (!isInteger(edgesStrings[i])) {
				throw new Error("Error: the edges given must be integers, not: " + edgesStrings[i]);
			}
			
			edges[i] = Integer.parseInt(edgesStrings[i]);
		}
		Arrays.sort(edges);
		// It must not contain duplicates (and it is sorted):
		for (int i = 0; i < edges.length - 1; i++) {
			if (edges[i] >= edges[i + 1]) {
				throw new Error("Error: duplicate edges for a state is not allowed: see state " + stateNumber + " with edges " + edges[i]);
			}
		}
		State newState = new State(this, stateNumber, labels, edges);
		stateMap.put(newState.getStateNumber(), newState);
		states.add(newState);
	}
	
	public HashSet<State> AllDiamondsAreUnbreakable(HashSet<State> phiStates){
		//TODO will not work in the case that there exists stuck states. 
		HashSet<State> allButPhiStates = complementOf(states, phiStates);
		HashSet<State> notValidStates = EG(allButPhiStates);
		HashSet<State> validStates = complementOf(states, notValidStates);
		return validStates;
	}
	
	public HashSet<State> AG(HashSet<State> phiStates) {
		HashSet<State> validStates = new HashSet<State>();
		for (State state : states) {
			if (isSuperSet(state.getReachableStates(),phiStates)) {
				validStates.add(state);
			}
		}
		return validStates;
	}

	public HashSet<State> AO(HashSet<State> phiStates) {
		HashSet<State> validStates = new HashSet<State>();
		for (State state : states) {
			if (!state.connectedStates.isEmpty() && 
				isSuperSet(new HashSet<State>(state.connectedStates),validStates)) {
				validStates.add(state);
			}
		}
		return validStates;
	}

	public HashSet<State> EX(HashSet<State> phiStates) {		
		return states.stream().filter(x -> x.getConnectedStates().stream().anyMatch(y -> phiStates.contains(y))).collect(Collectors.toCollection(HashSet::new));
	}

	public HashSet<State> EF(HashSet<State> phiStates) {		
		return states.stream().filter(x -> x.getReachableStates().stream().anyMatch(y -> phiStates.contains(y))).collect(Collectors.toCollection(HashSet::new));
	}

	public HashSet<State> EG(HashSet<State> phiStates) {		
		return states.stream().filter(x -> x.containsPhiLoop(phiStates)).collect(Collectors.toCollection(HashSet::new));
	}

	private boolean isSuperSet(HashSet<State> subSet, HashSet<State> superSet) {
		for (State state : subSet) {
			if (!superSet.contains(state)) {
				return false;
			}
		}
		return true;

	}
	
	public boolean checkIncludesInitialStates(HashSet<State> superSet) {
		if (isSuperSet(initialStates, superSet)) {
			return true;
		} else return false;
	}

	public HashSet<State> getStates() {
		return states;
	}
	
	public State getState(int stateNumber) {
		return stateMap.get(stateNumber);
	}
	
	public HashSet<State> complementOf(HashSet<State> initialStates, HashSet<State> statesToSubstract) {
		HashSet<State> complement = new HashSet<State>();
		for (State state : initialStates) {
			if (!statesToSubstract.contains(state.getStateNumber())) {
				complement.add(state);
			}
		}	
		return complement;
	}
	
	public HashSet<State> unionOf(HashSet<State> set1, List<State> set2) {
		HashSet<State> union = new HashSet<State>(set1);
		union.addAll(set2);
		return union;
	}
	
	public HashSet<State> intersectionOf(HashSet<State> set1, List<State> set2) {
		return null;
	}
	
}
