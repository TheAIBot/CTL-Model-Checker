package tests;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

import check.*;

public class testAX {
	
	@Test
	public void testGoToVowel() {
		Model model = Models.getTestModel1();
		//The only state that is forced to go to a vowel, is 1:
		HashSet<State> result = model.AX(model.getStatesWithLabel("v"));
		assertEquals(1, result.size());
		assertTrue(result.contains(model.getState(1)));
		
		testParsers.checkParserSameResult(model, result, "AX v");
	}
	
	@Test
	public void testGoToConsonant() {
		Model model = Models.getTestModel1();
		//The only states that are forced to go to consonants, are 3 and 4:
		HashSet<State> result = model.AX(model.getStatesWithLabel("c"));
		assertEquals(2, result.size());
		assertTrue(result.contains(model.getState(3)));
		assertTrue(result.contains(model.getState(4)));
		
		testParsers.checkParserSameResult(model, result, "AX c");
	}
	
	@Test
	public void testGoToNonexistentState() {
		Model model = Models.getTestModel1();
		//There are no states with label "kage", so the result should have size 0:
		HashSet<State> result = model.AX(model.getStatesWithLabel("kage"));
		assertEquals(0, result.size());
		
		testParsers.checkParserSameResult(model, result, "AX kage");
	}
	
	@Test
	public void testNodesWithNoEdgesNotIncluded() {
		Model model = new Model("a,b");
		model.addState(1, "a", "");
		model.initialize();
		
		HashSet<State> result = model.AX(model.getStatesWithLabel("a"));
		assertEquals(0, result.size());
		
		testParsers.checkParserSameResult(model, result, "AX a");
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
		HashSet<State> result = model.AX(model.getStatesWithLabel("a"));
		assertEquals(1, result.size());
		assertTrue(result.contains(model.getState(1)));
		
		testParsers.checkParserSameResult(model, result, "AX a");
	}

}
