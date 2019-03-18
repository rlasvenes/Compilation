package functions;

import constants.Functions;
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
			left.eval(environment);
			right.eval(environment);

			if (fct.equals(Functions.MIN.getName())) {
				token = Functions.MIN.getName();
				value = Math.min(left.getValue(), right.getValue());
			} else if (fct.equals(Functions.MAX.getName())) {
				token = Functions.MAX.getName();
				value = Math.max(left.getValue(), right.getValue());
			} else if (fct.equals(Functions.POW.getName())) {
				token = Functions.POW.getName();
				value = Math.pow(left.getValue(), right.getValue());
			}
		} else {
			throw new Exception("Cannot apply binary function to null arguments");
		}
	}
	
	@Override
	public String toString() {
		return fct;
	}
}
