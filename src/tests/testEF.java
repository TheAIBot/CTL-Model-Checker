package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

import check.Model;
import check.State;

public class testEF {
	
	@Test
	public void testNoPhi() {
		Model model = Models.getTestModel2();
		
		HashSet<State> phiStates = new HashSet<State>();
		HashSet<State> acceptedStates = model.EF(phiStates);
		assertEquals(0, acceptedStates.size());
		
		testParsers.checkParserSameResult(model, acceptedStates, "EF(not tt)");
	}
	
	@Test
	public void testReachableAndStuckPhi() {
		Model model = Models.getTestModel2();
		
		HashSet<State> phiStates = new HashSet<State>();
		phiStates.add(model.getState(1));
		HashSet<State> acceptedStates = model.EF(phiStates);
		assertEquals(3, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(1)));
		assertTrue(acceptedStates.contains(model.getState(2)));
		assertTrue(acceptedStates.contains(model.getState(3)));
		
		
		phiStates.clear();
		phiStates.add(model.getState(2));
		acceptedStates = model.EF(phiStates);
		assertEquals(2, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(2)));
		assertTrue(acceptedStates.contains(model.getState(3)));
		
		
		phiStates.clear();
		phiStates.add(model.getState(3));
		acceptedStates = model.EF(phiStates);
		assertEquals(2, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(2)));
		assertTrue(acceptedStates.contains(model.getState(3)));
		
		phiStates.clear();
		phiStates.add(model.getState(4));
		acceptedStates = model.EF(phiStates);
		assertEquals(4, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(2)));
		assertTrue(acceptedStates.contains(model.getState(3)));
		assertTrue(acceptedStates.contains(model.getState(4)));
		assertTrue(acceptedStates.contains(model.getState(5)));
	}
	
	@Test
	public void testUnreachablePhi() {
		Model model = Models.getTestModel2();
		
		HashSet<State> phiStates = new HashSet<State>();
		phiStates.add(model.getState(5));
		HashSet<State> acceptedStates = model.EF(phiStates);
		assertEquals(1, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(5)));
	}
}
