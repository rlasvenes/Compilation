package Operator;

import abstractTree.AbstTree;
import abstractTree.EnvironmentInt;

public class DivisionSymbol extends AbstTree {

	public DivisionSymbol(AbstTree e1, AbstTree e2) {
		super(e1, e2);
	}

	@Override
	protected void peval(EnvironmentInt environment) throws Exception {
		System.out.println(left.getValue() + " DIV BY " + right.getValue());
		environment.putVariable(this.toString(), left.getValue() / right.getValue());
	}

}
