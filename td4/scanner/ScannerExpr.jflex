import beaver.Symbol;
import beaver.Scanner;

%%

%{
    // attributs de la classe ici
%}


%class ScannerExpr
%extends Scanner
%function nextToken
%type Symbol
%yylexthrow Scanner.Exception
%eofval{

%eofval}
%unicode

%%

	"("             { System.out.println(" ( ");return new Symbol(Terminals.LPARENTH); }
	")"             { System.out.println(" ) ");return new Symbol(Terminals.RPARENTH); }
	"+"             { System.out.println(" + ");return new Symbol(Terminals.PLUS); }
	"-"             { System.out.println(" - ");return new Symbol(Terminals.MINUS); }
	"*"             { System.out.println(" * ");return new Symbol(Terminals.MULT); }
	"/"             { System.out.println(" / ");return new Symbol(Terminals.DIVIDE); }
	[0-9]+			{ System.out.println("text : " + yytext());return new Symbol(Terminals.TOKEN_NUMBER, yytext()); }
	[^]|\n         	{ }
