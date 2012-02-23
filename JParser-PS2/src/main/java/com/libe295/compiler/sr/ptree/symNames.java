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
        "BOOLEAN",
        "ELSE",
        "IF",
        "INT",
        "VOID",
        "WHILE",
        "TRUE",
        "FALSE",
        "FLOAT",
        "STRING",
        "STRUCT",
        "RETURN",
        "PRINT",
        "REF",
        "LEFT_PAREN",
        "RT_PAREN",
        "LEFT_BRACE",
        "RT_BRACE",
        "SEMI",
        "COMMA",
        "LEFT_BRKT",
        "RT_BRKT",
        "EQ",
        "PLUS",
        "MINUS",
        "TIMES",
        "DIVIDE",
        "LESS",
        "LESS_EQ",
        "GTR",
        "GTR_EQ",
        "EQ_EQ",
        "NOT_EQ",
        "AND",
        "OR",
        "NOT",
        "DOT",
        "UNY_PLUS",
        "UNY_MINUS",
        "IDENT",
        "INTEGER",
        "FLOATING_PT",
        "STRING_LIT",
    };
}
