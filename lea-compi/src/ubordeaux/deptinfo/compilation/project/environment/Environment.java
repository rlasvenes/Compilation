package ubordeaux.deptinfo.compilation.project.environment;
import ubordeaux.deptinfo.compilation.project.type.*;

import java.util.HashMap;
import java.util.Map;

public class Environment {

	private Map<String, Type> tableTypes;
	private Map<String, Type> tableProc;

	public Environment(String t){
		if (t.equals("types")) {
			this.tableTypes = new HashMap<String, Type>();
		}

		if (t.equals("procedures")){
			this.tableProc = new HashMap<String, Type>();
		}
	}

	public void putType(String variable, Type type) {
		tableTypes.put(variable, type);
		// System.out.println("Enregistre " + variable + " " + type);
	}

	public Type getType(String type) {
		// System.out.println("Retrouve " + type + " " + tableTypes.get(type));
		return tableTypes.get(type);
	}

	public void putProc(String variable, Type type) {
		tableProc.put(variable, type);
		// System.out.println("Enregistre " + variable + " " + type);
	}

	public Type getProc(String type) {
		// System.out.println("Retrouve " + type + " " + tableTypes.get(type));
		return tableProc.get(type);
	}


}
