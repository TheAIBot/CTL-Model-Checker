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
		Model model = new Model("v,c");
		model.addState(1, "v", "2");
		model.addState(2, "v", "1,4");
		model.addState(3, "c", "4");
		model.addState(4, "c", "3");
		model.setStartStates("1,2,3,4");
		model.initialize();
		
		
		HashSet<State> phiStates = new HashSet<State>();
		phiStates.add(model.getState(2));
		
		HashSet<State> acceptedStates = (HashSet<State>) model.EX(phiStates);
		assertEquals(1, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(1)));
		
		
		phiStates.clear();
		phiStates.add(model.getState(3));
		
		acceptedStates = (HashSet<State>) model.EX(phiStates);
		assertEquals(2, acceptedStates.size());
		assertTrue(acceptedStates.contains(model.getState(2)));
		
	}

}
