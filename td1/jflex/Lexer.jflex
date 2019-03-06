import java.io.*;

%%
%{
    /* Code java en début de la classe */
    /* Par défaut, en JAVA, tout attribut de classe est initialisé à 0 */
    int nbMotsCles = 0;
    int nbOperateurs = 0;
    int nbIdentificateurs = 0;
%}

%public
%class Lexer
%standalone
%8bit
%line
%column
%char

Identificateur = [a-zA-Z_][a-zA-Z0-9_]*
Chiffre = [0-9]
Entier = {Chiffre}+
Flottant = {Entier}?("."{Entier})?([eE][+-]?{Entier})
Separateur = "," | ";" | ":" | "(" | ")" | "[" | "]" | "." | "{" | "}" /* jamais matché (?)*/
String = \" ~\"
CommentaireMultiligne = "/*" .* ~"*/"
CommentaireSimple = "//"(.*)
/* Commentaire = \"([^\"] | \\\") */

%eof{
      System.out.printf("Nombre de lignes et colonnes et caractères: (%d, %d, %d)\n", yyline, yycolumn, yychar);
      System.out.printf("Nombre d'identificateurs: %d\n", nbIdentificateurs);
      System.out.printf("Nombre de mots clés: %d\n", nbMotsCles);
      System.out.printf("Nombre d'opérateurs: %d\n", nbOperateurs);
%eof}

%%

/* Keywords */
bool        {++nbMotsCles;System.out.printf("BOOL: %s\n", yytext());}
break       {++nbMotsCles;System.out.printf("BREAK: %s\n", yytext());}
case        {++nbMotsCles;System.out.printf("CASE: %s\n", yytext());}
catch       {++nbMotsCles;System.out.printf("CATCH: %s\n", yytext());}

char        {++nbMotsCles;System.out.printf("CHAR: %s\n", yytext());}
class       {++nbMotsCles;System.out.printf("CLASS: %s\n", yytext());}
const       {++nbMotsCles;System.out.printf("CONST: %s\n", yytext());}
continue    {++nbMotsCles;System.out.printf("CONTINUE: %s\n", yytext());}
default     {++nbMotsCles;System.out.printf("DEFAULT: %s\n", yytext());}

delete      {++nbMotsCles;System.out.printf("DELETE: %s\n", yytext());}
do          {++nbMotsCles;System.out.printf("DO: %s\n", yytext());}
double      {++nbMotsCles;System.out.printf("DOUBLE: %s\n", yytext());}
else        {++nbMotsCles;System.out.printf("ELSE: %s\n", yytext());}
enum        {++nbMotsCles;System.out.printf("ENUM: %s\n", yytext());}

false       {++nbMotsCles;System.out.printf("FALSE: %s\n", yytext());}
float       {++nbMotsCles;System.out.printf("FLOAT: %s\n", yytext());}
for         {++nbMotsCles;System.out.printf("FOR: %s\n", yytext());}
friend      {++nbMotsCles;System.out.printf("FRIEND: %s\n", yytext());}
goto        {++nbMotsCles;System.out.printf("GOTO: %s\n", yytext());}
if          {++nbMotsCles;System.out.printf("IF: %s\n", yytext());}
inline      {++nbMotsCles;System.out.printf("INLINE: %s\n", yytext());}
int         {++nbMotsCles;System.out.printf("INT: %s\n", yytext());}
long        {++nbMotsCles;System.out.printf("LONG: %s\n", yytext());}

namespace   {++nbMotsCles;System.out.printf("NAMESPACE: %s\n", yytext());}
new         {++nbMotsCles;System.out.printf("NEW: %s\n", yytext());}
operator    {++nbMotsCles;System.out.printf("OPERATOR: %s\n", yytext());}
private     {++nbMotsCles;System.out.printf("INLINE: %s\n", yytext());}

protected   {++nbMotsCles;System.out.printf("PROTECTED: %s\n", yytext());}
public      {++nbMotsCles;System.out.printf("PUBLIC: %s\n", yytext());}
register    {++nbMotsCles;System.out.printf("REGISTER: %s\n", yytext());}
return      {++nbMotsCles;System.out.printf("RETURN: %s\n", yytext());}
short       {++nbMotsCles;System.out.printf("SHORT: %s\n", yytext());}

