import java.io.*;

%%

%{
    String str;
    int len = 0;
%}

%public
%class Tokenizer
%type Token
%line
%column
%char
%state COMMENT, COMMENT_DOC, STRING
/* etat inclusif/exclusif
    ex: une chaine de caractere qui est dans un commentaire
*/

Identificateur = [a-zA-Z_][a-zA-Z0-9_]*
Chiffre = [0-9]
Entier = {Chiffre}+
Flottant = {Entier}?("."{Entier})?([eE][+-]?{Entier})
Separateur = "," | ";" | ":" | "(" | ")" | "[" | "]" | "." | "{" | "}" /* jamais matché (?)*/
String = \" ~\"
CommentaireMultiligne = "/*" .* ~"*/"
CommentaireSimple = "//"(.*)

%%

/* D'abord mot cles, ensuite operateurs, puis identificateurs et littéraux en dernier */

<COMMENT> {
    "*/"            {yybegin(YYINITIAL);}
    [^]|\n          {}
}

<COMMENT_DOC> {
    "@author " ~"\n"        {
        str = yytext();
        len = str.length();
        return new Token(Sym.TOKEN_AUTHOR, str.substring(7, len-1), yyline, yycolumn); /* -1 car on veut pas prendre le \n qui est le dernier caractère */
    }
    "*/"                    {yybegin(YYINITIAL);}
}

