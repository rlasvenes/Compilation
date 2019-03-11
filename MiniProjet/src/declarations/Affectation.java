package declarations;

import abstractTree.AbstTree;
import abstractTree.EnvironmentInt;

public class Affectation extends AbstTree {

	private String id;

	public Affectation(AbstTree e1, String id) {
		super(e1);
		this.id = id;
		token = "=";
	}

	public Affectation(AbstTree e) {
		super(e);
	}

	@Override
	protected void peval(EnvironmentInt environment) throws Exception {
		if (left != null) {
//			environment.putVariable(id, left.getValue());

            left.eval(environment);

			if (!id.isEmpty()) {
				value = left.getValue();
				environment.putVariable(id, value);
			} else {
				// TODO
			}
		} else {
			throw new Exception("Left tree cannot be null at line: " + getStart());
		}
	}

}
