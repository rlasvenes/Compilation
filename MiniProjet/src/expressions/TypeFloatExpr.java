package expressions;

import java.math.BigDecimal;
import java.math.RoundingMode;

import abstractTree.AbstTree;
import abstractTree.EnvironmentInt;

public class TypeFloatExpr extends AbstTree {

	public TypeFloatExpr(Double val) {
		super();
		this.value = val;
		token = BigDecimal.valueOf(val)
			    .setScale(3, RoundingMode.HALF_UP)
			    .toString();
	}

	@Override
	protected void peval(EnvironmentInt environment) throws Exception {
		System.out.println(environment);
		environment.putVariable(this.toString(), value);
	}

	public String toString() {
		return value.toString();
	}
}
