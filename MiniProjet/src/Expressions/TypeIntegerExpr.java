package Expressions;

import abstractTree.AbstTree;
import abstractTree.EnvironmentInt;

public class TypeIntegerExpr extends AbstTree {

	private Integer id;

	public TypeIntegerExpr(Integer id) {
		super();
		this.id = id;
	}

	@Override
	protected void peval(EnvironmentInt environment) throws Exception {
		environment.putVariable(this.toString(), id.doubleValue());
	}
}
