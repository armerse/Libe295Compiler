package com.libe295.compiler.sr;

import java_cup.runtime.Symbol;

import com.libe295.compiler.sr.enums.EnumBaseTokenTypes;

/**
 * 
 * @author Sreeram This class is used as the base class for all tokens returned
 *         by the lexer
 * 
 */
class BaseToken extends Symbol {

	public String strText;
	public int lineNum;
	public int colNum;
	EnumBaseTokenTypes tType;
	
	  public BaseToken(int type, int line, int column) {
		    this(type, line, column, -1, -1, null);
		  }

		  public BaseToken(int type, int line, int column, Object value) {
		    this(type, line, column, -1, -1, value);
		  }

		  public BaseToken(int type, int line, int column, int left, int right, Object value) {
		    super(type, left, right, value);
		    this.lineNum = line;
		    this.colNum = column;
		  }
	
	
	/**
	 * This constructor is used only when a whitespace token is found
	 * 
	 * @param tt
	 *            (type of base token)
	 * @param lineNum
	 * @param col
	 */
	/*BaseToken(EnumBaseTokenTypes tt, int lineNum, int col) {
		this.tType = tt;
		this.lineNum = lineNum;
		this.colNum = col;

	}*/

	/**
	 * This constructor is used as the super constructor by all derived tokens
	 * 
	 * @param strtext
	 * @param lineNum
	 * @param col
	 */

/*	BaseToken(String strtext, int lineNum, int col) {
		this.strText = strtext;
		this.lineNum = lineNum;
		this.colNum = col;
		this.tType = EnumBaseTokenTypes.DERIVED;
	}
*/
	/**
	 * Should be never called in the main code. Only used for testing purposes.
	 */
	public String toString() {
		if (!"".equals(strText)) {
			return "Text   : " + strText + "\nline  : " + lineNum
					+ "\ncolumn  : " + colNum;
		}
		return "";
	}
}
