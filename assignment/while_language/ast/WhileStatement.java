package while_language.ast;

import while_language.Environment;
import while_language.VariableNotDefinedException;

public class WhileStatement extends Statement {

	private BoolExpr condition;
	private Statement loop;
	
	public WhileStatement(BoolExpr condition, Statement loop) {
		this.condition = condition;
		this.loop = loop;
	}
	
	@Override
	public void evaluate(Environment env) throws VariableNotDefinedException {
		while(condition.evaluate(env)){		      
			loop.evaluate(env);	
		}
	}

}
