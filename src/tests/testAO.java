package tests;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

import check.*;

public class testAO {
	
	@Test
	public void testGoToVowel() {
		Model model = Towers.getTestModel();
		//The only state that is forced to go to a vowel, is 1:
		HashSet<State> result = model.AO(model.getStatesWithLabel("v"));
		assertEquals(1, result.size());
		assertTrue(result.contains(model.getState(1)));
	}
	
	@Test
	public void testGoToConsonant() {
		Model model = Towers.getTestModel();
		//The only states that are forced to go to consonants, are 3 and 4:
		HashSet<State> result = model.AO(model.getStatesWithLabel("c"));
		assertEquals(2, result.size());
		assertTrue(result.contains(model.getState(3)));
		assertTrue(result.contains(model.getState(4)));
	}
	
	@Test
	public void testGoToNonexistentState() {
		Model model = Towers.getTestModel();
		//There are no states with label "kage", so the result should have size 0:
		HashSet<State> result = model.AO(model.getStatesWithLabel("kage"));
		assertEquals(0, result.size());
	}
	
	@Test
	public void testNodesWithNoEdgesNotIncluded() {
		//TODO add this test to all methods. Discuss.
		Model model = new Model("a,b");
		try {
			model.addState(1, "a", "");
			model.initialize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
		HashSet<State> result = model.AO(model.getStatesWithLabel("a"));
		assertEquals(0, result.size());
	}
	
	@Test
	public void testSelfLoopState() {
		//TODO add this test to all methods. Discuss.
		Model model = new Model("a,b");
		try {
			model.addState(1, "a", "1");
			model.initialize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
		//It should give itself:
		HashSet<State> result = model.AO(model.getStatesWithLabel("a"));
		assertEquals(1, result.size());
		assertTrue(result.contains(model.getState(1)));
	}

}
