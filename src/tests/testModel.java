package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import check.Model;

public class testModel {
	@Test
	public void testCreateBaseModel(){
		Model model = new Model("v,c");
		try {
			model.addState(1, "v", "2");
			model.addState(2, "v", "1,3");
			model.addState(3, "c", "4");
			model.addState(4, "c", "3");
			model.setStartStates("1,2,3,4");
			model.initialize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();
		}		
		assertEquals(4, model.getStates().size());
	}

}
