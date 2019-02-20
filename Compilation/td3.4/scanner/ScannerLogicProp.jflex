import beaver.Symbol;
import beaver.Scanner;

%%

%{
    // attributs de la classe ici
%}


%class ScannerLogicProp
%extends Scanner
%function nextToken
%type Symbol
%yylexthrow Scanner.Exception
%eofval{

%eofval}
%unicode

%%

	\u2228         	{ System.out.printf(" ∨ ");return new Symbol(Terminals.OR); }
	\u2227         	{ System.out.printf(" ∧ ");return new Symbol(Terminals.AND); }
	\u00AC         	{ System.out.printf(" ¬ ");return new Symbol(Terminals.NEGATION); }
    "1"             { System.out.printf(" 1 ");return new Symbol(Terminals.TRUE); }
    "0"             { System.out.printf(" 0 ");return new Symbol(Terminals.FALSE); }
    "("             { System.out.printf(" ( ");return new Symbol(Terminals.LPARENTH); }
    ")"             { System.out.printf(" ) ");return new Symbol(Terminals.RPARENTH); }
    [a-zA-Z]+      	{ System.out.printf(yytext());return new Symbol(Terminals.VARIABLE); }
    \n              { System.out.printf(" \n ");return new Symbol(Terminals.NEWLINE); }
	[^]         	{ }
