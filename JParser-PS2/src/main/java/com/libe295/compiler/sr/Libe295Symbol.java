package com.libe295.compiler.sr;


public class Libe295Symbol extends java_cup.runtime.Symbol {
  private int line;
  private int column;

  public Libe295Symbol(int type, int line, int column) {
    this(type, line, column, -1, -1, null);
  }

  public Libe295Symbol(int type, int line, int column, Object value) {
    this(type, line, column, -1, -1, value);
  }

  public Libe295Symbol(int type, int line, int column, int left, int right, Object value) {
    super(type, left, right, value);
    this.line = line;
    this.column = column;
  }

  public int getLine() {
    return line;
  }

  public int getColumn() {
    return column;
  }

  public String toString() {   
    return "line "+line+", column "+column+", sym: "+sym+(value == null ? "" : (", value: '"+value+"'"));
  }
}
