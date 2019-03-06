import java.util.ArrayList;
import java.util.List;

import beaver.Symbol;

public abstract class ComplexType extends Symbol implements Type {
	private List<Type> childs;
	public ComplexType() {
		childs = new ArrayList<Type>();
	}
	
	public Type getLeft() {
		return null;
	}
	
	public Type getRight() {
		return null;
	}
}