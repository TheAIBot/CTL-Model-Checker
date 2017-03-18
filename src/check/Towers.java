package check;


public class Towers {
	
	public static void main(String[] args) {
		Model model = getTestModel();
		System.out.println("Have no fear, the model is here!");
		//model.prettyPrint();
		getTowersOfHanoi();
	}
	
	
	public static Model getTestModel(){
		Model model = new Model("v,c");
		model.addState(1, "v,c", "2");
		model.addState(2, "v", "1,4");
		model.addState(3, "c", "4");
		model.addState(4, "c", "3");
		model.setStartStates("1,2,3,4");
		model.initialize();
		return model;
	}
	
	public static Model getTowersOfHanoi() {
		System.out.println("ÅḂĊ");
		String atomicPropositions = "aAÅ,bAÅ,cAÅ,"
								  + "aBÅ,bBÅ,cBÅ,"
								  + "aCÅ,bCÅ,cCÅ,"
								  + "aAḂ,bAḂ,cAḂ,"
								  + "aBḂ,bBḂ,cBḂ,"
								  + "aCḂ,bCḂ,cCḂ,"
								  + "aAĊ,bAĊ,cAĊ,"
								  + "aBĊ,bBĊ,cBĊ,"
								  + "aCĊ,bCĊ,cCĊ,";
		Model towersOfHanoi = new Model(atomicPropositions);
		//Upper triangle
		towersOfHanoi.addState(11, "aAÅ", "12,13");
		towersOfHanoi.addState(12, "bAÅ", "11,14,13");
		towersOfHanoi.addState(13, "cAÅ", "11,12,15");
		towersOfHanoi.addState(14, "bCÅ", "12,16,17");
		towersOfHanoi.addState(15, "cBÅ", "13,18,19");		
		towersOfHanoi.addState(16, "cCÅ", "14,17,21");
		towersOfHanoi.addState(17, "aCÅ", "14,16,18");		
		towersOfHanoi.addState(18, "aBÅ", "17,15,19");
		towersOfHanoi.addState(19, "bBÅ", "15,18,31");
		
		//Left triangle:
		towersOfHanoi.addState(21, "cCḂ", "16,22,23");
		towersOfHanoi.addState(22, "aCḂ", "21,24,23");
		towersOfHanoi.addState(23, "bCḂ", "21,22,25");
		towersOfHanoi.addState(24, "aBḂ", "22,26,27");
		towersOfHanoi.addState(25, "bAḂ", "23,28,29");		
		towersOfHanoi.addState(26, "bBḂ", "24,27");
		towersOfHanoi.addState(27, "cBḂ", "24,26,28");		
		towersOfHanoi.addState(28, "cAḂ", "27,25,29");
		towersOfHanoi.addState(29, "aAḂ", "25,28,36");
		
		//Right triangle:		

		towersOfHanoi.addState(31, "bBĊ", "19,32,33");
		towersOfHanoi.addState(32, "cBĊ", "31,34,33");
		towersOfHanoi.addState(33, "aBĊ", "31,32,35");
		towersOfHanoi.addState(34, "cAĊ", "32,36,37");
		towersOfHanoi.addState(35, "aCĊ", "33,38,39");		
		towersOfHanoi.addState(36, "aAĊ", "29,34,37");
		towersOfHanoi.addState(37, "bAĊ", "34,36,38");		
		towersOfHanoi.addState(38, "bCĊ", "37,35,39");
		towersOfHanoi.addState(39, "cCĊ", "35,38");
		
		towersOfHanoi.initialize();
		
		towersOfHanoi.prettyPrint();
		
		return towersOfHanoi;
	}

}
