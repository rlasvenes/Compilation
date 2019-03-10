package functions;

import constants.Functions;
import abstractTree.AbstTree;
import abstractTree.EnvironmentInt;

public class UnaryFunction extends AbstTree {

	private String fct;

	public UnaryFunction(AbstTree e1, String fct) {
		super(e1);
		this.fct = fct;
	}

	@Override
	protected void peval(EnvironmentInt environment) throws Exception {
		if (left != null) {
		    left.eval(environment); // évaluer le seul fils, car il se peut que ce soit une expression (ex: sin(1 * (5-6)))

			if (fct.equals(Functions.SQRT.getName())) {
				value = Math.sqrt(left.getValue());
			} else if (fct.equals(Functions.ROUND.getName())) {
				value = (double) Math.round(left.getValue());
			} else if (fct.equals(Functions.SIN.getName())) {
				value = Math.sin(left.getValue());
			}

			environment.putVariable(this.toString(), value);
		} else {
			throw new Exception("Cannot apply unary function to null tree");
		}
	}
}