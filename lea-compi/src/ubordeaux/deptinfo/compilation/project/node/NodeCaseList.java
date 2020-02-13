package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.ExpList;
import ubordeaux.deptinfo.compilation.project.intermediateCode.LabelLocation;
import ubordeaux.deptinfo.compilation.project.intermediateCode.LabelLocationList;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Stm;
import ubordeaux.deptinfo.compilation.project.intermediateCode.StmList;

public final class NodeCaseList extends NodeExp {

	public NodeCaseList() {
		super();
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeCaseList clone() {
		return new NodeCaseList();
	}

	public LabelLocationList linearise2() {
		LabelLocation exp1 = (LabelLocation) ((NodeCase) elts.get(this.elts.size()-1)).linearise2();
		LabelLocationList list = new LabelLocationList(exp1, null);	
		for(int i=this.elts.size()-2; i>-1; i--) {;
		LabelLocation exp = (LabelLocation) ((NodeCase) elts.get(i)).linearise2();
			list = new LabelLocationList(exp, list);			
		}
		return list;
	}
	
	public Stm linearise() {
		return null;
	}

}
