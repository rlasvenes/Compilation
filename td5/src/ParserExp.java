import beaver.*;
import java.util.ArrayList;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "Parser.grammar".
 */
public class ParserExp extends Parser {

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9obaajF544KXK$RCyoJURz0S8GHSHGILhEO3GPCq1YC2J70WfqR$WN$5byWC88WwENheYO" +
		"s4zXeLRuwfsxLxRxTLP9sLL5HawghuDpulpapfVK0ahQlh1BAGKTZga57RQNqJ5squxJbOf" +
		"bRiJIzhRpp2Vg27f4xfb1FL28ZfmarL5PJKwpCm9ogUgvvt0jugCUQrgoUAg2Ia2Sa$yi9N" +
		"uSoxyvIVnu2giX2G5rbwisWWTEoYzLknOBOlXIzGhqvUlGDASOytrFZVIMt4f5rqU5idFm2" +
		"iIArBEunH1WDwK0YcjCoNWlGzhuAgyCSsbluu7qBvhoVXjVUl$Aw2Gkm5Sl$24kmu#Szs81" +
		"jw0$t#RMN8$CIB7lVy3hhjHlRruldZJnZFUPNxjcpTaViJSptO$xToBxtCR$8N$vpO#qx7D" +
		"eNng$moGPsOiUu8xTwu5Q#sMVxRGCNkR9Bd$dBphoxi7FxYVwmKqL$lyMPrt5rjC5Tgt3E5" +
		"QT9pYrmD5blEWtTtVfBU0S9xf4WW50JrnNmQMu=");

	static final Action RETURN2 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 2];
		}
	};

	static final Action RETURN3 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 3];
		}
	};

	static class Events extends beaver.Parser.Events
	{
		public void syntaxError(Symbol token)
		{
			System.err.format("Erreur de syntaxe en ligne %d, colonne %d. Token inattendu: %s\n",
				Symbol.getLine(token.getStart()),
				Symbol.getColumn(token.getStart()),
				Terminals.NAMES[token.getId()]);
		}
	}

	Environment env = new ImpleEnvironment();

	private final Action[] actions;

	public ParserExp() {
		super(PARSING_TABLES);
		actions = new Action[] {
			RETURN2,	// [0] expression_typee = declaration_list expression; returns 'expression' although none is marked
			Action.NONE,  	// [1] declaration_list = 
			RETURN2,	// [2] declaration_list = declaration_list declaration; returns 'declaration' although none is marked
			new Action() {	// [3] declaration = IDENT.id COLON type.t SEMICOLON
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_id = _symbols[offset + 1];
					final String id = (String) _symbol_id.value;
					final Symbol _symbol_t = _symbols[offset + 3];
					final Type t = (Type) _symbol_t.value;
					 env.addType(id, t);return new Symbol(0);
				}
			},
			Action.RETURN,	// [4] type = type_simple
			new Action() {	// [5] type = LIST.l LPAR type.t RPAR
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol l = _symbols[offset + 1];
					final Symbol _symbol_t = _symbols[offset + 3];
					final Type t = (Type) _symbol_t.value;
					 return new ListType(l, t);
				}
			},
			new Action() {	// [6] type = LPAR type_list.l RPAR MAPSTO type.t
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol l = _symbols[offset + 2];
					final Symbol _symbol_t = _symbols[offset + 5];
					final Type t = (Type) _symbol_t.value;
					 return new TypeFunction(l, t);
				}
			},
			new Action() {	// [7] type_simple = TYPE_INT
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new SimpleType(SimpleType.Kinds.INT);
				}
			},
			new Action() {	// [8] type_simple = TYPE_STRING
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new SimpleType(SimpleType.Kinds.STRING);
				}
			},
			Action.NONE,  	// [9] type_list = 
			new Action() {	// [10] type_list = type.t
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_t = _symbols[offset + 1];
					final Type t = (Type) _symbol_t.value;
					 return new ListType(t);
				}
			},
			new Action() {	// [11] type_list = type_list.l COMMA type.t
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol l = _symbols[offset + 1];
					final Symbol _symbol_t = _symbols[offset + 3];
					final Type t = (Type) _symbol_t.value;
					 return new ListType(l, t);
				}
			},
			Action.RETURN,	// [12] expression = IDENT
			new Action() {	// [13] expression = CONST_INT
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new SimpleType(SimpleType.Kinds.INT);
				}
			},
			new Action() {	// [14] expression = CONST_STRING
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new SimpleType(SimpleType.Kinds.INT);
				}
			},
			new Action() {	// [15] expression = CONST_STRING PLUS CONST_STRING
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new SimpleType(SimpleType.Kinds.STRING);
				}
			},
			new Action() {	// [16] expression = expression.e1 PLUS expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol e1 = _symbols[offset + 1];
					final Symbol e2 = _symbols[offset + 3];
					 return new Add(e1, e2);
				}
			},
			new Action() {	// [17] expression = expression.e1 MINUS expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol e1 = _symbols[offset + 1];
					final Symbol e2 = _symbols[offset + 3];
					 return new Minus(e1, e2);
				}
			},
			new Action() {	// [18] expression = LPAR expression.e RPAR
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol e = _symbols[offset + 2];
					 return e;
				}
			},
			new Action() {	// [19] expression = LBRACKET expression_list.l RBRACKET
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol l = _symbols[offset + 2];
					 return new ListExpr(l);
				}
			},
			new Action() {	// [20] expression = expression.e LPAR expression_list.l RPAR
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol e = _symbols[offset + 1];
					final Symbol l = _symbols[offset + 3];
					 return new ListExpr(e, l);
				}
			},
			Action.NONE,  	// [21] expression_list = 
			Action.RETURN,	// [22] expression_list = expression
			RETURN3	// [23] expression_list = expression_list COMMA expression; returns 'expression' although none is marked
		};


	report = new Events();
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}
