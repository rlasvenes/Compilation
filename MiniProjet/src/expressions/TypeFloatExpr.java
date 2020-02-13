package expressions;

import abstractTree.AbstTree;
import abstractTree.EnvironmentInt;

public class TypeFloatExpr extends AbstTree {

	public TypeFloatExpr(Double val) {
		super();
		this.value = val;
	}

	@Override
	protected void peval(EnvironmentInt environment) throws Exception {
		System.out.println(environment);
		environment.putVariable(this.toString(), value);
	}

	public String toString() {
		return value.toString();
	}
}
