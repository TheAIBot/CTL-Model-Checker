package check;

import static org.junit.Assert.*;

import java.util.HashSet;
import org.junit.Test;

public class Towers {
	
	@Test
	public void testTowers() {
		final Model model = getTowersOfHanoi();
		
		//no stuck states exists
		final HashSet<State> acceptedStates = model.AX(model.trueForAll());
		assertTrue(model.getStates().stream().allMatch(x -> acceptedStates.contains(x)));
		
		
	}
	
	public Model getTowersOfHanoi() {
		String atomicPropositions = "AAA,BAA,CAA,"
								  + "ABA,BBA,CBA,"
								  + "ACA,BCA,CCA,"
								  + "AAB,BAB,CAB,"
								  + "ABB,BBB,CBB,"
								  + "ACB,BCB,CCB,"
								  + "AAC,BAC,CAC,"
								  + "ABC,BBC,CBC,"
								  + "ACC,BCC,CCC,";
		Model towersOfHanoi = new Model(atomicPropositions);
		//Upper triangle
		towersOfHanoi.addState(11, "AAA", "12,13");
		towersOfHanoi.addState(12, "BAA", "11,14,13");
		towersOfHanoi.addState(13, "CAA", "11,12,15");
		towersOfHanoi.addState(14, "BCA", "12,16,17");
		towersOfHanoi.addState(15, "CBA", "13,18,19");		
		towersOfHanoi.addState(16, "CCA", "14,17,21");
		towersOfHanoi.addState(17, "ACA", "14,16,18");		
		towersOfHanoi.addState(18, "ABA", "17,15,19");
		towersOfHanoi.addState(19, "BBA", "15,18,31");
		
		//Left triangle:
		towersOfHanoi.addState(21, "CCB,", "16,22,23");
		towersOfHanoi.addState(22, "ACB,", "21,24,23");
		towersOfHanoi.addState(23, "BCB,", "21,22,25");
		towersOfHanoi.addState(24, "ABB,", "22,26,27");
		towersOfHanoi.addState(25, "BAB,", "23,28,29");		
		towersOfHanoi.addState(26, "BBB,", "24,27");
		towersOfHanoi.addState(27, "CBB,", "24,26,28");		
		towersOfHanoi.addState(28, "CAB,", "27,25,29");
		towersOfHanoi.addState(29, "AAB,", "25,28,36");
		
		//Right triangle:		
		towersOfHanoi.addState(31, "BBC", "19,32,33");
		towersOfHanoi.addState(32, "CBC", "31,34,33");
		towersOfHanoi.addState(33, "ABC", "31,32,35");
		towersOfHanoi.addState(34, "CAC", "32,36,37");
		towersOfHanoi.addState(35, "ACC", "33,38,39");		
		towersOfHanoi.addState(36, "AAC", "29,34,37");
		towersOfHanoi.addState(37, "BAC", "34,36,38");		
		towersOfHanoi.addState(38, "BCC", "37,35,39");
		towersOfHanoi.addState(39, "CCC", "35,38");
		
		towersOfHanoi.initialize();		
		return towersOfHanoi;
	}

}
