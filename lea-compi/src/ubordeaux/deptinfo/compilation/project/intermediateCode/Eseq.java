package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class Eseq extends Exp {
	private Stm stm;
	private Exp exp;

	public Eseq(Stm stm, Exp exp) {
		super();
		this.stm = stm;
		this.exp = exp;
	}
	
	public String toString() {
		if(stm != null && exp != null)
			return "ESEQ("+stm.toString()+", "+exp.toString()+")";
		return "Eseq invalide";
	}

}
