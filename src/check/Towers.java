package check;

public class Towers {
	public static void main(String[] args) throws Exception {
		Model model = new Model("v,c");
		model.addState(1, "v", "2");
		model.addState(2, "v", "1,4");
		model.addState(3, "c", "3");
		model.addState(4, "c", "4");
		model.setStartStates("1,2,3,4");
		model.checkIsModelValid();
		System.out.println("Have no fear, the model is here!");
	}
	
	
	public static Model getTestModel(){
		Model model = new Model("v,c");
		try {
			//There is a test for this, so we know if it works or not
			model.addState(1, "v", "2");
			model.addState(2, "v", "1,4");
			model.addState(3, "c", "4");
			model.addState(4, "c", "3");
			model.setStartStates("1,2,3,4");
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.initialize();
		return model;
	}

}