<YYINITIAL> {
    /* Keywords */
    bool        {return new Token(Sym.TOKEN_BOOL, null, yyline, yycolumn);}
    break       {return new Token(Sym.TOKEN_BREAK, null, yyline, yycolumn);}
    case        {return new Token(Sym.TOKEN_CASE, null, yyline, yycolumn);}
    catch       {return new Token(Sym.TOKEN_CATCH, null, yyline, yycolumn);}

    char        {return new Token(Sym.TOKEN_CHAR, null, yyline, yycolumn);}
    class       {return new Token(Sym.TOKEN_CLASS, null, yyline, yycolumn);}
    const       {return new Token(Sym.TOKEN_CONST, null, yyline, yycolumn);}
    continue    {return new Token(Sym.TOKEN_CONTINUE, null, yyline, yycolumn);}
    default     {return new Token(Sym.TOKEN_DEFAULT, null, yyline, yycolumn);}

    delete      {return new Token(Sym.TOKEN_DELETE, null, yyline, yycolumn);}
    do          {return new Token(Sym.TOKEN_DO, null, yyline, yycolumn);}
    double      {return new Token(Sym.TOKEN_DOUBLE, null, yyline, yycolumn);}
    elseif      {return new Token(Sym.TOKEN_ELSEIF, null, yyline, yycolumn);} /* l'ordre du else/elseif n'importe pas */
    else        {return new Token(Sym.TOKEN_ELSE, null, yyline, yycolumn);}
    enum        {return new Token(Sym.TOKEN_ENUM, null, yyline, yycolumn);}

    false       {return new Token(Sym.TOKEN_FALSE, null, yyline, yycolumn);}
    float       {return new Token(Sym.TOKEN_FLOAT, null, yyline, yycolumn);}
    for         {return new Token(Sym.TOKEN_FOR, null, yyline, yycolumn);}
    friend      {return new Token(Sym.TOKEN_FRIEND, null, yyline, yycolumn);}
    goto        {return new Token(Sym.TOKEN_GOTO, null, yyline, yycolumn);}
    if          {return new Token(Sym.TOKEN_IF, null, yyline, yycolumn);}
    inline      {return new Token(Sym.TOKEN_INLINE, null, yyline, yycolumn);}
    int         {return new Token(Sym.TOKEN_INT, null, yyline, yycolumn);}
    long        {return new Token(Sym.TOKEN_LONG, null, yyline, yycolumn);}

    namespace   {return new Token(Sym.TOKEN_NAMESPACE, null, yyline, yycolumn);}
    new         {return new Token(Sym.TOKEN_NEW, null, yyline, yycolumn);}
    operator    {return new Token(Sym.TOKEN_OPERATOR, null, yyline, yycolumn);}
    private     {return new Token(Sym.TOKEN_PRIVATE, null, yyline, yycolumn);}

    protected   {return new Token(Sym.TOKEN_PROTECTED, null, yyline, yycolumn);}
    public      {return new Token(Sym.TOKEN_PUBLIC, null, yyline, yycolumn);}
    register    {return new Token(Sym.TOKEN_REGISTER, null, yyline, yycolumn);}
    return      {return new Token(Sym.TOKEN_RETURN, null, yyline, yycolumn);}
    short       {return new Token(Sym.TOKEN_SHORT, null, yyline, yycolumn);}

    signed      {return new Token(Sym.TOKEN_SIGNED, null, yyline, yycolumn);}
    sizeof      {return new Token(Sym.TOKEN_SIZEOF, null, yyline, yycolumn);}
    static      {return new Token(Sym.TOKEN_STATIC, null, yyline, yycolumn);}
    struct      {return new Token(Sym.TOKEN_STRUCT, null, yyline, yycolumn);}
    switch      {return new Token(Sym.TOKEN_SWITCH, null, yyline, yycolumn);}
    template    {return new Token(Sym.TOKEN_TEMPLATE, null, yyline, yycolumn);}

    this        {return new Token(Sym.TOKEN_THIS, null, yyline, yycolumn);}
    throw       {return new Token(Sym.TOKEN_THROW, null, yyline, yycolumn);}
    true        {return new Token(Sym.TOKEN_TRUE, null, yyline, yycolumn);}
    try         {return new Token(Sym.TOKEN_TRY, null, yyline, yycolumn);}
    typedef     {return new Token(Sym.TOKEN_TYPEDEF, null, yyline, yycolumn);}
    typeid      {return new Token(Sym.TOKEN_TYPEID, null, yyline, yycolumn);}
    typename    {return new Token(Sym.TOKEN_TYPENAME, null, yyline, yycolumn);}
    union       {return new Token(Sym.TOKEN_UNION, null, yyline, yycolumn);}
    unsigned    {return new Token(Sym.TOKEN_UNSIGNED, null, yyline, yycolumn);}

    using       {return new Token(Sym.TOKEN_USING, null, yyline, yycolumn);}
    virtual     {return new Token(Sym.TOKEN_VIRTUAL, null, yyline, yycolumn);}
    void        {return new Token(Sym.TOKEN_VOID, null, yyline, yycolumn);}
    while       {return new Token(Sym.TOKEN_WHILE, null, yyline, yycolumn);}

    /* IDENTIFICATEURS (toujours après les mots-clés, sinon ils vont se faire "manger" par les RegExp) */
    {Identificateur}            {return new Token(Sym.TOKEN_IDENTIFICATOR, yytext(), yyline, yycolumn);}
    /* {Flottant}                  {System.out.printf("FLOTTANT DÉTECTÉ: %s\n", yytext());}
    {Entier}                    {System.out.printf("ENTIER DÉTECTÉ: %s\n", yytext());}
    {CommentaireMultiligne}     {System.out.printf("COMMENTAIRE MULTIPLE: %s\n", yytext());}
    {CommentaireSimple}         {System.out.printf("COMMENTAIRE SIMPLE: %s\n", yytext());} */
    "/*"            {yybegin(COMMENT);}
    "/**"           {yybegin(COMMENT_DOC);}
    {CommentaireSimple}     {}

    /* Operators */

    "++"	        {return new Token(Sym.OPERATOR_PLUS_PLUS, null, yyline, yycolumn);}
    "--"            {return new Token(Sym.OPERATOR_MINUS_MINUS, null, yyline, yycolumn);}
    "&"             {return new Token(Sym.OPERATOR_AND, null, yyline, yycolumn);}
    "*"	            {return new Token(Sym.OPERATOR_STAR, null, yyline, yycolumn);}
    "-"             {return new Token(Sym.OPERATOR_MINUS, null, yyline, yycolumn);}
    "~"	            {return new Token(Sym.OPERATOR_TILD, null, yyline, yycolumn);}
    "+"	            {return new Token(Sym.OPERATOR_PLUS, null, yyline, yycolumn);}
    "!"             {return new Token(Sym.OPERATOR_EXCLAMATION, null, yyline, yycolumn);}
    "/"             {return new Token(Sym.OPERATOR_SLASH, null, yyline, yycolumn);}
    "%"             {return new Token(Sym.OPERATOR_MODULO, null, yyline, yycolumn);}
    "<<"            {return new Token(Sym.OPERATOR_LOWER_LOWER, null, yyline, yycolumn);}
    ">>"            {return new Token(Sym.OPERATOR_GREATER_GREATER, null, yyline, yycolumn);}
    "<"             {return new Token(Sym.OPERATOR_LOWER, null, yyline, yycolumn);}
    ">"             {return new Token(Sym.OPERATOR_GREATER, null, yyline, yycolumn);}
    "<="            {return new Token(Sym.OPERATOR_LOWER_EQUAL, null, yyline, yycolumn);}
    ">="            {return new Token(Sym.OPERATOR_GREATER_EQUAL, null, yyline, yycolumn);}
    "=="            {return new Token(Sym.OPERATOR_EQUAL_EQUAL, null, yyline, yycolumn);}
    "!="            {return new Token(Sym.OPERATOR_DIFFERENT, null, yyline, yycolumn);}
    "^"             {return new Token(Sym.OPERATOR_POWER, null, yyline, yycolumn);}
    "|"             {return new Token(Sym.OPERATOR_OR, null, yyline, yycolumn);}
    "&&"            {return new Token(Sym.OPERATOR_AND_AND, null, yyline, yycolumn);}
    "||"            {return new Token(Sym.OPERATOR_OR_OR, null, yyline, yycolumn);}
    "="             {return new Token(Sym.OPERATOR_EQUAL, null, yyline, yycolumn);}
    "*="            {return new Token(Sym.OPERATOR_STAR_EQUAL, null, yyline, yycolumn);}
    "%="            {return new Token(Sym.OPERATOR_MODULO_EQUAL, null, yyline, yycolumn);}
    "/="            {return new Token(Sym.OPERATOR_SLASH_EQUAL, null, yyline, yycolumn);}
    "-="            {return new Token(Sym.OPERATOR_MINUS_EQUAL, null, yyline, yycolumn);}
    "+="            {return new Token(Sym.OPERATOR_PLUS_EQUAL, null, yyline, yycolumn);}
    "<<="           {return new Token(Sym.OPERATOR_LOWER_LOWER_EQUAL, null, yyline, yycolumn);}
    ">>="           {return new Token(Sym.OPERATOR_GREATER_GREATER_EQUAL, null, yyline, yycolumn);}
    "&="            {return new Token(Sym.OPERATOR_AND_EQUAL, null, yyline, yycolumn);}
    "^="            {return new Token(Sym.OPERATOR_POWER_EQUAL, null, yyline, yycolumn);}
    "|="            {return new Token(Sym.OPERATOR_OR_EQUAL, null, yyline, yycolumn);}

    {Separateur}    {return new Token(Sym.TOKEN_SEPARATOR, yytext(), yyline, yycolumn);}
    {String}        {return new Token(Sym.TOKEN_STRING, yytext(), yyline, yycolumn);}
}

/* Separateur      {System.out.printf("SEPARATEUR: %s\n", yytext());} */

[^]|\n {}
