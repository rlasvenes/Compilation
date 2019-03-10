package Expressions;

import abstractTree.AbstTree;
import abstractTree.EnvironmentInt;

public class TypeFloatExpr extends AbstTree {

	public TypeFloatExpr(Double val) {
		super();
		this.value = val;
	}

	@Override
	protected void peval(EnvironmentInt environment) throws Exception {
		environment.putVariable(this.toString(), value);
	}
}
