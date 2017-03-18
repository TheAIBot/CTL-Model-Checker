package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;

import org.junit.Test;

import check.Model;
import check.State;
import check.Towers;

public class testAG {


	@Test
	public void testGoToVowel() {
		Model model = Towers.getTestModel();
		//There are no states where all paths from them will make them stay on a vowel.
		HashSet<State> result = model.AG(model.getStatesWithLabel("v"));
		assertEquals(0, result.size());
	}
	
	@Test
	public void testGoToConsonant() {
		Model model = Towers.getTestModel();
		//Only state 3 and 4 will for all paths stay on a consonant.
		HashSet<State> result = model.AG(model.getStatesWithLabel("c"));
		assertEquals(2, result.size());
		assertTrue(result.contains(model.getState(3)));
		assertTrue(result.contains(model.getState(4)));
	}

	@Test
	public void testGoToNonexistentState() {
		Model model = Towers.getTestModel();
		//There are no states with label "kage", so the result should be of size 0:
		HashSet<State> result = model.AG(model.getStatesWithLabel("kage"));
		assertEquals(0, result.size());
	}
	
	@Test
	public void testNodesWithNoEdges() {
		Model model = new Model("a,b");
		try {
			model.addState(1, "a", "");
			model.addState(2, "b", "1");
			model.initialize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
		//Only state 1 should be included:
		HashSet<State> result = model.AG(model.getStatesWithLabel("a"));
		assertEquals(1, result.size());
		assertTrue(result.contains(model.getState(1)));
	}
	
	@Test
	public void testSelfLoopState() {
		Model model = new Model("a,b");
		try {
			model.addState(1, "a", "1");
			model.initialize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
		//It should give itself:
		HashSet<State> result = model.AG(model.getStatesWithLabel("a"));
		assertEquals(1, result.size());
		assertTrue(result.contains(model.getState(1)));
	}
	
	
}
