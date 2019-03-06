import beaver.Symbol;

public class SimpleType extends Symbol implements Type {

	private enum Kinds {
		INT, FLOAT, STRING
	};
	
	private Kinds kindOf;
	
	public SimpleType(Kinds kindOf) {
		this.kindOf = kindOf;
	}
	
	@Override
	public boolean compareTo(Type t) {
		if (t == null) {
			return false;
		}
		
		// TODO
		
		return false;
	}
	
}