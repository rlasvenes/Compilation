package declarations;

import abstractTree.AbstTree;
import abstractTree.EnvironmentInt;
import expressions.TypeIdenficatorExpr;

public class Affectation extends AbstTree {

	private String id;

	public Affectation(AbstTree e1, String id) {
		super(e1);
		this.id = id;
		token = "=";
	}

	public Affectation(AbstTree e) {
		super(e);
		token = "=";
	}

	@Override
	protected void peval(EnvironmentInt environment) throws Exception {
		if (left != null) {
            left.eval(environment);

			if (!id.isEmpty()) {
				value = left.getValue();
				environment.putVariable(id, value);
			} else {

			}
		} else {
			throw new Exception("Left tree cannot be null at line: " + getStart());
		}
	}

}
