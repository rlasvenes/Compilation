package ubordeaux.deptinfo.compilation.project.environment;

import ubordeaux.deptinfo.compilation.project.node.Node;
import java.util.Stack;

public class StackEnvironment {

	private Stack<String> stack;

	public StackEnvironment(String str) {
		stack = new Stack<>();
	}

	public void push(String variable) {
		System.out.println("\nEnregistre la variable locale: " + variable + " dans la pile" );
		stack.push(variable);
	}


	public String pop() {
		if(!stack.empty()) {
			System.out.println("\nVariable locale dépilé" );
			return stack.pop();
		}
		else {
			return null;
		}
	}
}
