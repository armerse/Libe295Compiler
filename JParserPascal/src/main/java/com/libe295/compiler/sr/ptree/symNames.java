package com.libe295.compiler.sr.ptree;
/****
 *
 * This class contains a public array that maps an int token id into its string
 * representation.  Specifically, the string name at array position i
 * corresponds to the symbol id value of i.
 *                                                                          <p>
 * This file must be changed for different languages with different tokens.
 *                                                                          <p>
 *
 * -------------------- THIS IS THE EJAY VERSION. ------------------------
 *
 */
public class symNames {
    /** Int-to-string token mapping array */
    public static String[] map = {
    	"EOF",
    	"error",
    	"AND",
    	"ARRAY",
    	"BEGIN",
    	"ELSE",
    	"END",
    	"IF",
    	"NOT",
    	"OF",
    	"OR",
    	"PROGRAM",
    	"PROCEDURE",
    	"THEN",
    	"TYPE",
    	"VAR",
    	"TIMES",
    	"PLUS",
    	"MINUS",
    	"DIVIDE",
    	"UNY_PLUS",
    	"UNY_MINUS",
    	"SEMI",
    	"COMMA",
    	"LEFT_PAREN",
    	"RT_PAREN",
    	"LEFT_BRKT",
    	"RT_BRKT",
    	"EQ",
    	"GTR",
    	"LESS",
    	"LESS_EQ",
    	"GTR_EQ",
    	"NOT_EQ",
    	"COLON",
    	"ASSMNT",
    	"DOT",
    	"IDENT",
    	"INT",
    	"REAL",
    	"CHAR",
    };
}
