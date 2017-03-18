package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

import check.Model;
import check.State;

public class testEG {
	
	@Test
	public void testNoLoopNoStuck() {
		Model model = Models.getTestModel1();
		
		HashSet<State> phiStates = new HashSet<State>();
		phiStates.add(model.getState(1));
		HashSet<State> acceptedStates = model.EG(phiStates);
		assertEquals(0, acceptedStates.size());
		
		phiStates.clear();
		phiStates.add(model.getState(2));
		acceptedStates = model.EG(phiStates);
		assertEquals(0, acceptedStates.size());
		
		phiStates.clear();
		phiStates.add(model.getState(3));
		acceptedStates = model.EG(phiStates);
		assertEquals(0, acceptedStates.size());
		
		phiStates.clear();
		phiStates.add(model.getState(4));
		acceptedStates = model.EG(phiStates);
		assertEquals(0, acceptedStates.size());
	}
	
	@Test
	public void testLoopNoStuck() {
		Model model = Models.getTestModel1();
		
		HashSet<State> phiStates = new HashSet<State>();
		phiStates.add(model.getState(1));
		phiStates.add(model.getState(2));
		HashSet<State> acceptedStates = model.EG(phiStates);
		assertEquals(2, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(1)));
		assertTrue(acceptedStates.contains(model.getState(2)));
		
		phiStates.clear();
		phiStates.add(model.getState(3));
		phiStates.add(model.getState(4));
		acceptedStates = model.EG(phiStates);
		assertEquals(2, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(3)));
		assertTrue(acceptedStates.contains(model.getState(4)));
	}
	
	@Test
	public void testNoLoopButStuck() {
		Model model = Models.getTestModel2();
		
		HashSet<State> phiStates = new HashSet<State>();
		phiStates.add(model.getState(1));
		HashSet<State> acceptedStates = model.EG(phiStates);
		assertEquals(1, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(1)));
		
		phiStates.clear();
		phiStates.add(model.getState(4));
		acceptedStates = model.EG(phiStates);
		assertEquals(1, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(4)));
		
		phiStates.clear();
		phiStates.add(model.getState(3));
		phiStates.add(model.getState(4));
		acceptedStates = model.EG(phiStates);
		assertEquals(2, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(3)));
		assertTrue(acceptedStates.contains(model.getState(4)));
		
		phiStates.clear();
		phiStates.add(model.getState(1));
		phiStates.add(model.getState(2));
		phiStates.add(model.getState(4));
		phiStates.add(model.getState(5));
		acceptedStates = model.EG(phiStates);
		assertEquals(4, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(1)));
		assertTrue(acceptedStates.contains(model.getState(2)));
		assertTrue(acceptedStates.contains(model.getState(4)));
		assertTrue(acceptedStates.contains(model.getState(5)));
	}
	
	@Test
	public void testLoopAndStuck() {
		Model model = Models.getTestModel3();
		
		HashSet<State> phiStates = new HashSet<State>();
		phiStates.add(model.getState(1));
		phiStates.add(model.getState(2));
		phiStates.add(model.getState(3));
		phiStates.add(model.getState(4));
		phiStates.add(model.getState(5));
		phiStates.add(model.getState(8));
		HashSet<State> acceptedStates = model.EG(phiStates);
		assertEquals(6, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(1)));
		assertTrue(acceptedStates.contains(model.getState(2)));
		assertTrue(acceptedStates.contains(model.getState(3)));
		assertTrue(acceptedStates.contains(model.getState(4)));
		assertTrue(acceptedStates.contains(model.getState(5)));
		assertTrue(acceptedStates.contains(model.getState(8)));
		
		
		phiStates.clear();
		phiStates.add(model.getState(1));
		phiStates.add(model.getState(2));
		phiStates.add(model.getState(3));
		phiStates.add(model.getState(5));
		phiStates.add(model.getState(6));
		phiStates.add(model.getState(9));
		acceptedStates = model.EG(phiStates);
		assertEquals(6, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(1)));
		assertTrue(acceptedStates.contains(model.getState(2)));
		assertTrue(acceptedStates.contains(model.getState(3)));
		assertTrue(acceptedStates.contains(model.getState(5)));
		assertTrue(acceptedStates.contains(model.getState(6)));
		assertTrue(acceptedStates.contains(model.getState(9)));
		
		phiStates.clear();
		phiStates.add(model.getState(1));
		phiStates.add(model.getState(2));
		phiStates.add(model.getState(3));
		phiStates.add(model.getState(5));
		phiStates.add(model.getState(6));
		phiStates.add(model.getState(7));
		phiStates.add(model.getState(9));
		acceptedStates = model.EG(phiStates);
		assertEquals(7, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(1)));
		assertTrue(acceptedStates.contains(model.getState(2)));
		assertTrue(acceptedStates.contains(model.getState(3)));
		assertTrue(acceptedStates.contains(model.getState(5)));
		assertTrue(acceptedStates.contains(model.getState(6)));
		assertTrue(acceptedStates.contains(model.getState(7)));
		assertTrue(acceptedStates.contains(model.getState(9)));
		
		phiStates.clear();
		phiStates.add(model.getState(2));
		phiStates.add(model.getState(3));
		phiStates.add(model.getState(4));
		phiStates.add(model.getState(5));
		phiStates.add(model.getState(8));
		phiStates.add(model.getState(9));
		acceptedStates = model.EG(phiStates);
		assertEquals(6, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(2)));
		assertTrue(acceptedStates.contains(model.getState(3)));
		assertTrue(acceptedStates.contains(model.getState(4)));
		assertTrue(acceptedStates.contains(model.getState(5)));
		assertTrue(acceptedStates.contains(model.getState(8)));
		assertTrue(acceptedStates.contains(model.getState(9)));
	}
	
}
