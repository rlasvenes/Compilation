package Expressions;

import abstractTree.AbstTree;
import abstractTree.EnvironmentInt;

public class TypeIdenficatorExpr extends AbstTree {

	private String id;

	public TypeIdenficatorExpr(String id) {
		super();
		this.id = id;
	}

	@Override
	protected void peval(EnvironmentInt environment) throws Exception {
		if (!id.isEmpty()) {
			environment.putVariable(this.toString(), environment.getVariableValue(id));
		} else {
			throw new Exception("ID cannot be empty (TypeIdenficatorExpr)");
		}
	}
}
