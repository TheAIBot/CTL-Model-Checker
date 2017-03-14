import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class State {
	private final Model model;
	public final String[] labels;
	public final int[] edges;
	private final int stateNumber; 
	public ArrayList<State> connectedStates = new ArrayList<State>();
	
	public State(Model model, int stateNumber, String[] labels, int[] edges) {
		this.model = model;
		this.stateNumber = stateNumber;
		this.labels = labels;
		this.edges = edges;
	}
	
	public List<State> getReachableStates(){
		ArrayList<State> reachableStates = new ArrayList<State>();
		//Using breadth first, iteratively:
		Queue<State> statesToVisit = new LinkedList<State>();
		HashSet<Integer> hasSeen = new HashSet<Integer>();
		statesToVisit.add(this);
		while (!statesToVisit.isEmpty()) {
			State currentState = statesToVisit.poll();
			for (State state : currentState.connectedStates) {
				if (!hasSeen.contains(state.getStateNumber())) {
					statesToVisit.add(state);
					hasSeen.add(state.getStateNumber());
					reachableStates.add(state);
				}
			}
		}	
		
		return reachableStates;
	}
	
	public 

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
	
	public ArrayList<State> getConnectedStates(){
		return connectedStates;
	}
	
	private State getNeighbor(int neighborID) {		
		State neighbor = model.stateMap.get(neighborID);
		if (neighbor == null) {
			System.out.println("Error");
		}
		return neighbor;
	}
	
	public int getStateNumber() {
		return this.stateNumber;
	}
}
