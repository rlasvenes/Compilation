package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class ExpList implements IntermediateCode {
	private Exp head;
	private ExpList tail;

	public ExpList(Exp head, ExpList tail) {
		super();
		this.head = head;
		this.tail = tail;
	}

	@Override
	public void canonicalTransformation() {
		// TODO Auto-generated method stub
		System.err.println("TODO: " + this.getClass().getSimpleName() + ".canonicalTransformation()()");
	}
	
	public String toString() {
		if(head != null) {
			if(tail != null) {
				return head.toString()+", "+tail.toString();
			}
			else
				return head.toString();
		}
		return "List vide";
	}
}
