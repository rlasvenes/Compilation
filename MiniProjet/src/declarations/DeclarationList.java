package declarations;

import abstractTree.AbstTree;
import abstractTree.EnvironmentInt;

public class DeclarationList extends AbstTree {

	public DeclarationList(AbstTree e1) {
		super(e1);
	}

	public DeclarationList(AbstTree e1, AbstTree e2) {
		super(e1, e2);
	}

	@Override
	protected void peval(EnvironmentInt environment) throws Exception {
		if (left != null && right != null) {
			left.eval(environment); // evaluation du sous-arbre gauche
			right.eval(environment); // evaluation du sous-arbre droit

//			environment.putVariable(left.toString(), left.getValue());
//			environment.putVariable(right.toString(), right.getValue());

			value = right.getValue(); // on récupère la dernière valeur (donc right) APRES avoir évalué les
									  // sous-arbres gauche et droite.

		} else if (left != null) {
			left.eval(environment); // evaluation du sous-arbre gauche
			value = left.getValue();
		} else {
			throw new Exception("Left tree cannot be null (DeclarationList)");
		}
	}
}
