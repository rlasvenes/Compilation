package Declarations;

import abstractTree.AbstTree;
import abstractTree.EnvironmentInt;

public class Affectation extends AbstTree {

	private String id;

	public Affectation(AbstTree e1, String id) {
		super(e1);
		this.id = id;
	}

	public Affectation(AbstTree e) {
		super(e);
	}

	@Override
	protected void peval(EnvironmentInt environment) throws Exception {
		if (left != null) {
			if (!id.isEmpty()) {
				value = environment.getVariableValue(id);
			} else {
				value = 0.0;
			}
		} else {
			throw new Exception("Left tree cannot be null");
		}
	}

}
