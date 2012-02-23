/* 
Author: Sreeram Ramalingam
Description: This is the main flex file with the Lexer specification used to generate Lexer.java )
*/

package com.libe295.compiler.sr;


import com.libe295.compiler.sr.enums.*;
import java_cup.runtime.*;
import java_cup.*;

%%
%public
 
%class Scanner
%implements sym

%line
%column
%cup

%{
  StringBuffer stringVal = new StringBuffer(); //used to store the value of a String Constant
  StringBuffer stringStr = new StringBuffer(); //used to store the actual text of a Character/String Constant

 private Symbol symbol(int type) {
    return new Libe295Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Libe295Symbol(type, yyline+1, yycolumn+1, value);
  }

%}  



/* main character classes */
LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator} | [ \t\f]

/* identifiers */
NonDigit = [:letter:]|_
Digit  = [[:digit:]]
Identifier = {NonDigit}({NonDigit}|{Digit})*

/* integer literals */
Number = {Digit}+

/* string and character literals */
StringCharacter = [^\r\n\"\\]
SingleCharacter = [^\r\n\'\\]
OctDigit = [0-7]

/* comments */
Comment = {TraditionalComment} | {DocumentationComment}
TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
DocumentationComment = "/*" "*"+ [^/*] ~"*/"

%state STRINGCONST, CHARCONST

%% 
	

<YYINITIAL> {

  /* reserved words */
  "break"                       { return symbol(BREAK); }
  "char"                        { return symbol(CHAR); }
  "continue"                    { return symbol(CONTINUE); }
  "do"                          { return symbol(DO); }
  "else"                        { return symbol(ELSE); }
  "for"                          { return symbol(FOR); }
  "int"                          { return symbol(INT); }
  "long"                         { return symbol(LONG); }
  "goto"                        { return symbol(GOTO); }
  "if"                          { return symbol(IF); }
  "short"                       { return symbol(SHORT); }
  "return"                      { return symbol(RETURN); }
  "void"                       	 { return symbol(VOID); }
  "signed"                       { return symbol(SIGNED); }
  "while"                        { return symbol(WHILE); }
  "unsigned"                     { return symbol(UNSIGNED); }
  
    /* separators */
  "("                            { return symbol(LPAREN); }
  ")"                           { return symbol(RPAREN); }
  "{"                            { return symbol(LBRACE); }
  "}"                      { return symbol(RBRACE); }
  "["                            { return symbol(LBRACK); }
  "]"                            { return symbol(RBRACK); }
  ";"                            { return symbol(SEMICOLON); }
  ":"                           { return symbol(COLON); }
  ","                           { return symbol(COMMA); }
  
   /* simple operators */
  "!"                            { return symbol(NOT); }
  "%"                            { return symbol(MOD); }
  "^"                           { return symbol(XOR); }
  "&"                            { return symbol(AND); }
  "*"                            { return symbol(MULT); }
  "-"                           { return symbol(MINUS); }
  "+"                           { return symbol(PLUS); }
  "="                           { return symbol(EQ); }
  "~"                            { return symbol(COMP); }
  "|"                             { return symbol(OR); }
  "<"                            { return symbol(LT); }
  ">"                           { return symbol(GT); }
  "/"                           { return symbol(DIV); }
  "?"                          { return symbol(QUESTION); }

/* compound assignment operators */
  "+="                           return symbol(PLUSEQ); }
  "-="                          { return symbol(MINUSEQ); }
  "*="                          { return symbol(MULTEQ); }
  "/="                           { return symbol(DIVEQ); }
  "&="                           { return symbol(ANDEQ); }
  "|="                          { return symbol(OREQ); }
  "^="                           { return symbol(XOREQ); }
  "%="                          { return symbol(MODEQ); }
  "<<="                         { return symbol(LSHIFTEQ); }
  ">>="                         { return symbol(RSHIFTEQ); }	

/* other compound operators: */
  "++"                           { return symbol(PLUSPLUS); }
  "--"                           { return symbol(MINUSMINUS); }
  "<<"                           { return symbol(LSHIFT); }
  ">>"                           { return symbol(RSHIFT); }
  "<="                           { return symbol(LTEQ); }
  ">="                           { return symbol(GTEQ); }
  "=="                           { return symbol(EQEQ); }
  "!="                           { return symbol(NOTEQ); }
  "&&"                          { return symbol(ANDAND); }
  "||"                          { return symbol(OROR); }
  
  
   /* String Constant */
  \"                             { yybegin(STRINGCONST); stringVal.setLength(0); stringStr.setLength(0); stringStr.append(yytext()); }

  /* Character Constant */
  \'                             { yybegin(CHARCONST); stringStr.setLength(0); stringStr.append(yytext()); }
  
  {Number}                 { return symbol(INTEGER_LITERAL, new Integer(yytext())); }
  
  /* comments */
  {Comment}                      { /* ignore */ }
 /* whitespace */
  {WhiteSpace}                   { /* ignore */ }
 
 /* identifiers */ 
  {Identifier}                    { return symbol(IDENTIFIER, yytext()); }  
  
   
}

<STRINGCONST> {
  \"                             { yybegin(YYINITIAL); stringStr.append( yytext() ); return symbol(STRING_LITERAL, stringVal.toString());}
  "\\"{LineTerminator} 					{   stringStr.append( yytext());   }
  {StringCharacter}+             { stringVal.append( yytext() ); stringStr.append( yytext() ); }
  
  /* escape sequences */
  "\\b"                          { stringVal.append( '\b' ); stringStr.append( yytext() ); }
  "\\t"                          { stringVal.append( '\t' ); stringStr.append( yytext() ); }
  "\\n"                          { stringVal.append( '\n' ); stringStr.append( yytext() ); }
  "\\f"                          { stringVal.append( '\f' ); stringStr.append( yytext() ); }
  "\\r"                          { stringVal.append( '\r' ); stringStr.append( yytext() ); }
  "\\v"                          { stringVal.append( new Character((char) 11) ); stringStr.append( yytext() ); }
  "\\a"                          { stringVal.append( new Character((char) 7) ); stringStr.append( yytext() ); }
  "\\?"                          { stringVal.append( new Character('?') ); stringStr.append( yytext() ); }
  "\\\""                         { stringVal.append( '\"' ); stringStr.append( yytext()); }
  "\\'"                          { stringVal.append( '\'' ); stringStr.append(yytext() ); }
  "\\\\"                         { stringVal.append( '\\' ); stringStr.append( yytext() ); }
  \\{OctDigit}?{OctDigit}?{OctDigit}  { char val = (char) Integer.parseInt(yytext().substring(1),8);
                        				   stringVal.append( val ); stringStr.append( yytext() ); }
  
  /* error cases */
  \\.                            { stringVal.append( yytext().charAt(1) ); stringStr.append( yytext() );}
  {LineTerminator}               { yybegin(YYINITIAL); throw new RuntimeException("Unterminated string at end of line");}
   
}

<CHARCONST> {
  \'            				{ yybegin(YYINITIAL); stringStr.append(yytext()); return (new CharConstant(stringStr.toString(),yyline,yycolumn, new Character((char)Character.UNASSIGNED)));  }
  {SingleCharacter}\'            { yybegin(YYINITIAL); stringStr.append(yytext()); return symbol(CHARACTER_LITERAL, new Character(yytext().charAt(0)));}
  
  /* escape sequences */
  "\\b"\'                        { yybegin(YYINITIAL); stringStr.append(yytext()); return symbol(CHARACTER_LITERAL, new Character('\b'));  }
  "\\t"\'                        { yybegin(YYINITIAL); stringStr.append(yytext()); return symbol(CHARACTER_LITERAL, new Character('\t'));  }
  "\\n"\'                        { yybegin(YYINITIAL); stringStr.append(yytext()); return symbol(CHARACTER_LITERAL, new Character('\n'));  }
  "\\f"\'                        { yybegin(YYINITIAL); stringStr.append(yytext()); return symbol(CHARACTER_LITERAL, new Character('\f')); }
  "\\r"\'                        { yybegin(YYINITIAL); stringStr.append(yytext());return symbol(CHARACTER_LITERAL, new Character('\r'));  }
  "\\v"\'                        { yybegin(YYINITIAL); stringStr.append(yytext()); return symbol(CHARACTER_LITERAL, new Character((char)11));  }
  "\\a"\'                        { yybegin(YYINITIAL); stringStr.append(yytext()); return symbol(CHARACTER_LITERAL, new Character((char)7))  }
  "\\?"\'                        { yybegin(YYINITIAL); stringStr.append(yytext()); return symbol(CHARACTER_LITERAL, new Character('\r'));  }
  "\\\""\'                       { yybegin(YYINITIAL); stringStr.append(yytext()); return symbol(CHARACTER_LITERAL, new Character('\"')); }
  "\\'"\'                        { yybegin(YYINITIAL); stringStr.append(yytext()); return symbol(CHARACTER_LITERAL, new Character('\''));  }
  "\\\\"\'                       { yybegin(YYINITIAL); stringStr.append(yytext());  return symbol(CHARACTER_LITERAL, new Character('\\'));  }
  \\{OctDigit}?{OctDigit}?{OctDigit}\' { yybegin(YYINITIAL); 
			                              int val = Integer.parseInt(yytext().substring(1,yylength()-1),8);
			                              stringStr.append(yytext());
			                            return symbol(CHARACTER_LITERAL, new Character((char)val));; }
  
  /* error cases */
  \\.\'                            { yybegin(YYINITIAL); stringStr.append(yytext()); return symbol(CHARACTER_LITERAL, new Character(yytext().charAt(1)); }
  {LineTerminator}               { yybegin(YYINITIAL); throw new RuntimeException("Unterminated character literal at end of line"); }
}

. 	{
		throw new RuntimeException("Illegal character \""+yytext()+
                                                              "\" at line "+yyline+", column "+yycolumn);
	}
	
<<EOF>>                          { return symbol(EOF); } 
	

