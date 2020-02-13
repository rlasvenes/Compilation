package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class LabelLocationList {
	private LabelLocation head;
	private LabelLocationList tail;

	public LabelLocationList(LabelLocation head, LabelLocationList tail) {
		super();
		this.head = head;
		this.tail = tail;
	}
	
	public String toString() {
		if(head != null) {
			if(tail != null) {
				return head.toString()+", "+tail.toString();
			}
			else {
				return head.toString();
			}
		}
		return "labelLocationList vide";
	}

}
