package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Const;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;
import ubordeaux.deptinfo.compilation.project.intermediateCode.LabelLocation;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Mem;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Name;
import ubordeaux.deptinfo.compilation.project.type.Type;
import ubordeaux.deptinfo.compilation.project.type.TypeInt;

public final class NodeReturn extends NodeExp {

	public NodeReturn(Node e) {
		super(e);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeReturn clone() {
		return new NodeReturn((Node) get(0).clone());
	}

	public Exp linearise() {
		NodeExp e = (NodeExp) this.clone();
		NodeExp returnNode = (NodeExp) e.get(0);
		switch(returnNode.getClass().getSimpleName()) {
		case "NodeLiteral":
			TypeInt t = (TypeInt) returnNode.getType();		
			return new Name(new LabelLocation("return " + new Const(t.getConst_value())));
		case "NodeId":
			String name = (String) ((NodeId) returnNode).name;
			return new Name(new LabelLocation(name));
		default:
			return null;

		}
	}
}
