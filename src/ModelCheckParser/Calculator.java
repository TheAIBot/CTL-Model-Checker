package ModelCheckParser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;

import ModelCheckParser.output.CalculatorLexer;
import ModelCheckParser.output.CalculatorParser;

public class Calculator {

	public static void main(String args[]) throws Exception {

		while (true) {

			// read an expression from the console
			System.out.print("Enter an arithmetic expression: ");
			String input = System.console().readLine();

			// build the parser for the content of the input
			Calculator lex = new CalculatorLexer(new ANTLRStringStream(input));
			CommonTokenStream tokens = new CommonTokenStream(lex);
			Calculator parser = new CalculatorParser(tokens);

			// print the result of parsing the content as an arith_expr
			System.out.println(parser.arith_expr());

		}
	}

}
