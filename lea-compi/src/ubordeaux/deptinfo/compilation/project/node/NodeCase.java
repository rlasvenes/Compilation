package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Label;
import ubordeaux.deptinfo.compilation.project.intermediateCode.LabelLocation;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Move;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Seq;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Stm;

public final class NodeCase extends Node {

	private String nameValue;
	private boolean defaultValue;
	
	public NodeCase(String nameValue, Node stm) {
		super(stm);
		this.nameValue = nameValue;
		this.defaultValue = false;
	}

	public NodeCase(Node stm) {
		this(null, stm);
		this.defaultValue = true;
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeCase clone() {
		return new NodeCase(nameValue, (Node) this.getStm().clone());
	}

	private Node getStm() {
		return super.get(0);
	}

	public boolean isDefaultValue() {
		return defaultValue;
	}

	public LabelLocation linearise2() {
		return new LabelLocation(this.nameValue);
	}
	@Override
	public Stm linearise() {
		LabelLocation label = new LabelLocation(this.nameValue);
		Stm stm = (Stm) this.getStm().linearise();
		return stm;
	}

}


















