package expressions;

import abstractTree.AbstTree;
import abstractTree.EnvironmentInt;

public class TypeIntegerExpr extends AbstTree {

	private Integer id;

	public TypeIntegerExpr(Integer id) {
		super();
		this.id = id;
		token = id.toString();
	}

	@Override
	protected void peval(EnvironmentInt environment) throws Exception {
		if (id != null) {
			value = id.doubleValue();
			environment.putVariable(this.toString(), value);
		} else {
			throw new Exception("Integer cannot be null");
		}
	}

	public String toString() {
		return id.toString();
	}

}
