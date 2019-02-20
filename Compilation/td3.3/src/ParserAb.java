import beaver.*;
import java.util.ArrayList;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "ParserAb.grammar".
 */
public class ParserAb extends Parser {

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9nTZjiAW30CG#CkLOS##CV#jjUOLGLnS4ZQTKi1J4Ze4RYGCAvEGeIXbSi0EjMvrl8DWbC" +
		"xZSy5lOkwAJFyc4YF7nujOgp#XUGkoTzUJVhLvHQUOdUtyV2CLkccFKoQVPyezCC5eEqUom" +
		"==");

	static final Action RETURN3 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 3];
		}
	};

	private final Action[] actions;

	public ParserAb() {
		super(PARSING_TABLES);
		actions = new Action[] {
			Action.RETURN,	// [0] $goal = S
			new Action() {	// [1] S = S L
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2]); return _symbols[offset + 1];
				}
			},
			new Action() {	// [2] S = L
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
				}
			},
			new Action() {	// [3] L = AB NEWLINE.nl
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol nl = _symbols[offset + 2];
					 System.out.println("ligne (jflex) = " + nl.value);return nl;
				}
			},
			RETURN3,	// [4] AB = A AB B; returns 'B' although none is marked
			Action.NONE	// [5] AB = 
		};
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}
