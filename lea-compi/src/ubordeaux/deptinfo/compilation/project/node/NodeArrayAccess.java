package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.type.TypeRange;
import ubordeaux.deptinfo.compilation.project.type.TypeItemEnum;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Binop;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Const;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;
import ubordeaux.deptinfo.compilation.project.intermediateCode.LabelLocation;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Mem;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Move;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Name;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Temp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.TempValue;
import ubordeaux.deptinfo.compilation.project.type.Type;
import ubordeaux.deptinfo.compilation.project.type.TypeArray;
import ubordeaux.deptinfo.compilation.project.type.TypeComplex;
import ubordeaux.deptinfo.compilation.project.type.TypeInt;

public final class NodeArrayAccess extends NodeExp {

	// t [i]
	public NodeArrayAccess(NodeExp t, Node i) {
		super(t, i);
		if ((t!=null) && (((TypeComplex) t.type).size() == 2))
			type = ((TypeComplex) t.type).get(1);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		TypeArray typeArray = (TypeArray)((NodeExp)this.get(0)).getType();
		TypeRange typeRangeOREnum = typeArray.getRangeOREnum();
		Type typeArg = ((NodeExp)get(1)).getType();

				// Si l'index n'est pas du type attendu 
		if (typeArg.getClass() != typeRangeOREnum.getFirst().getClass()) {
			System.err.println("type de l'index incorrect");
			return false;
		}
		// Si l'index est un enum, mais pas le bon
		if ((typeArg instanceof TypeItemEnum)
				&& ((TypeItemEnum) typeArg).getRefEnumRange()  != ((TypeItemEnum) typeRangeOREnum.getFirst()).getRefEnumRange()) {
			System.err.println("type de l'index incorrect");
			return false;
		}		
		// Si la valeur constante de l'index depasse
		if ((typeArg.compareTo(typeRangeOREnum.getFirst()) < 0) 
			|| (typeArg.compareTo(((TypeRange) typeRangeOREnum).getLast()) > 0)) {
			System.err.println("index constant hors tableau");
			return false;
		}			
		return true;
	}

	@Override
	public NodeArrayAccess clone() {
		return new NodeArrayAccess((NodeExp) get(0).clone(), (Node) get(1).clone());
	}

	@Override
	public IntermediateCode linearise() {
		NodeExp e = (NodeExp) this.clone();
		NodeExp NodeNumber = (NodeExp) e.get(1);
		//NodeExp NodeName = (NodeExp) e.get(0);
		String s;

		switch(NodeNumber.getClass().getSimpleName()) {
		case "NodeLiteral":
			TypeInt t = (TypeInt) NodeNumber.getType();			
			s = Integer.toString(t.getConst_value());
			break;
		case "NodeId":
			s = (String) ((NodeId) NodeNumber).name;
			break;
		default:
			return null;

		}
		Name name = new Name(new LabelLocation(s));
		Temp tmp = new Temp(new TempValue());
		return new Mem(new Binop(-1, name, tmp));
	}
}
