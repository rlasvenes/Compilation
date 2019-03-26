package abstractTree;
import java.util.HashMap;
import java.util.Map;

public class Environment implements EnvironmentInt {

	private Map<String, Double> table;

	public Environment() {
		this.table = new HashMap<String, Double>();
	}

	@Override
	public void putVariable(String variable, Double value) {
		table.put(variable, value);
		System.out.println("ADD " + variable + " : " + value);
	}

	@Override
	public Double getVariableValue(String variable) {
		System.out.println("GET " + variable + " " + table.get(variable));
		return table.get(variable);
	}

	@Override
	public String toString() {
		return "Environment{" +
				"table=" + table +
				'}';
	}
}
