/**
 * This class lists terminals used by the
 * grammar specified in "Parser.grammar".
 */
public class Terminals {
	static public final short EOF = 0;
	static public final short LPAR = 1;
	static public final short CONST_STRING = 2;
	static public final short IDENT = 3;
	static public final short LBRACKET = 4;
	static public final short CONST_INT = 5;
	static public final short LIST = 6;
	static public final short PLUS = 7;
	static public final short TYPE_INT = 8;
	static public final short TYPE_STRING = 9;
	static public final short RPAR = 10;
	static public final short MINUS = 11;
	static public final short COMMA = 12;
	static public final short COLON = 13;
	static public final short SEMICOLON = 14;
	static public final short MAPSTO = 15;
	static public final short RBRACKET = 16;

	static public final String[] NAMES = {
		"EOF",
		"LPAR",
		"CONST_STRING",
		"IDENT",
		"LBRACKET",
		"CONST_INT",
		"LIST",
		"PLUS",
		"TYPE_INT",
		"TYPE_STRING",
		"RPAR",
		"MINUS",
		"COMMA",
		"COLON",
		"SEMICOLON",
		"MAPSTO",
		"RBRACKET"
	};
}
