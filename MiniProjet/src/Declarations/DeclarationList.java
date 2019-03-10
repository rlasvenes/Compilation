package Declarations;

import abstractTree.AbstTree;
import abstractTree.EnvironmentInt;

public class DeclarationList extends AbstTree {

	public DeclarationList(AbstTree e1) {
		super(e1);
	}

	public DeclarationList(AbstTree e1, AbstTree e2) {
		super(e1, e2);
	}

	@Override
	protected void peval(EnvironmentInt environment) throws Exception {
		if (left != null && right != null) {
			System.out.println("LEFT = (" + left + ", " + left.getValue());
			System.out.println("RIGHT = (" + right + ", " + right.getValue());
			environment.putVariable(left.toString(), left.getValue());
			environment.putVariable(right.toString(), right.getValue());
		} else if (left != null) {
			System.out.println("HO BOY");
			value = left.getValue();
		} else {
			throw new Exception("Left tree cannot be null (DeclarationList)");
		}
	}
}
