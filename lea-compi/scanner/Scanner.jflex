package ubordeaux.deptinfo.compilation.project.main;

import beaver.Symbol;
import beaver.Scanner;

%%

%class ScannerExpr
%extends Scanner
%function nextToken
%type Symbol
%yylexthrow Scanner.Exception
%eofval{
	return new Symbol(Terminals.EOF);
%eofval}
%unicode
%line
%column
%state COMMENT
%state YYINITIAL
%{
	// Petit helpers pour simplifier la création de token.
	// On retient la position de chaque token pour la gestion d'erreur
	// voir beaver-rt/src/main/java/beaver/Symbol.java
	private Symbol newToken(short id)
	{
		return new Symbol(id, yyline + 1, yycolumn + 1, yylength(), null);
	}

	private Symbol newToken(short id, Object value)
	{
		return new Symbol(id, yyline + 1, yycolumn + 1, yylength(), value);
	}

%}


Identifier = [a-zA-Z_][a-zA-Z0-9_]*
IntegerDecimal = [0-9]+
IntegerHexa = 0[xX][0-9a-fA-F]+
String = "\"" ~ "\""

Comment = "//"~"\n"

CommentStart= "/*"
CommentEnd= "*/"

%%

<YYINITIAL>
{
	"+"					{System.out.printf(yytext());return newToken(Terminals.TOKEN_PLUS, yytext());}
	"-"					{System.out.printf(yytext());return newToken(Terminals.TOKEN_MINUS, yytext());}
	"*"					{System.out.printf(yytext());return newToken(Terminals.TOKEN_TIMES, yytext());}
	"/"					{System.out.printf(yytext());return newToken(Terminals.TOKEN_DIV, yytext());}

	".."				{System.out.printf(yytext());return newToken(Terminals.TOKEN_DOTDOT);}
	";"					{System.out.printf(yytext());return newToken(Terminals.TOKEN_SEMIC);}
	","					{System.out.printf(yytext());return newToken(Terminals.TOKEN_COMMA);}
	"^"					{System.out.printf(yytext());return newToken(Terminals.TOKEN_CIRC);}
	":"					{System.out.printf(yytext());return newToken(Terminals.TOKEN_COLON);}

	"("					{System.out.printf(yytext());return newToken(Terminals.TOKEN_LPAR);}
	")"					{System.out.printf(yytext());return newToken(Terminals.TOKEN_RPAR);}
	"["					{System.out.printf(yytext());return newToken(Terminals.TOKEN_LBRACE);}
	"]"					{System.out.printf(yytext());return newToken(Terminals.TOKEN_RBRACE);}

	"="					{System.out.printf(yytext());return newToken(Terminals.TOKEN_AFF);}
	"=="				{System.out.printf(yytext());return newToken(Terminals.TOKEN_EQ);}
	"!="				{System.out.printf(yytext());return newToken(Terminals.TOKEN_NE);}
	">"					{System.out.printf(yytext());return newToken(Terminals.TOKEN_GT);}
	">="				{System.out.printf(yytext());return newToken(Terminals.TOKEN_GE);}
	"<"					{System.out.printf(yytext());return newToken(Terminals.TOKEN_LT);}
	"<="				{System.out.printf(yytext());return newToken(Terminals.TOKEN_LE);}
	"||"				{System.out.printf(yytext());return newToken(Terminals.TOKEN_OR);}
	"&&"				{System.out.printf(yytext());return newToken(Terminals.TOKEN_AND);}
	"!"					{System.out.printf(yytext());return newToken(Terminals.TOKEN_NOT);}

	"true"				{System.out.printf(yytext());return newToken(Terminals.TOKEN_TRUE);}
	"false" 			{System.out.printf(yytext());return newToken(Terminals.TOKEN_FALSE);}

	"if" 				{System.out.printf(yytext());return newToken(Terminals.TOKEN_IF);}
	"then"  			{System.out.printf(yytext() + "\n");return newToken(Terminals.TOKEN_THEN);}
	"else"  			{System.out.printf(yytext());return newToken(Terminals.TOKEN_ELSE);}
	"while"				{System.out.printf(yytext());return newToken(Terminals.TOKEN_WHILE);}
	"do"				{System.out.printf(yytext());return newToken(Terminals.TOKEN_DO);}

	"array"				{System.out.printf(yytext());return newToken(Terminals.TOKEN_ARRAY);}
	"of"				{System.out.printf(yytext());return newToken(Terminals.TOKEN_OF);}
	"var"				{System.out.printf(yytext());return newToken(Terminals.TOKEN_VAR);}
	"procedure"			{System.out.printf(yytext());return newToken(Terminals.TOKEN_PROCEDURE);}
	"function"			{System.out.printf(yytext());return newToken(Terminals.TOKEN_FUNCTION);}
	"dispose"			{System.out.printf(yytext());return newToken(Terminals.TOKEN_DISPOSE);}
	"readln"			{System.out.printf(yytext());return newToken(Terminals.TOKEN_READLN, yytext());}

	"null"				{System.out.printf(yytext());return newToken(Terminals.TOKEN_NULL);}
	"struct"			{System.out.printf(yytext());return newToken(Terminals.TOKEN_STRUCT);}
	"return"			{System.out.printf(yytext());return newToken(Terminals.TOKEN_RETURN);}
	"new"				{System.out.printf(yytext());return newToken(Terminals.TOKEN_NEW);}
	"println"			{System.out.printf(yytext());return newToken(Terminals.TOKEN_PRINTLN, yytext());}
	"begin"				{System.out.println("begin");return newToken(Terminals.TOKEN_BEGIN);}
	"end"				{System.out.println("end");return newToken(Terminals.TOKEN_END);}
	"switch"			{System.out.println("switch");return newToken(Terminals.TOKEN_SWITCH);}
	"case"				{System.out.println("case");return newToken(Terminals.TOKEN_CASE);}
	"default"			{System.out.println("default");return newToken(Terminals.TOKEN_DEFAULT);}
	"type"				{System.out.println("type"); return newToken(Terminals.TOKEN_TYPE);}

	"string"			{System.out.println("string");return newToken(Terminals.TOKEN_STRING, yytext());}
	"integer"			{System.out.println("integer");return newToken(Terminals.TOKEN_INTEGER, yytext());}
	"boolean"			{System.out.println("boolean");return newToken(Terminals.TOKEN_BOOLEAN, yytext());}


	{IntegerDecimal}			{System.out.printf(yytext()); return newToken(Terminals.TOKEN_LIT_INTEGER, Integer.parseInt(yytext()));}
	{IntegerHexa}				{System.out.printf(yytext()); return newToken(Terminals.TOKEN_LIT_INTEGER, Integer.decode(yytext()));}
	{Identifier}				{System.out.printf(yytext()); return newToken(Terminals.TOKEN_IDENTIFIER, yytext());}
	{String}					{System.out.printf(yytext()); return newToken(Terminals.TOKEN_LIT_STRING, yytext());}


	{Comment}		{System.out.printf("COMMENT:%s\n",yytext());}
	{CommentStart} 	{System.out.printf("COMMENT: ");yybegin(COMMENT);}


}

<COMMENT>{
{CommentEnd} 	{yybegin(YYINITIAL);}
.				{System.out.printf("%s",yytext());}
\n 				{System.out.printf("\nCOMMENT: ");}
}


[\s] {}

[^]
	{
		throw new Scanner.Exception("caractère inattendu '" + yytext() + "'");
	}
