package tests;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

import check.*;

public class testEX {
	
	@Test
	public void test1() {
		Model model = Towers.getTestModel();
		
		
		HashSet<State> phiStates = new HashSet<State>();
		phiStates.add(model.getState(1));
		HashSet<State> acceptedStates = model.EX(phiStates);
		assertEquals(1, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(2)));
		
		
		phiStates.clear();
		phiStates.add(model.getState(2));
		acceptedStates = model.EX(phiStates);
		assertEquals(1, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(1)));
		
		
		phiStates.clear();
		phiStates.add(model.getState(3));
		acceptedStates = model.EX(phiStates);
		assertEquals(1, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(4)));
		
		
		phiStates.clear();
		phiStates.add(model.getState(4));
		acceptedStates = model.EX(phiStates);
		assertEquals(2, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(2)));
		assertTrue(acceptedStates.contains(model.getState(3)));
		
		
		phiStates.clear();
		phiStates.add(model.getState(1));
		phiStates.add(model.getState(2));
		acceptedStates = model.EX(phiStates);
		assertEquals(2, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(1)));
		assertTrue(acceptedStates.contains(model.getState(2)));
		
		
		phiStates.clear();
		phiStates.add(model.getState(1));
		phiStates.add(model.getState(3));
		acceptedStates = model.EX(phiStates);
		assertEquals(2, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(2)));
		assertTrue(acceptedStates.contains(model.getState(4)));
		
		
		phiStates.clear();
		phiStates.add(model.getState(1));
		phiStates.add(model.getState(4));
		acceptedStates = model.EX(phiStates);
		assertEquals(2, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(2)));
		assertTrue(acceptedStates.contains(model.getState(3)));
		
		
		phiStates.clear();
		phiStates.add(model.getState(2));
		phiStates.add(model.getState(3));
		acceptedStates = model.EX(phiStates);
		assertEquals(2, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(1)));
		assertTrue(acceptedStates.contains(model.getState(4)));
		
		
		phiStates.clear();
		phiStates.add(model.getState(2));
		phiStates.add(model.getState(4));
		acceptedStates = model.EX(phiStates);
		assertEquals(3, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(1)));
		assertTrue(acceptedStates.contains(model.getState(2)));
		assertTrue(acceptedStates.contains(model.getState(3)));
		
		
		phiStates.clear();
		phiStates.add(model.getState(3));
		phiStates.add(model.getState(4));
		acceptedStates = model.EX(phiStates);
		assertEquals(3, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(2)));
		assertTrue(acceptedStates.contains(model.getState(3)));
		assertTrue(acceptedStates.contains(model.getState(4)));
		
		
		phiStates.clear();
		phiStates.add(model.getState(1));
		phiStates.add(model.getState(2));
		phiStates.add(model.getState(3));
		acceptedStates = model.EX(phiStates);
		assertEquals(3, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(1)));
		assertTrue(acceptedStates.contains(model.getState(2)));
		assertTrue(acceptedStates.contains(model.getState(4)));
		
		
		phiStates.clear();
		phiStates.add(model.getState(1));
		phiStates.add(model.getState(2));
		phiStates.add(model.getState(4));
		acceptedStates = model.EX(phiStates);
		assertEquals(3, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(1)));
		assertTrue(acceptedStates.contains(model.getState(2)));
		assertTrue(acceptedStates.contains(model.getState(3)));
		
		
		phiStates.clear();
		phiStates.add(model.getState(1));
		phiStates.add(model.getState(3));
		phiStates.add(model.getState(4));
		acceptedStates = model.EX(phiStates);
		assertEquals(3, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(2)));
		assertTrue(acceptedStates.contains(model.getState(3)));
		assertTrue(acceptedStates.contains(model.getState(4)));
		
		
		phiStates.clear();
		phiStates.add(model.getState(2));
		phiStates.add(model.getState(3));
		phiStates.add(model.getState(4));
		acceptedStates = model.EX(phiStates);
		assertEquals(4, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(1)));
		assertTrue(acceptedStates.contains(model.getState(2)));
		assertTrue(acceptedStates.contains(model.getState(3)));
		assertTrue(acceptedStates.contains(model.getState(4)));
		
		
		phiStates.clear();
		phiStates.add(model.getState(1));
		phiStates.add(model.getState(2));
		phiStates.add(model.getState(3));
		phiStates.add(model.getState(4));
		acceptedStates = model.EX(phiStates);
		assertEquals(4, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(1)));
		assertTrue(acceptedStates.contains(model.getState(2)));
		assertTrue(acceptedStates.contains(model.getState(3)));
		assertTrue(acceptedStates.contains(model.getState(4)));
	}

}
