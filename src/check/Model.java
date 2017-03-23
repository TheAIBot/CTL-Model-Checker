package check;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Model {
	public final HashMap<Integer, State> stateMap = new HashMap<Integer, State>();
	public final HashSet<State> states = new HashSet<State>();
	private final ArrayList<String> atomicPropositions;
	private final HashSet<State> initialStates = new HashSet<State>();
	private boolean hasBeenInitialized = false;
	
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
		final String[] labels = labelString.split(",");
		Arrays.sort(labels); // Just for the heck of it. It is nicer to debug with a sorted array.
		for (String label : labels) {
			if (!atomicPropositions.contains(label)) {
				throw new Error("Error: " + label + " is not an atomic proposition.");
			}
		}
		
		final String[] edgesStrings = edgeString.split(",");
		int[] edges = new int[edgesStrings.length];
		if (!(edges.length == 1 && edgesStrings[0].equals(""))) {//If it has edges, then:
			for (int i = 0; i < edges.length; i++) {
				if (!isInteger(edgesStrings[i])) {
					throw new Error("Error: the edges given must be integers, not: " + edgesStrings[i]);
				}
				edges[i] = Integer.parseInt(edgesStrings[i]);
			}
		} else { //Else its simply an empty integer array.
			edges = new int[0];
		}
		Arrays.sort(edges);
		// It must not contain duplicates (and it is sorted):		
		for (int i = 0; i < edges.length - 1; i++) {
			if (edges[i] >= edges[i + 1]) {
				throw new Error("Error: duplicate edges for a state is not allowed: see state " + stateNumber + " with edges " + edges[i]);
			}
		}
		//If this has been reached, it is a legal state!
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
		//The complement of the phi states:
		final HashSet<State> allButPhiStates = complementOf(phiStates);
		//All the states where one can continue to stay in states not satisfying phi:
		final HashSet<State> notValidStates = EG(allButPhiStates);
		//And then, finding the complement and thus all the states where one eventually is forced to go to a state satisfying phi:
		final HashSet<State> validStates = complementOf(notValidStates);
		//And then returned:
		return validStates;
	}
	
	public HashSet<State> AG(final HashSet<State> phiStates) {
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
				state.connectedStates.stream().allMatch(x -> phiStates.contains(x))) {
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
	
	public HashSet<State> complementOf(final HashSet<State> statesToSubstract) {
		return states.stream().filter(x -> !statesToSubstract.contains(x)).collect(Collectors.toCollection(HashSet::new));
	}
	
	public HashSet<State> unionOf(final HashSet<State> set1, final HashSet<State> set2) {
		final HashSet<State> union = new HashSet<State>(set1);
		union.addAll(set2);
		return union;
	}
	
	public HashSet<State> intersectionOf(final HashSet<State> set1, final HashSet<State> differentSet) {
		final HashSet<State> intersection = new HashSet<State>();
		for (State state : set1) {
			if (differentSet.contains(state)) {
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
		final ArrayList<State> stateList = new ArrayList<State>(states);
		
		System.out.println("Printing the model: \n");
		System.out.println("Number of states: " + stateList.size() + "\n");
		System.out.println("Atomic propositions: " + atomicPropositions.toString() + "\n");
		
		Collections.sort(stateList);
		stateList.stream().forEach(x -> System.out.println(x.toString()));
	}

	public HashSet<State> tarjan(HashSet<State> phiStates) {
		//Tarjans algorithm for finding strongly connected component. 
		//Implementation of the one described on wikipedia, with a few small tweaks to give the desired result.
		final HashSet<State> statesInLoop = new HashSet<State>();
		final HashMap<Integer, Integer> statesInComponent = new HashMap<Integer, Integer>();
		final HashMap<State, Integer> tarjanComponents = new HashMap<State, Integer>();
		int superIndex = 0;
		final Stack<State> S = new Stack<State>();
		getStates().stream().forEach(x -> x.resetTarjan());
		for (State v : getStates()) {
			if (phiStates.contains(v)) {
				if (v.index == TarjanInfo.UNDEFINED) {
					superIndex = strongconnect(v, superIndex, S, statesInComponent, tarjanComponents, phiStates);
				}	
				if (v.getConnectedStates().contains(v)) {
					statesInLoop.add(v);
				}
			}
		}
		
		for (State state : tarjanComponents.keySet()) {
			Integer componentSize = statesInComponent.get(state.lowlink);
			if (componentSize != null && componentSize.intValue() > 1) {
				statesInLoop.add(state);
			}
		}
		return statesInLoop;
	}
	
	private int strongconnect(State v, int superIndex, Stack<State> S, HashMap<Integer, Integer> statesInComponent, HashMap<State, Integer> tarjanComponents, HashSet<State> phiStates) {
		v.index = superIndex;
		v.lowlink = superIndex;
		superIndex++;
		S.add(v);
		v.onStack = true;		
		for (State w : v.getConnectedStates()) {
			if (phiStates.contains(w)) {
				if (w.index == TarjanInfo.UNDEFINED) {
					superIndex = strongconnect(w, superIndex, S, statesInComponent, tarjanComponents, phiStates);
					v.lowlink = Math.min(v.lowlink, w.lowlink);
				}
				else if (w.onStack) {
					v.lowlink = Math.min(v.lowlink, w.lowlink);
				}	
			}
		}
		
		if (v.lowlink == v.index) {
			State w;
			do {
				w = S.pop();
				w.onStack = false;
				tarjanComponents.put(w, v.lowlink);
				Integer componentSize = statesInComponent.get(v.lowlink);
				statesInComponent.put(v.lowlink, (componentSize == null) ? 1 : componentSize.intValue() + 1);
			} while (w != v);
		}
		
		return superIndex;
	}
}
