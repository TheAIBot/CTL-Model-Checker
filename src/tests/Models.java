package tests;

import check.Model;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import Parsers.TransitionSystem.output.TransitionSystemLexer;
import Parsers.TransitionSystem.output.TransitionSystemParser;

public class Models {
	
	public static Model getTestModel1(){
		final String input = "{1* [v] 2}{2 [v] 1, 4}{3* [c] 4}{4 [c] 3}";
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
	
	public static Model getTestModel2(){
		final String input = "{1* [v] }{2* [v] 1, 3}{3* [c] 2,4}{4* [c] }{5* [c] 4}";
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
	
	public static Model getTestModel3(){
		final String input = "{1* [v] }{2* [v] 1, 3, 6}{3* [c] 4, 9}{4* [c] 5}{5* [c] 2}{6* [c] 5}{7* [c] 6}{8* [c] 4}{9* [c] }";
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
