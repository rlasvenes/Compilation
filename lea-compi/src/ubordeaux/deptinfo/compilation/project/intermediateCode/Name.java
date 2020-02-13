package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class Name extends Exp {
	private LabelLocation label;

	public Name(LabelLocation label) {
		super();
		this.label = label;
	}
	
	public String toString() {
		if(label != null)
			return label.toString();
		return "Pas de name";
	}

}
