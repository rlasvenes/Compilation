import java.util.HashMap;
import java.util.Map;

public class ImpleEnvironment implements Environment {

	private Map<String, Type> identifiers;

	@Override
	public void addType(String name, Type t) {
		identifiers.put(name, t);
		System.out.println("Ajout du type " + t.toString());
	}

	@Override
	public Type getType(String name) {
		return identifiers.get(name);
	}

	public ImpleEnvironment() {
		super();
		identifiers = new HashMap<String, Type>();
	}

}
