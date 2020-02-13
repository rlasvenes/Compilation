package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class Binop extends Exp {
	private int binop;
	private Exp left, right;

	public Binop(int b, Exp l, Exp r) {
		super();
		binop = b;
		left = l;
		right = r;
	}

	public final static int PLUS = 0, MINUS = 1, MUL = 2, DIV = 3, AND = 4, OR = 5, LSHIFT = 6, RSHIFT = 7, ARSHIFT = 8,
			XOR = 9, NOT = 10;

	public String toString() {
		String op = new String();
		switch(binop) {
		case PLUS:
			op = "+";
			break;
		case MINUS:
			op = "-";
			break;
		case MUL:
			op = "*";
			break;
		case DIV:
			op = "/";
			break;
		case AND:
			op = "&&";
			break;
		case OR:
			op = "||";
			break;
		case LSHIFT:
			op = "<<";
			break;
		case RSHIFT:
			op = ">>";
			break;
		case ARSHIFT:
			op = ">>>";
			break;
		case XOR:
			op = "^";
			break;	
		case NOT:
			op = "!";
			break;
		default:
			op = " ";	
		}
		if(this.left != null) {
			if(this.right != null) {
				if(binop < 0) {
					return "Binop("+left.toString()+", "+right.toString()+")";
				}
				return "Binop("+op+", "+left.toString()+", "+right.toString()+")";
			}
			else {
				if(binop == MINUS || binop == NOT)
					return "Binop("+op+", "+left.toString();
			}
		}
		return "Operation impossible";
	}

}
