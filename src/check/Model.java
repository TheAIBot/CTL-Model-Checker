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
	private final ArrayList<String> atomicPropositions = new ArrayList<String>();
	private final HashSet<State> initialStates = new HashSet<State>();
	private boolean hasBeenInitialized = false;

	public Model(final String atomicPropositionsString) {
		//(*)can't add propositions at the start anymore
		/*
		final Set<String> hs = new HashSet<String>();
		hs.addAll(Arrays.asList(atomicPropositionsString.split(",")));
		atomicPropositions = new ArrayList<String>(hs);
		atomicPropositions.sort(Comparator.naturalOrder());
		*/
	}

	public void setStartStates(String startStateNumbersString) {
		final String[] startStateNumbers = startStateNumbersString.split(",");
		initialStates.clear();

		if (startStateNumbers.length == 1 && startStateNumbers[0].trim() == "") {
			return;
		}

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
		// If it is valid:
		for (State state : states) {
			state.readyNeighborList();
		}
		hasBeenInitialized = true;
	}
	public void addState(final int stateNumber, final String labelString, final String edgeString) {
		addState(stateNumber, labelString, edgeString, false);
	}

	public void addState(final int stateNumber, final String labelString, final String edgeString, boolean isStartState) {
		if (hasBeenInitialized) {
			throw new Error(
					"Error: one must not add a new state to the transition system after it has been initialized.");
		}
		if (stateNumber < 0) {
			throw new Error("Error: state numbers must not be less than zero");
		}
		if (stateMap.containsKey(stateNumber)) {
			throw new Error("Error: cannot insert state " + stateNumber + " twice.");
		}
		final String[] labels = labelString.split(",");
		Arrays.sort(labels); // Just for the heck of it. It is nicer to debug
								// with a sorted array.
		for (String label : labels) {
			//(*) can't add labels at the start anymore
			if (!atomicPropositions.contains(label)) {
				atomicPropositions.add(label);
			}
			/*
			if (!atomicPropositions.contains(label)) {
				throw new Error("Error: " + label + " is not an atomic proposition.");
			}
			*/
		}

		final String[] edgesStrings = edgeString.split(",");
		int[] edges = new int[edgesStrings.length];
		if (!(edges.length == 1 && edgesStrings[0].equals(""))) {// If it has
																	// edges,
																	// then:
			for (int i = 0; i < edges.length; i++) {
				if (!isInteger(edgesStrings[i])) {
					throw new Error("Error: the edges given must be integers, not: " + edgesStrings[i]);
				}
				edges[i] = Integer.parseInt(edgesStrings[i]);
			}
		} else { // Else its simply an empty integer array.
			edges = new int[0];
		}
		Arrays.sort(edges);
		// It must not contain duplicates (and it is sorted):
		for (int i = 0; i < edges.length - 1; i++) {
			if (edges[i] >= edges[i + 1]) {
				throw new Error("Error: duplicate edges for a state is not allowed: see state " + stateNumber
						+ " with edges " + edges[i]);
			}
		}
		// If this has been reached, it is a legal state!
		final State newState = new State(this, stateNumber, labels, edges);
		stateMap.put(newState.getStateNumber(), newState);
		states.add(newState);
		//(*)add to initials state if true
		if (isStartState) {
			initialStates.add(newState);
		}
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

	public HashSet<State> AF(final HashSet<State> phiStates) {
		// The complement of the phi states:
		final HashSet<State> allButPhiStates = complementOf(phiStates);
		// All the states where one can continue to stay in states not
		// satisfying phi:
		final HashSet<State> notValidStates = EG(allButPhiStates);
		// And then, finding the complement and thus all the states where one
		// eventually is forced to go to a state satisfying phi:
		final HashSet<State> validStates = complementOf(notValidStates);
		// And then returned:
		return validStates;
	}

	public HashSet<State> AG(final HashSet<State> phiStates) {
		final HashSet<State> validStates = new HashSet<State>();
		for (State state : states) {
			if (isSuperSet(state.getReachableStates(), phiStates)) {
				validStates.add(state);
			}
		}
		return validStates;
	}

	public HashSet<State> AX(final HashSet<State> phiStates) {
		final HashSet<State> validStates = new HashSet<State>();
		for (State state : states) {
			if (!state.connectedStates.isEmpty() && isSuperSet(state.connectedStates, phiStates)) {
				validStates.add(state);
			}
		}
		return validStates;
	}

	public HashSet<State> EX(final HashSet<State> phiStates) {
		return states.stream().filter(x -> x.getConnectedStates().stream()
			   .anyMatch(y -> phiStates.contains(y)))
			   .collect(Collectors.toCollection(HashSet::new));
	}

	public HashSet<State> EF(final HashSet<State> phiStates) {
		return states.stream().filter(x -> x.getReachableStates().stream()
				.anyMatch(y -> phiStates.contains(y)))
				.collect(Collectors.toCollection(HashSet::new));
	}

	public HashSet<State> EG(final HashSet<State> phiStates) {
		return states.stream().filter(x -> x.canReachPhiLoop(phiStates) ||
			   x.canFollowPhiToStuckPhiState(phiStates))
			   .collect(Collectors.toCollection(HashSet::new));
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
		return states.stream().filter(x -> !statesToSubstract.contains(x))
				.collect(Collectors.toCollection(HashSet::new));
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
		// All states should be returned:
		return new HashSet<State>(states);
	}

	public void prettyPrint() {
		// Print all the information about the states out:
		// An arraylist so the states can be sorted after state numbers:
		final ArrayList<State> stateList = new ArrayList<State>(states);

		System.out.println("Printing the model: \n");
		System.out.println("Number of states: " + stateList.size() + "\n");
		System.out.println("Atomic propositions: " + atomicPropositions.toString() + "\n");

		Collections.sort(stateList);
		stateList.stream().forEach(x -> System.out.println(x.toString()));
	}

	public HashSet<State> tarjan(HashSet<State> phiStates) {
		// Tarjans algorithm for finding strongly connected component.
		// Implementation of the one described on wikipedia, with a few small
		// tweaks to give the desired result.
		final HashSet<State> statesInLoop = new HashSet<State>();
		final HashMap<Integer, Integer> statesInComponent = new HashMap<Integer, Integer>();
		final HashMap<State, Integer> tarjanComponents = new HashMap<State, Integer>();
		int superIndex = 0;
		final Stack<State> loopStatesStack = new Stack<State>();
		getStates().stream().forEach(x -> x.resetTarjan());
		for (State stateToCheck : getStates()) {
			if (phiStates.contains(stateToCheck)) {
				if (stateToCheck.tarjanIndex == TarjanInfo.TARJAN_UNDEFINED) {
					superIndex = strongconnect(stateToCheck, superIndex, loopStatesStack, statesInComponent,
							tarjanComponents, phiStates);
				}
				if (stateToCheck.getConnectedStates().contains(stateToCheck)) {
					statesInLoop.add(stateToCheck);
				}
			}
		}

		for (State state : tarjanComponents.keySet()) {
			Integer componentSize = statesInComponent.get(state.tarjanLowlink);
			if (componentSize != null && componentSize.intValue() > 1) {
				statesInLoop.add(state);
			}
		}
		return statesInLoop;
	}

	private int strongconnect(State stateToCheck, int superIndex, Stack<State> loopStatesStack,
			HashMap<Integer, Integer> statesInComponent, HashMap<State, Integer> tarjanComponents,
			HashSet<State> phiStates) {
		stateToCheck.tarjanIndex = superIndex;
		stateToCheck.tarjanLowlink = superIndex;
		superIndex++;
		loopStatesStack.add(stateToCheck);
		stateToCheck.tarjanOnStack = true;

		for (State transitionState : stateToCheck.getConnectedStates()) {
			if (phiStates.contains(transitionState)) {
				if (transitionState.tarjanIndex == TarjanInfo.TARJAN_UNDEFINED) {
					superIndex = strongconnect(transitionState, superIndex, loopStatesStack, statesInComponent,
							tarjanComponents, phiStates);
					stateToCheck.tarjanLowlink = Math.min(stateToCheck.tarjanLowlink, transitionState.tarjanLowlink);
				} else if (transitionState.tarjanOnStack) {
					stateToCheck.tarjanLowlink = Math.min(stateToCheck.tarjanLowlink, transitionState.tarjanLowlink);
				}
			}
		}

		if (stateToCheck.tarjanLowlink == stateToCheck.tarjanIndex) {
			State stateOnLoopStack;
			do {
				stateOnLoopStack = loopStatesStack.pop();
				stateOnLoopStack.tarjanOnStack = false;
				tarjanComponents.put(stateOnLoopStack, stateToCheck.tarjanLowlink);
				Integer componentSize = statesInComponent.get(stateToCheck.tarjanLowlink);
				statesInComponent.put(stateToCheck.tarjanLowlink,
						(componentSize == null) ? 1 : componentSize.intValue() + 1);
			} while (stateOnLoopStack != stateToCheck);
		}

		return superIndex;
	}
}
