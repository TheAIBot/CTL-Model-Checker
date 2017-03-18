package check;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class State implements Comparable<State>{
	private final Model model;
	private final int stateNumber;
	public final String[] labels;
	public final int[] edges;
	public final HashSet<State> connectedStates = new HashSet<State>();
	
	public State(Model model, int stateNumber, String[] labels, int[] edges) {
		this.model = model;
		this.stateNumber = stateNumber;
		this.labels = labels;
		this.edges = edges;
	}
	
	public HashSet<State> getReachableStates() {
		HashSet<State> reachableStates = new HashSet<State>();
		// Using breadth first, iteratively:
		Queue<State> statesToVisit = new LinkedList<State>();
		//Starting from this state:
		statesToVisit.add(this);
		reachableStates.add(this);
		//TODO check for error in the case of a starting selfloop
		while (!statesToVisit.isEmpty()) {
			State currentState = statesToVisit.poll();
			for (State state : currentState.getConnectedStates()) {
				if (!reachableStates.contains(state)) {
					statesToVisit.add(state);
					reachableStates.add(state);
				}
			}
		}
		return reachableStates;
	}
	
	public boolean canReachPhiLoop(HashSet<State> phi) {
		// Using breadth first, iteratively:
		Queue<State> statesToVisit = new LinkedList<State>();
		//The starting state needs to be a phi state:
		if (!phi.contains(this)) {
			return false;
		}		
		//TODO check for errors in the case of a starting self loop.
		
		statesToVisit.add(this); //Starting from this state.
		HashSet<State> hasSeen = new HashSet<State>(); //No visiting the same state twice.
		hasSeen.add(this);
		
		while (!statesToVisit.isEmpty()) {
			State currentState = statesToVisit.poll();
			for (State neighbor : currentState.getConnectedStates()) {
				if (phi.contains(neighbor)) {
					if (hasSeen.contains(neighbor)) {//If it has already been seen and is a phi state, then there is a loop!
						return true;
					} else {//Else we continue:
						statesToVisit.add(neighbor);
						hasSeen.add(neighbor);						
					}
				}
			}
		}

		return false;
	}
	
	public boolean canFollowPhiToStuckPhiState(HashSet<State> phi) {
		// Using breadth first, iteratively:
		Queue<State> statesToVisit = new LinkedList<State>();
		//The starting state needs to be a phi state:
		if (!phi.contains(this)) {
			return false;
		}		
		//TODO check for errors in the case of a starting self loop.		
		statesToVisit.add(this); //Starting from this state.
		HashSet<State> hasSeen = new HashSet<State>(); //No visiting the same state twice.
		hasSeen.add(this);
		
		while (!statesToVisit.isEmpty()) {
			State currentState = statesToVisit.poll();
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
	
	private State getNeighbor(int neighborID) {
		State neighbor = model.stateMap.get(neighborID);
		if (neighbor == null) {
			throw new Error("Error");
		}
		return neighbor;
	}
	
	public int getStateNumber() {
		return this.stateNumber;
	}
	
	@Override
	public boolean equals(Object b) {
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
		String stateAsString =  "State " + stateNumber + ":\n";
		//Adding Labels:
		stateAsString = stateAsString + "Labels: ";
		for (int i = 0; i < labels.length - 1; i++) {
			stateAsString += labels[i] + ", ";
		}
		if (labels.length > 0) {
			stateAsString += labels[labels.length - 1];
		}
		stateAsString += "\n";
		//Adding edges/transitions:
		stateAsString += "Edges/transitions: ";
		for (int i = 0; i < edges.length - 1; i++) {
			stateAsString += edges[i] + ", ";
		}
		if (edges.length > 0) {
			stateAsString += edges[edges.length - 1];
		}		
		stateAsString+= "\n";
		return stateAsString;
	}
	
	@Override
	public int compareTo(State otherState) {
		return ((Integer) stateNumber).compareTo(otherState.getStateNumber());
	}
}
