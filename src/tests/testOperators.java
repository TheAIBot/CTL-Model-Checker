package tests;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import check.Model;
import check.State;
import check.Towers;
import junit.framework.Assert;

public class testOperators {
	
	@Test
	public void testComplimentWithNonemptySet() {
		Model model = Models.getTestModel1();
		HashSet<State> differentSet = new HashSet<State>();
		differentSet.add(model.getState(1));
		differentSet.add(model.getState(2));
		HashSet<State> result = model.complementOf(differentSet);
		assertEquals(2, result.size());
		for (State state : model.getStates()) {
			if (state.getStateNumber() > 2) {
				assertTrue(result.contains(state));
			}
		}
		//Succes!
	}
	
	@Test
	public void testComplimentWithDifferenentStates() {
		Model model = Models.getTestModel1();
		//A set of states that the model doesen't contain:
		HashSet<State> differentSet = new HashSet<State>();
		differentSet.add(new State(model, 5, new String[0], new int[0]));
		differentSet.add(new State(model, 6, new String[0], new int[0]));
		HashSet<State> result = model.complementOf(differentSet);
		assertEquals(4, result.size());
		for (State state : model.getStates()) {
			assertTrue(result.contains(state));
		}
		//Succes!
	}
	
	@Test
	public void testComplimentWithEmptySet() {
		Model model = Models.getTestModel1();
		HashSet<State> result = model.complementOf(new HashSet<State>());
		assertEquals(4, result.size());
		for (State state : model.getStates()) {
			assertTrue(result.contains(state));
		}
	}
	
	@Test
	public void testIntersectionWithNonemptySet() {
		Model model = Models.getTestModel1();
		HashSet<State> differentSet = new HashSet<State>();
		differentSet.add(model.getState(1));
		differentSet.add(model.getState(2));
		HashSet<State> result = model.intersectionOf(model.getStates(), differentSet);
		assertEquals(2, result.size());
		for (State state : model.getStates()) {
			if (state.getStateNumber() <= 2) {
				assertTrue(result.contains(state));
			}
		}
		//Succes!
	}
	
	@Test
	public void testIntersectionWithDifferenentStates() {
		Model model = Models.getTestModel1();
		//A set of states that the model doesen't contain:
		HashSet<State> differentSet = new HashSet<State>();
		differentSet.add(new State(model, 5, new String[0], new int[0]));
		differentSet.add(new State(model, 6, new String[0], new int[0]));
		HashSet<State> result = model.intersectionOf(model.getStates(),differentSet);
		assertEquals(0, result.size());
		//Succes!
	}
	
	@Test
	public void testIntersectiontWithEmptySet() {
		Model model = Models.getTestModel1();
		HashSet<State> result = model.intersectionOf(model.getStates(),new HashSet<State>());
		assertEquals(0, result.size());
	}
	
	@Test
	public void testUnionWithSubset() {
		Model model = Models.getTestModel1();
		HashSet<State> subSet = new HashSet<State>();
		subSet.add(model.getState(1));
		subSet.add(model.getState(2));
		HashSet<State> result = model.unionOf(model.getStates(), subSet);
		assertEquals(4, result.size());
		for (State state : model.getStates()) {
			assertTrue(result.contains(state));
		}
		//Succes!
	}
	
	@Test
	public void testUnionWithDifferenentStates() {
		Model model = Models.getTestModel1();
		
		HashSet<State> set1 = new HashSet<State>();
		set1.add(model.getState(1));
		set1.add(model.getState(2));		
		HashSet<State> set2 = new HashSet<State>();
		set1.add(model.getState(3));
		set1.add(model.getState(4));	
		HashSet<State> result = model.unionOf(set1,set2);
		assertEquals(4, result.size());
		for (State state : model.getStates()) {
			assertTrue(result.contains(state));
		}
		//Succes!
	}
	
	@Test
	public void testUnionWithEmptySet() {
		Model model = Models.getTestModel1();
		HashSet<State> set1 = new HashSet<State>();
		set1.add(model.getState(1));
		set1.add(model.getState(2));		
		HashSet<State> result = model.unionOf(set1,new HashSet<State>());
		assertEquals(2, result.size());
		for (State state : model.getStates()) {
			if (state.getStateNumber() <= 2) {
				assertTrue(result.contains(state));				
			}
		}
	}
	
	@Test
	public void testTrueForAll() {
		//Should return all states:
		Model model = Models.getTestModel1();
		HashSet<State> result = model.trueForAll();
		assertEquals(4, result.size());
		for (State state : model.getStates()) {
			assertTrue(result.contains(state));
		}		
	}
	
	@Test
	public void testCheckContainsInitialStates() {
		//1 and 3 are initial states of test model 1:
		Model model = Models.getTestModel1();
		//Should be true:
		HashSet<State> setOfStates = new HashSet<State>(model.getStates());
		assertTrue(model.checkIncludesInitialStates(setOfStates));
		//Shouldn't matter:
		setOfStates.remove(model.getState(2));
		assertTrue(model.checkIncludesInitialStates(setOfStates));
		//Should matter:
		setOfStates.remove(model.getState(3));
		assertFalse(model.checkIncludesInitialStates(setOfStates));
		//In the same way:
		setOfStates.remove(model.getState(1));
		assertFalse(model.checkIncludesInitialStates(setOfStates));
		//And with state 3
		setOfStates.add(model.getState(3));
		assertFalse(model.checkIncludesInitialStates(setOfStates));
		//Including 1 again:
		setOfStates.add(model.getState(1));
		assertTrue(model.checkIncludesInitialStates(setOfStates));
	}
}
