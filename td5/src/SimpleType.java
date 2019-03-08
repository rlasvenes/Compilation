import beaver.Symbol;

public class SimpleType extends Symbol implements Type {

	public enum Kinds {
		INT("int"), FLOAT("float"), STRING("string");

		private String name;

		private Kinds(String name) {
			this.name = name;
		}

		public String toString(){
			return name;
		}
	}

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

	@Override
	public String toString() {
		return kindOf.name();
	}


}
