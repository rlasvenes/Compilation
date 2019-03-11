package operator;

import abstractTree.AbstTree;
import abstractTree.EnvironmentInt;

public class PlusSymbol extends AbstTree {

	public PlusSymbol(AbstTree e1, AbstTree e2) {
		super(e1, e2);
		token = "+";
	}

	@Override
	protected void peval(EnvironmentInt environment) throws Exception {
		if (left != null && right != null) {
			left.eval(environment);
			right.eval(environment);

			value = left.getValue() + right.getValue();
			System.out.println("[CALCUL] +++ " + left.getValue() + " + " + right.getValue());
		} else {
			throw new Exception("left or right tree cannot be null");
		}
	}
}
