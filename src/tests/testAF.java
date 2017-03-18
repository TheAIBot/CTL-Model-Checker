package tests;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import check.Model;
import check.State;
import check.Towers;

public class testAF {
	//TODO tested the wrong method.

	@Test
	public void testGoToVowel() {
		Model model = Models.getTestModel1();
		//Only for the two vowel states will all paths beginning in them eventually meet a vowel state.
		HashSet<State> result = model.AF(model.getStatesWithLabel("v"));
		assertEquals(2, result.size());
		assertTrue(result.contains(model.getState(1)));
		assertTrue(result.contains(model.getState(2)));
	}
	
	@Test
	public void testGoToConsonant() {
		Model model = Models.getTestModel1();
		//Only the nodes with the consonant label, will be forced to go to a node with a consonant label eventually:
		HashSet<State> result = model.AF(model.getStatesWithLabel("c"));
		assertEquals(2, result.size());
		assertTrue(result.contains(model.getState(3)));
		assertTrue(result.contains(model.getState(4)));
	}
	
	@Test
	public void testLongPath() {
		Model model = new Model("a,b,c,d,e");
		
		model.addState(1, "e", "");
		model.addState(2, "a", "1");
		model.addState(3, "b", "2");
		model.addState(4, "c", "3");
		model.addState(5, "d", "4");
		model.setStartStates("2");
		model.initialize();
		
		//For all states except 1 ( 2,3,4,5), they all lead to a through state 2, 
		//and by virtue of that, a state with label a: 
		//Thus state 2,3,4 and 5 should be included:
		HashSet<State> result = model.AF(model.getStatesWithLabel("a"));
		assertEquals(4, result.size());
		assertTrue(result.contains(model.getState(2)));
		assertTrue(result.contains(model.getState(3)));
		assertTrue(result.contains(model.getState(4)));
		assertTrue(result.contains(model.getState(5)));
	}
	
	@Test
	public void testLongCycle() {
		Model model = new Model("a,b,c,d,e");
		
		model.addState(1, "e", "5");
		model.addState(2, "a", "1");
		model.addState(3, "b", "2");
		model.addState(4, "c", "3");
		model.addState(5, "d", "4");
		model.setStartStates("2");
		model.initialize();
		
		HashSet<State> result = model.AF(model.getStatesWithLabel("a"));
		assertEquals(5, result.size());
		assertTrue(result.contains(model.getState(1)));
		assertTrue(result.contains(model.getState(2)));
		assertTrue(result.contains(model.getState(3)));
		assertTrue(result.contains(model.getState(4)));
		assertTrue(result.contains(model.getState(5)));
	}

	@Test
	public void testLongPathWithSelfloop() {
		Model model = new Model("a,b,c,d,e");
		try {
			model.addState(1, "e", "");
			model.addState(2, "a", "1");
			model.addState(3, "b", "2");
			model.addState(4, "c", "3,4");
			model.addState(5, "d", "4");
			model.initialize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
		//For 1, 2 and 3 they will all eventually end up in state 1 and thus e.
		HashSet<State> result = model.AF(model.getStatesWithLabel("e"));
		assertEquals(3, result.size());
		assertTrue(result.contains(model.getState(1)));
		assertTrue(result.contains(model.getState(2)));
		assertTrue(result.contains(model.getState(3)));
	}
	
	@Test
	public void testLongPathWithBranch() {
		Model model = new Model("a,b,c,d,e");
		
		model.addState(1, "e", "");
		model.addState(2, "a", "1");
		model.addState(3, "b", "2");
		model.addState(4, "c", "3,4");
		model.addState(5, "d", "4");
		model.initialize();
		
		//For 1, 2 and 3 they will all eventually end up in state 1 and thus e.
		HashSet<State> result = model.AF(model.getStatesWithLabel("e"));
		assertEquals(3, result.size());
		assertTrue(result.contains(model.getState(1)));
		assertTrue(result.contains(model.getState(2)));
		assertTrue(result.contains(model.getState(3)));
	}
	
	@Test
	public void testLongPathWithNormalLoop() {
		Model model = new Model("a,b,c,d,e");
		try {
			model.addState(1, "e", "");
			model.addState(2, "a", "1");
			model.addState(3, "b", "2");
			model.addState(4, "c", "3,4");
			model.addState(5, "d", "4");
			model.initialize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
		fail();
	}

	@Test
	public void testGoToNonexistentState() {
		Model model = Models.getTestModel1();
		//There are no states with label "kage", so the result should have size 0:
		HashSet<State> result = model.AF(model.getStatesWithLabel("kage"));
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
		//Both state 1 and 2 should be included, as 2 can got to 1, and Reach(1) always includes 1:
		HashSet<State> result = model.AF(model.getStatesWithLabel("a"));
		assertEquals(2, result.size());
		assertTrue(result.contains(model.getState(1)));
		assertTrue(result.contains(model.getState(2)));
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
		HashSet<State> result = model.AF(model.getStatesWithLabel("a"));
		assertEquals(1, result.size());
		assertTrue(result.contains(model.getState(1)));
	}
	
}
