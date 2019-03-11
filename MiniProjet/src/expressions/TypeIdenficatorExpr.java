package expressions;

import abstractTree.AbstTree;
import abstractTree.EnvironmentInt;

public class TypeIdenficatorExpr extends AbstTree {

	private String id;

	public TypeIdenficatorExpr(String id) {
		super();
		this.id = id;
		token = id;
	}

	@Override
	protected void peval(EnvironmentInt environment) throws Exception {
		if (!id.isEmpty()) {
			value = environment.getVariableValue(id);
			environment.putVariable(this.toString(), value);
		} else {
			throw new Exception("ID cannot be empty (TypeIdenficatorExpr)");
		}
	}
}
