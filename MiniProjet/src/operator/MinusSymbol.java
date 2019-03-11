package operator;

import abstractTree.AbstTree;
import abstractTree.EnvironmentInt;

public class MinusSymbol extends AbstTree {

	public MinusSymbol(AbstTree e1, AbstTree e2) {
		super(e1, e2);
	}

	public MinusSymbol(AbstTree e) {
		super(e);
		token = "-";
	}

	@Override
	protected void peval(EnvironmentInt environment) throws Exception {
		if (left != null && right != null) {
			left.eval(environment);
			right.eval(environment);

			System.out.println("[CALCUL] --- " + left.getValue() + " - " + right.getValue());
			value = left.getValue() - right.getValue();
		} else if (left != null) {
			left.eval(environment);
			value = left.getValue() * (-1);
			environment.putVariable(this.toString(), value);
		}
	}
}
