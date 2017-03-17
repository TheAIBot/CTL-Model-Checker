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
	// TODO do not delete: ask about definition of reach, and the problems with
	// it, as discussed before.
	public final HashMap<Integer, State> stateMap = new HashMap<Integer, State>();
	public final ArrayList<State> states = new ArrayList<State>();
	private final ArrayList<String> atomicPropositions;
	private final ArrayList<State> initialStates = new ArrayList<State>();

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
	
	public ArrayList<State> AG(ArrayList<State> phiStates) {
		ArrayList<State> validStates = new ArrayList<State>();
		HashSet<Integer> hashedPhiStates = new HashSet<Integer>();
		for (State phiState : phiStates) {
			hashedPhiStates.add(phiState.getStateNumber());
		}
		for (State state : states) {
			if (isSuperSet(state.getReachableStates(),hashedPhiStates)) {
				validStates.add(state);
			}
		}
		return validStates;
	}

	public List<State> AO(List<State> phiStates) {
		ArrayList<State> validStates = new ArrayList<State>();
		HashSet<Integer> hashedPhiStates = new HashSet<Integer>();
		for (State phiState : phiStates) {
			hashedPhiStates.add(phiState.getStateNumber());
		}
		for (State state : states) {
			if (isSuperSet(state.connectedStates, hashedPhiStates)) {
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

	private boolean isSuperSet(List<State> subSet, HashSet<Integer> hashedSuperSet) {
		for (State state : subSet) {
			if (!hashedSuperSet.contains(state.getStateNumber())) {
				return false;
			}
		}
		return true;

	}

	private boolean isSuperSet(List<State> subSet, List<State> superSet) {
		HashSet<Integer> hashedSuperSet = new HashSet<Integer>();
		for (State state : superSet) {
			hashedSuperSet.add(state.getStateNumber());
		}
		return isSuperSet(subSet, hashedSuperSet);
	}

	public boolean checkIncludesInitialStates(ArrayList<State> superSet) {
		if (isSuperSet(initialStates, superSet)) {
			return true;
		} else
			return false;
	}

	public List<State> getStates() {
		return states;
	}
	
	public State getState(int stateNumber) {
		return stateMap.get(stateNumber);
	}
}
