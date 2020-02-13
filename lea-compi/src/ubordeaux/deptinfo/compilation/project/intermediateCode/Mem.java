package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class Mem extends Exp {
	private Exp exp;

	public Mem(Exp exp) {
		super();
		this.exp = exp;
	}
	
	public String toString() {
		if(exp != null)
			return "Mem("+exp.toString() + ")";
		return "Acces memoire interdit";
	}

}
