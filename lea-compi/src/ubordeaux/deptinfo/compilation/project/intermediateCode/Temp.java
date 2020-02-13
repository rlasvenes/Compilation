package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class Temp extends Exp {
	private TempValue temp;

	public Temp(TempValue temp) {
		super();
		this.temp = temp;
	}
	
	public String toString() {
		if(temp != null) {
			return temp.toString();
		}
		return "temp invalide";
	}

}
