package abstractTree;

import beaver.Symbol;

public abstract class AbstTree extends Symbol implements AbstTreeInt {

	protected AbstTree left;
	protected AbstTree right;
	protected Double value;

	public AbstTree(AbstTree left, AbstTree right) {
		super();
		this.left = left;
		this.right = right;
	}

	public AbstTree(AbstTree left) {
		super();
		this.left = left;
	}

	public AbstTree() {
		super();
	}

	public Double getValue() {
		return value;
	}

	public String toString() {
		if (left != null)
			if (right != null)
				return this.getClass().getSimpleName() + "(" + left.toString() + ", " + right.toString() + ")";
			else
				return this.getClass().getSimpleName() + "(" + left.toString() + ")";
<<<<<<< HEAD
		else
			return this.getClass().getSimpleName();
	}

	public void printAST() {
		Visualizer.toDOT("file.dot", this);
=======
			else
				return this.getClass().getSimpleName();
>>>>>>> 942e1b66578a705a235a5687cc9a15479468dfcc
	}

	public void eval(EnvironmentInt environment) throws Exception {System.out.println("Eval:" + toString()); this.peval(environment);};

	abstract protected void peval(EnvironmentInt environment) throws Exception;
}
