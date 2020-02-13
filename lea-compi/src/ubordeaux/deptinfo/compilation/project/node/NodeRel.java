package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Cjump;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.LabelLocation;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Stm;
import ubordeaux.deptinfo.compilation.project.type.TypeBoolean;
import ubordeaux.deptinfo.compilation.project.type.TypeInt;

public class NodeRel extends NodeExp {

	protected String name;

	// Relation binaire
	// f : E X F -> {0,1}
	public NodeRel(String name, Node op1, Node op2) {
		super(op1, op2);
		this.name = name;
		this.type = new TypeBoolean();
	}

	@Override
	public boolean checksType() {
		super.checksType();
		if ((!(this.getOp1().getType() instanceof TypeInt)) || (!(this.getOp2().getType() instanceof TypeInt)))
			return false;
		return true;
	}

	private NodeExp getOp1() {
		return (NodeExp) this.get(0);
	};

	private NodeExp getOp2() {
		return (NodeExp) this.get(1);
	}

	@Override
	public NodeRel clone() {
		return new NodeRel(name, (Node) getOp1().clone(), (Node) getOp2().clone());
	}

	@Override
	public Stm linearise() {
		int relop;
		switch(name) {
		case "==" : 
			relop = 0 ;
			break;
		case "!=" : 
			relop = 1 ;
			break;
		case "<" : 
			relop = 2 ;
			break;
		case ">=" : 
			relop = 3 ;
			break;
		case ">" : 
			relop = 4 ;
			break;
		case "<=" : 
			relop = 5 ;
			break;			
		default:
			return null;
		}
		Exp op1 = (Exp) this.getOp1().linearise();
		Exp op2 = (Exp) this.getOp2().linearise();
		
		return new Cjump(relop, op1, op2, new LabelLocation(), new LabelLocation());
	};

}



























