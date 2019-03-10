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
		// TODO: Gérer le cas où value est null
		environment.putVariable(this.toString(), value);
	}
}
