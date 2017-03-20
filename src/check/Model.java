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

import com.sun.istack.internal.FinalArrayList;

public class Model {
	
	// it, as discussed before. Also, whether one can assume that there are no stuck states.
	public final HashMap<Integer, State> stateMap = new HashMap<Integer, State>();
	public final HashSet<State> states = new HashSet<State>();
	private final ArrayList<String> atomicPropositions;
	private final HashSet<State> initialStates = new HashSet<State>();
	private boolean hasBeenInitialized = false;

	/**
	 * TODO no comma as a character in the atomic propositions!
	 * 
	 * @param atomicPropositions
	 */
	public Model(final String atomicPropositionsString) {
		final Set<String> hs = new HashSet<String>();
		hs.addAll(Arrays.asList(atomicPropositionsString.split(",")));
		atomicPropositions = new ArrayList<String>(hs);
		atomicPropositions.sort(Comparator.naturalOrder());
	}

	public void setStartStates(String startStateNumbersString) {
		final String[] startStateNumbers = startStateNumbersString.split(",");
		for (String stateNumberString : startStateNumbers) {
			if (!isInteger(stateNumberString)) {
				throw new Error("The start state string must only contain integers, not: " + stateNumberString);
			}			
			final int stateNumber = Integer.parseInt(stateNumberString);
			if (!stateMap.containsKey(stateNumber)) {
				throw new Error("Error: the declared start state " + stateNumber + " does not exist");
			}			
			initialStates.add(stateMap.get(stateNumber));
		}
	}
	
	private boolean isInteger(final String maybeInteger) {
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
		hasBeenInitialized = true;
	}

	public void addState(final int stateNumber, final String labelString, final String edgeString) {
		if (hasBeenInitialized) {
			throw new Error("Error: one must not add a new state to the transition system after it has been initialized.");
		}
		if (stateNumber < 0) {
			throw new Error("Error: state numbers must not be less than zero");
		}
		if (stateMap.containsKey(stateNumber)) {
			throw new Error("Error: cannot insert state " + stateNumber + " twice.");
		}
		final String[] labels = labelString.split(",");//TODO (*) Remember to check for duplicates!
		Arrays.sort(labels); // Just for the heck of it.
		for (String label : labels) {
			if (!atomicPropositions.contains(label)) {
				throw new Error("Error: " + label + " is not an atomic proposition.");
			}
		}
		
		final String[] edgesStrings = edgeString.split(",");
		int[] edges = new int[edgesStrings.length];
		if (!(edges.length == 1 && edgesStrings[0].equals(""))) {
			//If it has edges, then:
			for (int i = 0; i < edges.length; i++) {
				if (!isInteger(edgesStrings[i])) {
					throw new Error("Error: the edges given must be integers, not: " + edgesStrings[i]);
				}
				edges[i] = Integer.parseInt(edgesStrings[i]);
			}
		} else {
			edges = new int[0];
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
	
	public HashSet<State> getStatesWithLabel(String labelToFind) {
		final HashSet<State> result = new HashSet<State>();
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
	
	public HashSet<State> AF(final HashSet<State> phiStates){
		//TODO will not work in the case that there exists stuck states.
		//All the states coming from a path of infinite lenght:
		final HashSet<State> allButPhiStates = complementOf(states, phiStates);
		//System.out.println("All but phi states:");
		//System.out.println((new ArrayList<State>(allButPhiStates)).toString());
		final HashSet<State> notValidStates = EG(allButPhiStates);
		//System.out.println("Not valid states:");
		//System.out.println((new ArrayList<State>(notValidStates)).toString());
		final HashSet<State> validStates = complementOf(states, notValidStates);
		//System.out.println("Valid states:");
		//System.out.println((new ArrayList<State>(validStates)).toString());
		//A finite length path:
		//TODO (*) Make
		return validStates;
	}
	
	public HashSet<State> AG(final HashSet<State> phiStates) {
		//Check om korrekt.
		final HashSet<State> validStates = new HashSet<State>();
		for (State state : states) {
			if (isSuperSet(state.getReachableStates(),phiStates)) { 
				//TODO discuss with the professor, if this is correct, even when not all states have transitions.
				validStates.add(state);
			}
		}
		return validStates;
	}

	public HashSet<State> AX(final HashSet<State> phiStates) {
		final HashSet<State> validStates = new HashSet<State>();
		for (State state : states) {
			if (!state.connectedStates.isEmpty() && 
				isSuperSet(state.connectedStates,phiStates)) {
				validStates.add(state);
			}
		}
		return validStates;
	}

	public HashSet<State> EX(final HashSet<State> phiStates) {
		return states.stream().filter(x -> x.getConnectedStates().stream().anyMatch(y -> phiStates.contains(y))).collect(Collectors.toCollection(HashSet::new));
	}

	public HashSet<State> EF(final HashSet<State> phiStates) {
		return states.stream().filter(x -> x.getReachableStates().stream().anyMatch(y -> phiStates.contains(y))).collect(Collectors.toCollection(HashSet::new));
	}

	public HashSet<State> EG(final HashSet<State> phiStates) {
		return states.stream().filter(x -> x.canReachPhiLoop(phiStates) || x.canFollowPhiToStuckPhiState(phiStates)).collect(Collectors.toCollection(HashSet::new));
	}

	private boolean isSuperSet(final HashSet<State> subSet, final HashSet<State> superSet) {
		for (State state : subSet) {
			if (!superSet.contains(state)) {
				return false;
			}
		}
		return true;

	}
	
	public boolean checkIncludesInitialStates(final HashSet<State> superSet) {
		return isSuperSet(initialStates, superSet);
	}

	public HashSet<State> getStates() {
		return states;
	}
	
	public State getState(final int stateNumber) {
		return stateMap.get(stateNumber);
	}
	
	public HashSet<State> complementOf(final HashSet<State> initialStates, final HashSet<State> statesToSubstract) {
		final HashSet<State> complement = new HashSet<State>();
		for (State state : initialStates) {
			if (!statesToSubstract.contains(state)) {
				complement.add(state);
			}
		}	
		return complement;
	}
	
	public HashSet<State> unionOf(final HashSet<State> set1, final List<State> set2) {
		final HashSet<State> union = new HashSet<State>(set1);
		union.addAll(set2);
		return union;
	}
	
	public HashSet<State> intersectionOf(final HashSet<State> set1, final List<State> set2) {
		final HashSet<State> intersection = new HashSet<State>();
		for (State state : set1) {
			if (!set2.contains(state)) {
				intersection.add(state);
			}
		}
		return intersection;
	}
	
	public HashSet<State> trueForAll() {
		//All states should be returned:
		return new HashSet<State>(states);		
	}
	
	public void prettyPrint() {
		//Print all the information about the states out: 
		//An arraylist so the states can be sorted after state numbers:
		//TODO test this(*)
		final ArrayList<State> stateList = new ArrayList<State>(states);
		
		System.out.println("Printing the model: \n");
		System.out.println("Number of states: " + stateList.size() + "\n");
		System.out.println("Atomic propositions: " + atomicPropositions.toString() + "\n");
		
		Collections.sort(stateList);
		stateList.stream().forEach(x -> System.out.println(x.toString()));
	}
}
