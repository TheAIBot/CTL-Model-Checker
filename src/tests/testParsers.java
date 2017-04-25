package tests;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import static org.junit.Assert.*;

import java.util.HashSet;

import Parsers.ModelCheck.output.ModelCheckLexer;
import Parsers.ModelCheck.output.ModelCheckParser;
import check.Model;
import check.State;
import check.Towers;

import org.junit.Assert;
import org.junit.Test;

public class testParsers {
	
	@Test
	public void testComplicatedFormulas() {
		final Model model = Towers.getTowersOfHanoi();
		
		HashSet<State> result = model.EF(model.unionOf(model.intersectionOf(model.unionOf(model.trueForAll(), 
																						  model.getStatesWithLabel("CCC")), 
																			model.getStatesWithLabel("AAA")), 
													   model.getStatesWithLabel("ABA")));
		checkParserSameResult(model, result, "EF((tt or CCC) and AAA or ABA)");
		
		result = model.EF(model.AF(model.EF(model.EF(model.unionOf(model.unionOf(model.complementOf(model.AX(model.getStatesWithLabel("ACB"))), 
																				 model.complementOf(model.complementOf(model.trueForAll()))), 
																   model.AG(model.intersectionOf(model.trueForAll(), 
																		   						 model.AX(model.complementOf(model.getStatesWithLabel("CAB"))))))))));
		checkParserSameResult(model, result, "EF AF EF EF(not( AX ACB) or not( not tt) or AG(tt and AX not CAB))");
	}
	
	@Test
	public void testParseChecks() {
		final Model model = Towers.getTowersOfHanoi();
		
		
		canParseCheck(model, "tt");
		canParseCheck(model, "(tt)");
		canParseCheck(model, "(((((tt)))))");
		
		canParseCheck(model, "EF AAA");
		canParseCheck(model, "EF(AAA)");
		canParseCheck(model, "EF(((((AAA)))))");
		
		canParseCheck(model, "not AAA");
		canParseCheck(model, "not(AAA)");
		canParseCheck(model, "not(((((AAA)))))");
		
		canParseCheck(model, "tt and tt");
		canParseCheck(model, "(tt) and (tt)");
		canParseCheck(model, "(((((tt))))) and (((((tt)))))");
		canParseCheck(model, "((((((tt))))) and (((((tt))))))");
		canParseCheck(model, "((((((((((tt))))) and (((((tt))))))))))");
		
		canParseCheck(model, "tt or tt");
		canParseCheck(model, "(tt) or (tt)");
		canParseCheck(model, "(((((tt))))) or (((((tt)))))");
		canParseCheck(model, "((((((tt))))) or (((((tt))))))");
		canParseCheck(model, "((((((((((tt))))) or (((((tt))))))))))");
		
		
		canParseCheck(model, "EF EF EF EF EF EF EF EF EF EF EF EF EF EF EF EF EF EF tt");
		canParseCheck(model, "not not not not not not not not not not not not not not not not not not tt");
		canParseCheck(model, "tt and tt and tt and tt and tt and tt and tt and tt and tt");
		canParseCheck(model, "tt or tt or tt or tt or tt or tt or tt or tt or tt");
		
	}
	
	public static void checkParserSameResult(Model model, HashSet<State> phi, String input) {		
		final ModelCheckLexer lex = new ModelCheckLexer(new ANTLRStringStream(input));
		final CommonTokenStream tokens = new CommonTokenStream(lex);
		final ModelCheckParser parser = new ModelCheckParser(tokens);
		
		try {
			assertEquals(model.checkIncludesInitialStates(phi), parser.check(model));
		} catch (RecognitionException e) {
			Assert.fail("couldn't parse string");
		}
	}
	
	private void canParseCheck(Model model, String input) {
		final ModelCheckLexer lex = new ModelCheckLexer(new ANTLRStringStream(input));
		final CommonTokenStream tokens = new CommonTokenStream(lex);
		final ModelCheckParser parser = new ModelCheckParser(tokens);
		
		try {
			parser.check(model);
		} catch (RecognitionException e) {
			Assert.fail("couldn't parse string");
		}
	}
}
