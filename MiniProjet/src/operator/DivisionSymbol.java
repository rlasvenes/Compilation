package operator;

import abstractTree.AbstTree;
import abstractTree.EnvironmentInt;

public class DivisionSymbol extends AbstTree {

	public DivisionSymbol(AbstTree e1, AbstTree e2) {
		super(e1, e2);
	}

	@Override
	protected void peval(EnvironmentInt environment) throws Exception {
		if (left != null && right != null) {
			left.eval(environment);
			right.eval(environment);

			value = left.getValue() / right.getValue();
			environment.putVariable(this.toString(), value);
		} else {
			throw new Exception("Left or right tree cannot be null");
		}
	}

}
