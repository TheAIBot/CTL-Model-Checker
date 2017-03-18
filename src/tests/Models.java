package tests;

import check.Model;

public class Models {
	
	public static Model getTestModel1(){
		Model model = new Model("v,c");
		model.addState(1, "v", "2");
		model.addState(2, "v", "1,4");
		model.addState(3, "c", "4");
		model.addState(4, "c", "3");
		model.setStartStates("1,2,3,4");
		model.initialize();
		return model;
	}
	
	public static Model getTestModel2(){
		Model model = new Model("v,c");
		model.addState(1, "v", "");
		model.addState(2, "v", "1,3");
		model.addState(3, "c", "2,4");
		model.addState(4, "c", "");
		model.addState(5, "c", "4");
		model.setStartStates("1,2,3,4,5");
		model.initialize();
		return model;
	}
	
	public static Model getTestModel3(){
		Model model = new Model("v,c");
		model.addState(1, "v", "");
		model.addState(2, "v", "1,3,6");
		model.addState(3, "c", "4,9");
		model.addState(4, "c", "5");
		model.addState(5, "c", "2");
		model.addState(6, "c", "5");
		model.addState(7, "c", "6");
		model.addState(8, "c", "4");
		model.addState(9, "c", "");
		model.setStartStates("1,2,3,4,5,6,7,8,9");
		model.initialize();
		return model;
	}
}
