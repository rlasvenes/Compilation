import beaver.*;
import java.util.ArrayList;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "ParserExpr.grammar".
 */
public class ParserExpr extends Parser {

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9nTaDiEmY0GHASLszgBZJwq9ZxvftwszRQTtIv4X1ncc6K30S1D1AKyiCCUDGv9Z#ZHPGI" +
		"hgQkIQz1Y0AZQ6PXMIMiKA3CQg$qxdS1uXurk4mo#Z$c9dCb4Pi#k9AXNH6Jnl8yzhfFh7C" +
		"zoN7xyw7T2lkH3tkGbJyiMBleZXRqwPylQ5PeF7UG=");

	private final Action[] actions;

	public ParserExpr() {
		super(PARSING_TABLES);
		actions = new Action[] {
			new Action() {	// [0] Expr = ExprArithm.e
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 1];
					final MySymbol e = (MySymbol) _symbol_e.value;
					 System.out.println("resultat = " + e.value);return e;
				}
			},
			new Action() {	// [1] ExprArithm = ExprArithm.a MULT ExprArithm.b
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final MySymbol a = (MySymbol) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final MySymbol b = (MySymbol) _symbol_b.value;
					 System.out.println("reduce MULT");   return new MySymbol(a.value * b.value);
				}
			},
			new Action() {	// [2] ExprArithm = ExprArithm.a DIVIDE ExprArithm.b
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final MySymbol a = (MySymbol) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final MySymbol b = (MySymbol) _symbol_b.value;
					 System.out.println("reduce DIVIDE"); return new MySymbol(a.value / b.value);
				}
			},
			new Action() {	// [3] ExprArithm = ExprArithm.a PLUS ExprArithm.b
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final MySymbol a = (MySymbol) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final MySymbol b = (MySymbol) _symbol_b.value;
					 System.out.println("reduce PLUS");   return new MySymbol(a.value + b.value);
				}
			},
			new Action() {	// [4] ExprArithm = ExprArithm.a MINUS ExprArithm.b
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final MySymbol a = (MySymbol) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final MySymbol b = (MySymbol) _symbol_b.value;
					 System.out.println("reduce MINUS");  return new MySymbol(a.value - b.value);
				}
			},
			new Action() {	// [5] ExprArithm = TOKEN_NUMBER.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol n = _symbols[offset + 1];
					 System.out.println("reduce NUMBER"); return n;
				}
			},
			new Action() {	// [6] ExprArithm = LPARENTH ExprArithm.e RPARENTH
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 2];
					final MySymbol e = (MySymbol) _symbol_e.value;
					 System.out.println("reduce EXPR");   return e;
				}
			}
		};
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}