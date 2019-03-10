package Operator;

import abstractTree.AbstTree;
import abstractTree.EnvironmentInt;
import beaver.Symbol;

public class MultiplySymbol extends AbstTree {

	public MultiplySymbol(AbstTree e1, AbstTree e2) {
	super(e1, e2);
	}

	@Override
	protected void peval(EnvironmentInt environment) throws Exception {
		if (left != null && right != null) {
			environment.putVariable(this.toString(), left.getValue() * right.getValue());
		} else {
			throw new Exception("Left or right cannot be null (multiply)");
		}
	}

}
