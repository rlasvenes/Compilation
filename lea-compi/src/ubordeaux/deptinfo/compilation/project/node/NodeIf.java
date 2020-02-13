package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Cjump;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Label;
import ubordeaux.deptinfo.compilation.project.intermediateCode.LabelLocation;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Move;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Name;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Seq;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Stm;
import ubordeaux.deptinfo.compilation.project.intermediateCode.TempValue;

public final class NodeIf extends Node {

	public NodeIf(Node boolExp, Node stm) {
		super(boolExp, stm);
	}

	public NodeIf(Node e, Node stm1, Node stm2) {
		super(e, stm1, stm2);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeIf clone() {
		Node expNode = this.getExpNode();
		Node thenNode = this.getThenNode();
		Node elseNode = this.getElseNode();
		if (elseNode == null)
			return new NodeIf((Node) expNode.clone(), (Node) thenNode.clone());
		else
			return new NodeIf((Node) expNode, (Node) thenNode.clone(), (Node) elseNode.clone());
	}

	private Node getExpNode() {
		return this.get(0);
	}

	private Node getElseNode() {
		if (this.size() == 3)
			return this.get(2);
		else
			return null;
	}

	private Node getThenNode() {
		return this.get(1);
	}

	@Override
	public Seq linearise() {
		NodeRel exp = (NodeRel) this.getExpNode();
		int op = 0;
		switch(exp.name) {
		case "EQ":
			op = 0;
			break;
		case "NE":
			op= 1;
			break;
		case "LT ":
			op = 2;
			break;
		case "GT" :
			op = 3;
			break;
		case "LE":
			op = 4;
			break;
		case "GE":
			op = 5;
			break;
		case "ULT":
			op = 6;
		case "ULE":
			op = 7;
			break;
		case "UGT":
			op = 8;
			break;
		case "UGE":
			op = 9;
			break;
		default:
			break;

		}
		 
		LabelLocation label1 = new LabelLocation(this.getThenNode().linearise().toString());
		LabelLocation label2 = new LabelLocation(this.getElseNode().linearise().toString());
		return new Seq(new Label(new LabelLocation()),new Cjump(op, (Exp)this.getExpNode().get(0).linearise(), (Exp)this.getExpNode().get(1).linearise(),
					label1,label2));
		
	}
}
