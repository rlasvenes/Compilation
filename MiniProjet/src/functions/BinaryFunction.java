package functions;

import abstractTree.AbstTree;
import abstractTree.EnvironmentInt;

public class BinaryFunction extends AbstTree {

	private String fct;

	public BinaryFunction(AbstTree e1, AbstTree e2, String fct) {
		super(e1, e2);
		this.fct = fct;
	}

	@Override
	protected void peval(EnvironmentInt environment) throws Exception {
		if (left != null && right != null) {
//			Math.round()
		} else {
			throw new Exception("Cannot apply binary function to null arguments");
		}
	}
}
