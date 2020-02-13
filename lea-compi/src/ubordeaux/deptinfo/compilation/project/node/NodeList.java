package ubordeaux.deptinfo.compilation.project.node;

import java.util.Iterator;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Eseq;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.ExpList;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Seq;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Stm;
import ubordeaux.deptinfo.compilation.project.intermediateCode.StmList;

public final class NodeList extends Node {

	public NodeList(Node stm) {
		super(stm);
	}

	public NodeList() {
		super();
	}

	@Override
	public boolean checksType() {
		super.checksType();
		boolean result = true;
		for (Node elt : this.elts) {
			if (elt != null && !elt.checksType()) {
				result = false;
				break;
			}
		}
		return result;
	}

	public Iterator<Node> iterator() {
		return this.elts.iterator();
	}

	public int size() {
		return this.elts.size();
	}

	@Override
	public NodeList clone() {
		NodeList node = new NodeList();
		for (Node elt : this.elts) {
			node.add((Node) elt.clone());
		}
		return node;
	}

	@Override
	public ExpList linearise() {
		Exp exp1 = (Exp) elts.get(this.elts.size()-1).linearise();
		ExpList list = new ExpList(exp1, null);	
		for(int i=this.elts.size()-2; i>-1; i--) {;
			Exp exp = (Exp) elts.get(i).linearise();
			list = new ExpList(exp, list);			
		}
		return list;
	}
}




































