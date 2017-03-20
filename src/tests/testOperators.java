package tests;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import check.Model;
import check.State;
import check.Towers;

public class testOperators {
	
	@Test
	public void testComplimentWithDiffernentStates() {
		Model model = Models.getTestModel1();
		//A set of states that the model doesen't contain:
		HashSet<State> differentSet = new HashSet<State>();
		differentSet.add(new State(model, 5, new String[0], new int[0]));
		differentSet.add(new State(model, 6, new String[0], new int[0]));
		HashSet<State> result = model.complementOf(model.getStates(),differentSet);
		assertEquals(4, result.size());
		for (State state : model.getStates()) {
			assertTrue(result.contains(state));
		}
	}
	
	@Test
	public void testComplimentWithEmptySet() {
		Model model = Models.getTestModel1();
		HashSet<State> result = model.complementOf(model.getStates(), new HashSet<State>());
		assertEquals(4, result.size());
		for (State state : model.getStates()) {
			assertTrue(result.contains(state));
		}
	}
	
	//TODO add rest of operators tests.
	
}
