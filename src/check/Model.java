package check;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import sun.net.www.content.audio.x_aiff;

public class Model {
	// TODO do not delete: ask about definition of reach, and the problems with
	// it, as discussed before. Also, whether one can assume that there are no stuck states.
	public HashMap<Integer, State> stateMap = new HashMap<Integer, State>();
	public ArrayList<State> states = new ArrayList<State>();
	private final ArrayList<String> atomicPropositions;
	private ArrayList<State> initialStates = new ArrayList<State>();

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
			try {
				int stateNumber = Integer.parseInt(stateNumberString);
				if (!stateMap.containsKey(stateNumber)) {
					System.out.println("Error: the declared start state " + stateNumber + " does not exist");
				} else {
					initialStates.add(stateMap.get(stateNumber));
				}
			} catch (Exception e) {
				System.out.println("The start state string must only contain integers, not: " + stateNumberString);
			}
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
			System.out.println("Error: state numbers must not be less than zero");
		}
		if (stateMap.containsKey(stateNumber)) {
			System.out.println("Error: cannot insert state " + stateNumber + " twice.");
		}
		String[] labels = labelString.split(",");// (*) Remember to check for
													// duplicates!
		String[] edgesStrings = edgeString.split(",");
		Arrays.sort(labels); // Just for the heck of it.
		for (String label : labels) {
			if (!atomicPropositions.contains(label)) {
				System.out.println("Error: " + label + " is not an atomic proposition.");
			}
		}
		int[] edges = new int[edgesStrings.length];
		for (int i = 0; i < edges.length; i++) {
			try {
				edges[i] = Integer.parseInt(edgesStrings[i]);
			} catch (Exception e) {
				System.out.println("Error: the edges given must be integers, not: " + edgesStrings[i]);
				return;
			}
		}
		Arrays.sort(edges);
		// It must not contain duplicates (and it is sorted):
		for (int i = 0; i < edges.length - 1; i++) {
			if (edges[i] >= edges[i + 1]) {
				System.out.println("Error: duplicate edges for a state is not allowed: see state " + stateNumber + " with edges " + edges[i]);
				return;
			}
		}
		State newState = new State(this, stateNumber, labels, edges);
		stateMap.put(newState.getStateNumber(), newState);
		states.add(newState);
	}
	
	public List<State> AllDiamondsAreUnbreakable(List<State> phiStates){
		//TODO will not work in the case that there exists stuck states. 
		List<State> allButPhiStates = complementOf(states, phiStates);
		List<State> notValidStates = EG(allButPhiStates);
		List<State> validStates = complementOf(states, notValidStates);
		return validStates;
	}
	
	public List<State> AG(List<State> phiStates) {
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
			if (!state.connectedStates.isEmpty() && isSuperSet(state.connectedStates,hashedPhiStates)) {
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

	public List<State> complementOf(List<State> initialStates, List<State> statesToSubstract) {
		ArrayList<State> complement = new ArrayList<State>();
		HashSet<Integer> hashedStatesToSubstract = new HashSet<Integer>();
		statesToSubstract.stream().forEach(x -> hashedStatesToSubstract.add(x.getStateNumber()));
		for (State state : states) {
			if (!hashedStatesToSubstract.contains(state.getStateNumber())) {
				complement.add(state);
			}
		}	
		return complement;
	}
	
	public List<State> unionOf(List<State> set1, List<State> set2) {
		List<State> union = new ArrayList<State>(set1);
		HashSet<Integer> hashedSet = new HashSet<Integer>();
		//Check for size to do the minimum number of operations necessary.
		if (set1.size() > set2.size()) {
			set1.stream().forEach(state -> hashedSet.add(state.getStateNumber()));
			set2.stream().filter(state -> !hashedSet.contains(state.getStateNumber())).
						  forEach(state -> union.add(state));
			return set1;
		} else {//The other way around:
			set2.stream().forEach(state -> hashedSet.add(state.getStateNumber()));
			set1.stream().filter(state -> !hashedSet.contains(state.getStateNumber())).
						  forEach(state -> union.add(state));
			return set2;
		}		
	}
	
	public List<State> intersectionOf(List<State> set1, List<State> set2) {
		return null;
	}
	
}
