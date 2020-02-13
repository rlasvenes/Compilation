package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class TempValueList {
	private TempValue head;
	private TempValueList tail;

	public TempValueList(TempValue head, TempValueList tail) {
		super();
		this.head = head;
		this.tail = tail;
	}
	
	public String toString() {
		if(head != null) {
			if(tail != null) {
				return head.toString()+", "+tail.toString();
			}
			else
				return head.toString();
		}
		return "TempValueList vide";
	}

}
