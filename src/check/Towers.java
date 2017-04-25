package check;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import Parsers.TransitionSystem.output.TransitionSystemLexer;
import Parsers.TransitionSystem.output.TransitionSystemParser;
import tests.testParsers;

public class Towers {
	
	public static void main(String[] args) {
		final Model model = getTowersOfHanoi();
		
		//No stuck states exists
		model.setStartStates("11,12,13,14,15,16,17,18,19,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39");
		assertTrue(model.checkIncludesInitialStates(model.AX(model.trueForAll())));
		
		//every corner only has two edges
		HashSet<State> phi = new HashSet<State>();
		phi.addAll(model.unionOf(model.unionOf(model.getStatesWithLabel("AAA"),
											   model.getStatesWithLabel("BBB")),
								 model.getStatesWithLabel("CCC")));
		//phi.add(model.getState(11));
		//phi.add(model.getState(26));
		//phi.add(model.getState(39));
		model.setStartStates("12,13,24,27,35,38");
		assertTrue(model.checkIncludesInitialStates(model.EX(phi)));
		testParsers.checkParserSameResult(model, model.EX(phi), "EX(AAA or BBB or CCC)");
		
		//towers of hanoi is made out of 3 smaller triangles
		//as they are all the same this proves that one contains loops
		phi.clear();
		phi.add(model.getState(11));
		phi.add(model.getState(12));
		phi.add(model.getState(13));
		phi.add(model.getState(14));
		phi.add(model.getState(15));
		phi.add(model.getState(16));
		phi.add(model.getState(17));
		phi.add(model.getState(18));
		phi.add(model.getState(19));
		phi.add(model.getState(31));
		phi.add(model.getState(32));
		phi.add(model.getState(33));
		phi.add(model.getState(34));
		phi.add(model.getState(35));
		phi.add(model.getState(36));
		phi.add(model.getState(37));
		phi.add(model.getState(38));
		phi.add(model.getState(39));
		model.setStartStates("21,22,23,24,25,26,27,28,29");
		assertTrue(model.checkIncludesInitialStates(model.EG(model.complementOf(phi))));
		
		//is there a path from all states to CCC
		phi.clear();
		phi.addAll(model.getStatesWithLabel("CCC"));
		model.setStartStates("11,12,13,14,15,16,17,18,19,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39");
		assertTrue(model.checkIncludesInitialStates(model.EF(phi)));
		testParsers.checkParserSameResult(model, model.EF(phi), "EF CCC");
		
		//Will stay in triangle forever:
		phi.clear();
		phi.add(model.getState(21));
		phi.add(model.getState(22));
		phi.add(model.getState(23));
		phi.add(model.getState(24));
		phi.add(model.getState(25));
		phi.add(model.getState(26));
		phi.add(model.getState(27));
		phi.add(model.getState(28));
		phi.add(model.getState(29));
		model.setStartStates("21,22,23,24,25,26,27,28,29");
		assertTrue(model.checkIncludesInitialStates(
				   model.intersectionOf(model.complementOf(model.AG(phi)), phi)
				   ));
		
		
		//All paths will (not) lead to CCC:
		phi.clear();
		phi.addAll(model.getStatesWithLabel("CCC"));
		model.setStartStates("11,12,13,14,15,16,17,18,19,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39");
		assertFalse(model.checkIncludesInitialStates(model.AF(phi)));
		testParsers.checkParserSameResult(model, phi, "AF CCC");
		
		
		//and a few random ones
		phi.clear();
		phi.add(model.getState(35));
		phi.add(model.getState(15));
		phi.add(model.getState(18));
		phi.add(model.getState(27));
		model.setStartStates("11,12,13,14,16,17,21,22,23,24,25,26,28,29,31,32,33,34,36,37,38,39");
		assertTrue(model.checkIncludesInitialStates(model.unionOf(model.EG(model.complementOf(phi)), model.AG(phi))));
		
		//another random one
		phi.clear();
		phi.add(model.getState(35));
		phi.add(model.getState(15));
		phi.add(model.getState(18));
		phi.add(model.getState(27));
		model.setStartStates("11,12,13,14,15,16,17,18,19,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39");
		assertTrue(model.checkIncludesInitialStates(
				   model.complementOf(
						model.intersectionOf(
								model.EX(phi), 
								model.AX(model.complementOf(phi))
					    )
			       )
				   ));
	}
	
	@Test
	public void testTowers() {
		main(new String[0]);
	}
	
	public static Model getTowersOfHanoi() {		
		String input  = "{11* [AAA] 12, 13}"   +
						"{12* [BAA] 11,14,13}" +
						"{13* [CAA] 11,12,15}" +
						"{14* [BCA] 12,16,17}" +
						"{15* [CBA] 13,18,19}" +
						"{16* [CCA] 14,17,21}" +
						"{17* [ACA] 14,16,18}" +
						"{18* [ABA] 17,15,19}" +
						"{19* [BBA] 15,18,31}" +
						"{21* [CCB] 16,22,23}" +
						"{22* [ACB] 21,24,23}" +
						"{23* [BCB] 21,22,25}" +
						"{24* [ABB] 22,26,27}" +
						"{25* [BAB] 23,28,29}" +
						"{26* [BBB] 24,27}"    +
						"{27* [CBB] 24,26,28}" +
						"{28* [CAB] 27,25,29}" +
						"{29* [AAB] 25,28,36}" +
						"{31* [BBC] 19,32,33}" +
						"{32* [CBC] 31,34,33}" +
						"{33* [ABC] 31,32,35}" +
						"{34* [CAC] 32,36,37}" +
						"{35* [ACC] 33,38,39}" +
						"{36* [AAC] 29,34,37}" +
						"{37* [BAC] 34,36,38}" +
						"{38* [BCC] 37,35,39}" +
						"{39* [CCC] 35,38}";
		
		TransitionSystemLexer lex = new TransitionSystemLexer(new ANTLRStringStream(input));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		TransitionSystemParser parser = new TransitionSystemParser(tokens);
		try {
			Model model = parser.getModel();
			model.initialize();
			return model;
		} catch (RecognitionException e) {
			
		}
		throw new Error("Failed to parse model");
	}

}
