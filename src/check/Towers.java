package check;

public class Towers {
	public static void main(String[] args) {
		Model model = new Model("v,c");
		model.addState(1, "v", "2");
		model.addState(2, "v", "1,4");
		model.addState(3, "c", "3");
		model.addState(4, "c", "4");
		model.setStartStates("1,2,3,4");
		System.out.println("Have no fear, the model is here!");
		System.out.println("Answer the model is valid: " + model.isModelValid() + "!");
	}

}
