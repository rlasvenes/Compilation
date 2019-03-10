package Operator;

import abstractTree.AbstTree;
import abstractTree.EnvironmentInt;

public class MinusSymbol extends AbstTree {

	public MinusSymbol(AbstTree e1, AbstTree e2) {
		super(e1, e2);
	}

	public MinusSymbol(AbstTree e) {
		super(e);
	}

	@Override
	protected void peval(EnvironmentInt environment) throws Exception {
		if (left != null && right != null) {
			environment.putVariable(this.toString(), left.getValue() - right.getValue());
		} else if (left != null) {
			environment.putVariable(this.toString(), left.getValue() * (-1));
		}
	}
}
