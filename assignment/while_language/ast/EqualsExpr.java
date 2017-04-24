package while_language.ast;

import while_language.Environment;
import while_language.VariableNotDefinedException;

public class EqualsExpr extends BoolExpr {

	private ArithExpr expression1;
	private ArithExpr expression2;
	
	public EqualsExpr(ArithExpr expression1, ArithExpr expression2) {
		this.expression1 = expression1;
		this.expression2 = expression2;
	}
	
	@Override
	public boolean evaluate(Environment env) throws VariableNotDefinedException {
		return expression1.evaluate(env) == expression2.evaluate(env);
	}

}
