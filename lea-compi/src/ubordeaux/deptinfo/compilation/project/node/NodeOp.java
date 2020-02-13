package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Binop;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Const;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Eseq;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.LabelLocation;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Move;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Name;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Temp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.TempValue;
import ubordeaux.deptinfo.compilation.project.type.Type;

public class NodeOp extends NodeExp {

	protected String name;

	// Opération binaire
	// f : E X F -> F
	public NodeOp(String name, NodeExp op1, NodeExp op2) {
		super(op1, op2);
		this.name = name;
		// le type d'un opérateur 
		NodeExp exprFct = (NodeExp) this.get(1);
		type = exprFct.type;


	}

	public NodeOp(String name, NodeExp op) {
		super(op);
		this.name = name;
		// le type d'un opérateur 
		NodeExp exprFct = (NodeExp) this.get(0);
		type = exprFct.type;
	}

	@Override
	public boolean checksType() {
		super.checksType();
		if ((super.size() > 1) && getOp2()!=null && !this.getOp1().getType().equals(this.getOp2().getType()))
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
	public NodeOp clone() {
		if (this.size()==1)
			return new NodeOp(name, (NodeExp) getOp1().clone());
		else if (this.size()==2)
			return new NodeOp(name, (NodeExp) getOp1().clone(), (NodeExp) getOp2().clone());
		return null;
	}
	
	@Override
	public Exp linearise() {
		Exp seq1 = (Exp) getOp1().linearise();
		Exp seq2 = (Exp) getOp2().linearise();
		int binop;

		switch(name) {
		case "+": 
			binop = 0;
			break;
		case "-":
			binop = 1;
			break;
		case "*":
			binop = 2;
			break;
		case "/":
			binop = 3;
			break;
		case "&&":
			binop = 4;
			break;
		case "||":
			binop = 5;
			break;
		case "!":
			binop = 10;
			break;
		default:
			return null;
		}
				
		return new Binop(binop, seq1, seq2);

	}
}





























































