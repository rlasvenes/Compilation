package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class Cjump extends Stm {
	private int relop;
	private Exp left, right;
	private LabelLocation iftrue, iffalse;

	public Cjump(int relop, Exp left, Exp right, LabelLocation iftrue, LabelLocation iffalse) {
		super();
		this.relop = relop;
		this.left = left;
		this.right = right;
		this.iftrue = iftrue;
		this.iffalse = iffalse;
	}

	public final static int EQ = 0, NE = 1, LT = 2, GT = 3, LE = 4, GE = 5, ULT = 6, ULE = 7, UGT = 8, UGE = 9;

	public static int notRel(int relop) {
		switch (relop) {
		case EQ:
			return NE;
		case NE:
			return EQ;
		case LT:
			return GE;
		case GE:
			return LT;
		case GT:
			return LE;
		case LE:
			return GT;
		case ULT:
			return UGE;
		case UGE:
			return ULT;
		case UGT:
			return ULE;
		case ULE:
			return UGT;
		default:
			throw new Error("bad relop in CJUMP.notRel");
		}
	}
	
	public String toString() {
			String op = new String();
	
		switch (relop) {
		case EQ:
			op = " == ";
			break;
		case NE:
			op = " != ";
			break;
		case LT:
			op = " < ";
			break;
		case GE:
			op = " >= ";
			break;
		case GT:
			op = " > ";
			break;
		case LE:
			op = " <= ";
			break;

		case ULT:
			op = "  ";
			break;
		case UGE:
			op = "  ";
			break;
		case UGT:
			op = "  ";
			break;
		case ULE:
			op = "  ";
			break;
		default:
			return "Invalide operande";	
		}
		
		if(this.left != null && this.right != null && this.iftrue != null && this.iffalse != null) {
			return "IF " + this.left.toString() +op+ this.right.toString() + 
				" THEN GO TO : " + this.iftrue.toString() +" ELSE GO TO : " + this.iffalse.toString();
		}
		return "Saut Impossible ";			
			
	}
}			
			
			
			
			
			
			
			
			
			
			
			
			
				
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
		

