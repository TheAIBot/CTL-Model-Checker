package check;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class State extends TarjanInfo implements Comparable<State>{
	private final Model model;
	private final int stateNumber;
	public final String[] labels;
	public final int[] edges;
	public final HashSet<State> connectedStates = new HashSet<State>();
	
	public State(final Model model, final int stateNumber, final String[] labels, final int[] edges) {
		this.model = model;
		this.stateNumber = stateNumber;
		this.labels = labels;
		this.edges = edges;
	}
	
	public HashSet<State> getReachableStates() {
		final HashSet<State> reachableStates = new HashSet<State>();
		// Using breadth first, iteratively:
		final Queue<State> statesToVisit = new LinkedList<State>();
		//Starting from this state:
		statesToVisit.add(this);
		reachableStates.add(this);
		//TODO check for error in the case of a starting selfloop
		while (!statesToVisit.isEmpty()) {
			final State currentState = statesToVisit.poll();
			for (State state : currentState.getConnectedStates()) {
				if (!reachableStates.contains(state)) {
					statesToVisit.add(state);
					reachableStates.add(state);
				}
			}
		}
		return reachableStates;
	}
	
	public boolean canReachPhiLoop(final HashSet<State> phi) {
		HashSet<State> statesInLoops = model.tarjan(phi);
		HashSet<State> reachedStates = getReachableStates();
		return reachedStates.stream().anyMatch(x -> statesInLoops.contains(x));
	}
		
	public boolean canFollowPhiToStuckPhiState(final HashSet<State> phi) {
		final Queue<State> statesToVisit = new LinkedList<State>();
		//The starting state needs to be a phi state:
		if (!phi.contains(this)) {
			return false;
		}				
		statesToVisit.add(this); //Starting from this state.
		final HashSet<State> hasSeen = new HashSet<State>(); //No visiting the same state twice.
		hasSeen.add(this);
		
		while (!statesToVisit.isEmpty()) {
			final State currentState = statesToVisit.poll();
			//If it has no neighbors/possible transitions, victory has been attained, 
			//as it is also a phi state.
			if (currentState.getConnectedStates().size() == 0) {
				return true;
			}			
			for (State state : currentState.getConnectedStates()) {
				if (!hasSeen.contains(state) && phi.contains(state)) {
					statesToVisit.add(state);
					hasSeen.add(state);
				}
			}
		}
		return false;
	}
	
	public void setNeighbors() {
		connectedStates.clear();
		for (int edge : edges) {
			connectedStates.add(this.getNeighbor(edge));
		}
	}
	
	public void readyNeighborList() {
		for (int edge : edges) {
			connectedStates.add(model.stateMap.get(edge));
		}
	}
	
	public HashSet<State> getConnectedStates() {
		return connectedStates;
	}
	
	private State getNeighbor(final int neighborID) {
		final State neighbor = model.stateMap.get(neighborID);
		if (neighbor == null) {
			throw new Error("Error");
		}
		return neighbor;
	}
	
	public int getStateNumber() {
		return this.stateNumber;
	}
	
	@Override
	public boolean equals(final Object b) {
		if (b == null) {
			return false;
		}
		if (b instanceof State) {
			State bb = (State) b;
			return bb.getStateNumber() == this.getStateNumber();
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return this.getStateNumber();
	}
	
	public String toString() {
		final StringBuilder sBuilder = new StringBuilder();
		
		//write state number
		sBuilder.append("State: ");
		sBuilder.append(stateNumber);
		sBuilder.append("\n");
		
		//write all labels
		sBuilder.append("Labels: ");
		sBuilder.append(Arrays.toString(labels));
		sBuilder.append("\n");
		
		//write all transitions
		sBuilder.append("Transitions ");
		sBuilder.append(Arrays.toString(edges));
		sBuilder.append("\n");
		
		return sBuilder.toString();
	}
	
	@Override
	public int compareTo(State otherState) {
		return ((Integer) stateNumber).compareTo(otherState.getStateNumber());
	}
}
