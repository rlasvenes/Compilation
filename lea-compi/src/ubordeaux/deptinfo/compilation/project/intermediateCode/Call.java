package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class Call extends Exp {
	private Exp func;
	private ExpList args;

	public Call(Exp func, ExpList args) {
		super();
		this.func = func;
		this.args = args;
	}
	
	public String toString() {
		if(func != null)
			if(args != null)
				return "call("+func.toString()+", "+args.toString()+")";
			else
				return "argument de fonction invalide";
		return "fonction invalide";
	}

}
