package com.libe295.compiler.sr;

/**
 * Utility Class to return error messages from Lexer
 * 
 */

public class Utility {

	private static final String errorMsg[] = {
			"Lexically incorrect placement of character in source language",
			"Number Constant too big for int, long or unsigned long. Assigning MAX_ULONG",
			"Invalid Escape Sequence as part of String Constant",
			"Invalid Escape Sequence as part of Character Constant",
			"Unterminated character literal at end of line",
			"Unterminated string at end of line" };

	public static final int E_UNMATCHED = 0;
	public static final int E_CONSTTOOBIG = 1;
	public static final int E_INVALIDESCSTR = 2;
	public static final int E_INVALIDESCCHAR = 3;
	public static final int E_UNTERMCHAR = 4;
	public static final int E_UNTERMSTR = 5;

	public static void error(int code, int line, int col, String lextext) {

		StringBuffer strPrint = new StringBuffer();
		strPrint.append(printWrnBlk() + "\n");
		strPrint.append("Error at Line: " + line + ", Col: " + col + " - "
				+ errorMsg[code] + "\n");
		strPrint.append(printWrnBlk());
//		if (Lexer.outputFile != null)
//			Lexer.outputFile.write(strPrint.toString() + "\n");
		System.out.println(strPrint);
	}

	public static String getError(int code) {
		return (errorMsg[code]);
	}

	public static String printWrnBlk() {
		return ("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

	}

	public static String printHdrBlk() {
		return ("*******************************************************************************");

	}

}
