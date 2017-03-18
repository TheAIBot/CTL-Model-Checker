package check;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

	public void checkIsModelValid() {
		for (State state : states) {
			for (int edge : state.edges) {
				if (!stateMap.containsKey(edge)) {
					throw new Error("Model is not valid: state " + edge + " does not exist");
				}
			}
		}
	}

	public void initialize() {
		checkIsModelValid();
		//If it is valid:
		for (State state : states) {
			state.readyNeighborList();
		}
	}

	public void addState(int stateNumber, String labelString, String edgeString) {
		if (stateNumber < 0) {
			throw new Error("Error: state numbers must not be less than zero");
		}
		if (stateMap.containsKey(stateNumber)) {
			throw new Error("Error: cannot insert state " + stateNumber + " twice.");
		}
		String[] labels = labelString.split(",");//TODO (*) Remember to check for
													// duplicates!
		String[] edgesStrings = edgeString.split(",");
		Arrays.sort(labels); // Just for the heck of it.
		for (String label : labels) {
			if (!atomicPropositions.contains(label)) {
				throw new Error("Error: " + label + " is not an atomic proposition.");
			}
		}
		int[] edges = new int[edgesStrings.length];
		if (!(edges.length == 1 && edgesStrings[0].equals(""))) {
			//If it has edges, then:
			for (int i = 0; i < edges.length; i++) {
				if (!isInteger(edgesStrings[i])) {
					throw new Error("Error: the edges given must be integers, not: " + edgesStrings[i]);
				}
				edges[i] = Integer.parseInt(edgesStrings[i]);
			}
		} else edges = new int[0];
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
	
	public HashSet<State> getStatesWithLabel(String labelToFind) {
		HashSet<State> result = new HashSet<State>();
		for (State state : states) {
			for (String label : state.labels) {
				if (label.equals(labelToFind)) {
					result.add(state);
					break;
				}
			}
		}
		return result;
	}
	
	public HashSet<State> AF(HashSet<State> phiStates){
		//TODO will not work in the case that there exists stuck states. 
		HashSet<State> allButPhiStates = complementOf(states, phiStates);
		HashSet<State> notValidStates = EG(allButPhiStates);
		HashSet<State> validStates = complementOf(states, notValidStates);
		return validStates;
	}
	
	public HashSet<State> AG(HashSet<State> phiStates) {
		//Check om korrekt.
		HashSet<State> validStates = new HashSet<State>();
		for (State state : states) {
			if (isSuperSet(state.getReachableStates(),phiStates)) { 
				//TODO discuss with the professor, if this is correct, even when not all states have transitions.
				validStates.add(state);
			}
		}
		return validStates;
	}

	public HashSet<State> AO(HashSet<State> phiStates) {
		HashSet<State> validStates = new HashSet<State>();
		for (State state : states) {
			if (!state.connectedStates.isEmpty() && 
				isSuperSet(state.connectedStates,phiStates)) {
				validStates.add(state);
			}
		}
		return validStates;
	}

	public HashSet<State> EX(HashSet<State> phiStates) {	
		//TODO segmenter den, eller lav den om til flere linjer.
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
			if (!statesToSubstract.contains(state)) {
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
	
	public void prettyPrint() {
		//Print all the information about the states out: 
		//An arraylist so the states can be sorted after state numbers:
		//TODO test this(*)
		ArrayList<State> stateList = new ArrayList<State>(states);
		System.out.println("Printing the model: \n");
		
		System.out.println("Number of states: " + stateList.size() + "\n");
		
		System.out.println("Atomic propositions: " + atomicPropositions.toString() + "\n");
		
		Collections.sort(stateList);
		for (int i = 0; i < stateList.size(); i++) {
			System.out.println(stateList.get(i).toString());			
		}
	}
}
