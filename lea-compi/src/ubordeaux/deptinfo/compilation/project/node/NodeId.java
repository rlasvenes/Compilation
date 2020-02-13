package ubordeaux.deptinfo.compilation.project.node;


import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Label;
import ubordeaux.deptinfo.compilation.project.intermediateCode.LabelLocation;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Mem;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Name;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Temp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.TempValue;
import ubordeaux.deptinfo.compilation.project.type.Type;

public final class NodeId extends NodeExp {

	protected String name;

	public NodeId(String name, Type type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String toString() {
		return this.getClass().getSimpleName() + "#" + name + ':' + type + '#';
	}
	

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	protected String toDotNodeName() {
		return "NodeId " + name;
	}

	@Override
	public NodeId clone() {
		return new NodeId(name, type);
	}

	@Override
	public Exp linearise() {
		
		return new Mem(new Name(new LabelLocation(name)));
	}
}