signed      {++nbMotsCles;System.out.printf("SIGNED: %s\n", yytext());}
sizeof      {++nbMotsCles;System.out.printf("SIZEOF: %s\n", yytext());}
static      {++nbMotsCles;System.out.printf("STATIC: %s\n", yytext());}
struct      {++nbMotsCles;System.out.printf("STRUCT: %s\n", yytext());}
switch      {++nbMotsCles;System.out.printf("SWITCH: %s\n", yytext());}
template    {++nbMotsCles;System.out.printf("TEMPLATE: %s\n", yytext());}

this        {++nbMotsCles;System.out.printf("THIS: %s\n", yytext());}
throw       {++nbMotsCles;System.out.printf("THROW: %s\n", yytext());}
true        {++nbMotsCles;System.out.printf("TRUE: %s\n", yytext());}
try         {++nbMotsCles;System.out.printf("TRY: %s\n", yytext());}
typedef     {++nbMotsCles;System.out.printf("TYPEDEF: %s\n", yytext());}
typeid      {++nbMotsCles;System.out.printf("TYPEID: %s\n", yytext());}
typename    {++nbMotsCles;System.out.printf("TYPENAME: %s\n", yytext());}
union       {++nbMotsCles;System.out.printf("UNION: %s\n", yytext());}
unsigned    {++nbMotsCles;System.out.printf("UNSIGNED: %s\n", yytext());}

using       {++nbMotsCles;System.out.printf("USING: %s\n", yytext());}
virtual     {++nbMotsCles;System.out.printf("VIRTUAL: %s\n", yytext());}
void        {++nbMotsCles;System.out.printf("VOID: %s\n", yytext());}
while       {++nbMotsCles;System.out.printf("WHILE: %s\n", yytext());}


/* IDENTIFICATEURS (toujours après les mots-clés, sinon ils vont se faire "manger" par les RegExp) */
{Identificateur}  {System.out.printf("IDENTIFICATEUR DÉTECTÉ: %s\n", yytext());nbIdentificateurs++;}
{Flottant}        {System.out.printf("FLOTTANT DÉTECTÉ: %s\n", yytext());}
{Entier}          {System.out.printf("ENTIER DÉTECTÉ: %s\n", yytext());}
{CommentaireMultiligne}     {System.out.printf("COMMENTAIRE MULTIPLE: %s\n", yytext());}
{CommentaireSimple}         {System.out.printf("COMMENTAIRE SIMPLE: %s\n", yytext());}

/* if	{System.out.printf("KEYWORD:%s\n", yytext());} */
/* else	{System.out.printf("KEYWORD:%s\n", yytext());} */

/* Operators */

"++"	          {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"--"            {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"&"             {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"*"	            {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"+"	            {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"-"             {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"~"	            {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"!"             {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"/"             {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"%"             {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"<<"            {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
">>"            {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"<"             {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
">"             {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"<="            {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
">="            {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"=="            {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"!="            {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"^"             {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"|"             {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"&&"            {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"||"            {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"="             {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"*="            {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"/="            {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"%="            {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"+="            {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"-="            {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"<<="           {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
">>="           {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"&="            {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"^="            {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}
"|="            {++nbOperateurs;System.out.printf("OPERATOR: %s\n", yytext());}

{Separateur}      {System.out.printf("SEPARATEUR: %s\n", yytext());}

/* ","             {System.out.printf("OPERATOR: %s\n", yytext());}
";"             {System.out.printf("OPERATOR: %s\n", yytext());}
":"             {System.out.printf("OPERATOR: %s\n", yytext());}
"("             {System.out.printf("OPERATOR: %s\n", yytext());}
")"             {System.out.printf("OPERATOR: %s\n", yytext());}
"["             {System.out.printf("OPERATOR: %s\n", yytext());}
"]"             {System.out.printf("OPERATOR: %s\n", yytext());}
"."             {System.out.printf("OPERATOR: %s\n", yytext());}
"{"             {System.out.printf("OPERATOR: %s\n", yytext());}
"}"             {System.out.printf("OPERATOR: %s\n", yytext());} */

{String}        {System.out.printf("STRING: %s\n", yytext());}

/* Separateur      {System.out.printf("SEPARATEUR: %s\n", yytext());} */

[^]|\n {}
