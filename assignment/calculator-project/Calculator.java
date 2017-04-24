import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;

public class Calculator {

	public static void main(String args[]) throws Exception {

		while (true) {

			// read an expression from the console
			System.out.print("Enter an arithmetic expression: ");
			String input = System.console().readLine();

			// build the parser for the content of the input
			CalculatorLexer lex = new CalculatorLexer(new ANTLRStringStream(input));
			CommonTokenStream tokens = new CommonTokenStream(lex);
			CalculatorParser parser = new CalculatorParser(tokens);

			// print the result of parsing the content as an arith_expr
			System.out.println(parser.arith_expr());

		}
	}

}
