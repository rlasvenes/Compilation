import Functions.*;
import Operator.*;
import abstractTree.*;
import beaver.*;
import Declarations.*;
import Expressions.*;
import java.util.ArrayList;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "ParserExpr.grammar".
 */
public class ParserExpr extends Parser {

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9pLaabB0q4GXTyiPf8ODPqObxWRJIvUlNhrwa44pu8AWWT1mOCn10KL1V7iRtIB#rQ#wIb" +
		"b6FK7f8UlNjMhdfxfdW5mYIxqO19zA604enZ3k7M6syiHGG0V4upJSEKALMOPTA93Om2ZMG" +
		"ebLjwF7#gWLcaCHPcyMyqYXsxaKKGl#Z60idoYWYdvO7JWSXNVhXZmpanREg1dU8uE2NVfC" +
		"SjovpcD3lSVPOQPmvF$zaFDntfH5lMDNgvYx1UB8b1hm8vriYaSr1MI9Zl4a2OfwxoAwepg" +
		"B5dL$9pCaGsjByWysI8BP3Vq$uBZX1oJPL8dP#HKUqkgYwfhgjkgUwfrrNtLHk8PpKHze7h" +
		"uttibvXybwXfYGzx8AtaXp#J9ke$QVOZDl9UMtCcjtCWrgrPi4ME$Uj4I$WKUdIIkgazInF" +
		"b5wGly6Lxx");


static public class MyEvents extends beaver.Parser.Events {

	public void syntaxError(Symbol token) {
		System.err.print("Erreur de syntaxe ligne ");
		System.err.println(Symbol.getLine(token.getStart()));
		System.err.print("Token inattendu: ");
		System.err.println(Terminals.NAMES[token.getId()]);
	}
};

EnvironmentInt env = new Environment();

	private final Action[] actions;

	public ParserExpr() {
		super(PARSING_TABLES);
		actions = new Action[] {
			new Action() {	// [0] Program = Declarations.d SEMI Expression.e
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_d = _symbols[offset + 1];
					final AbstTree d = (AbstTree) _symbol_d.value;
					final Symbol _symbol_e = _symbols[offset + 3];
					final AbstTree e = (AbstTree) _symbol_e.value;
					 return new DeclarationList(d, e);
				}
			},
			new Action() {	// [1] Declarations = Declarations.d1 SEMI Declaration.d2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_d1 = _symbols[offset + 1];
					final AbstTree d1 = (AbstTree) _symbol_d1.value;
					final Symbol _symbol_d2 = _symbols[offset + 3];
					final AbstTree d2 = (AbstTree) _symbol_d2.value;
					 return new DeclarationList(d1, d2);
				}
			},
			new Action() {	// [2] Declarations = Declaration.d
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_d = _symbols[offset + 1];
					final AbstTree d = (AbstTree) _symbol_d.value;
					 return d;
				}
			},
			new Action() {	// [3] Declaration = ID.id EQ Expression.e
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_id = _symbols[offset + 1];
					final String id = (String) _symbol_id.value;
					final Symbol _symbol_e = _symbols[offset + 3];
					final AbstTree e = (AbstTree) _symbol_e.value;
					 return new Affectation(e, id);
				}
			},
			new Action() {	// [4] Expression = Expression.e1 PLUS Expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final AbstTree e1 = (AbstTree) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final AbstTree e2 = (AbstTree) _symbol_e2.value;
					 return new PlusSymbol(e1, e2);
				}
			},
			new Action() {	// [5] Expression = Expression.e1 MINUS Expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final AbstTree e1 = (AbstTree) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final AbstTree e2 = (AbstTree) _symbol_e2.value;
					 return new MinusSymbol(e1, e2);
				}
			},
			new Action() {	// [6] Expression = Expression.e1 TIMES Expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final AbstTree e1 = (AbstTree) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final AbstTree e2 = (AbstTree) _symbol_e2.value;
					 return new MultiplySymbol(e1, e2);
				}
			},
			new Action() {	// [7] Expression = Expression.e1 DIV Expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final AbstTree e1 = (AbstTree) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final AbstTree e2 = (AbstTree) _symbol_e2.value;
					 return new DivisionSymbol(e1, e2);
				}
			},
			new Action() {	// [8] Expression = MINUS Expression.e
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 2];
					final AbstTree e = (AbstTree) _symbol_e.value;
					 return new MinusSymbol(e);
				}
			},
			new Action() {	// [9] Expression = LPAR Expression.e RPAR
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 2];
					final AbstTree e = (AbstTree) _symbol_e.value;
					 return e;
				}
			},
			new Action() {	// [10] Expression = UFCT.fct LPAR Expression.e RPAR
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_fct = _symbols[offset + 1];
					final String fct = (String) _symbol_fct.value;
					final Symbol _symbol_e = _symbols[offset + 3];
					final AbstTree e = (AbstTree) _symbol_e.value;
					 return new UnaryFunction(e, fct);
				}
			},
			new Action() {	// [11] Expression = BFCT.fct LPAR Expression.e1 COMMA Expression.e2 RPAR
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_fct = _symbols[offset + 1];
					final String fct = (String) _symbol_fct.value;
					final Symbol _symbol_e1 = _symbols[offset + 3];
					final AbstTree e1 = (AbstTree) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 5];
					final AbstTree e2 = (AbstTree) _symbol_e2.value;
					 return new BinaryFunction(e1, e2, fct);
				}
			},
			new Action() {	// [12] Expression = ID.id
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_id = _symbols[offset + 1];
					final String id = (String) _symbol_id.value;
					 return new TypeIdenficatorExpr(id);
				}
			},
			new Action() {	// [13] Expression = INTEGER.i
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_i = _symbols[offset + 1];
					final Integer i = (Integer) _symbol_i.value;
					 return new TypeIntegerExpr(i);
				}
			},
			new Action() {	// [14] Expression = FLOAT.f
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_f = _symbols[offset + 1];
					final Double f = (Double) _symbol_f.value;
					 return new TypeFloatExpr(f);
				}
			},
			new Action() {	// [15] Expression = PI.p
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_p = _symbols[offset + 1];
					final Double p = (Double) _symbol_p.value;
					 return new TypeFloatExpr(p);
				}
			},
			new Action() {	// [16] Expression = E.e
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 1];
					final Double e = (Double) _symbol_e.value;
					 return new TypeFloatExpr(e);
				}
			}
		};


	report = new MyEvents();
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}
