package com.pascal.compiler.sr;
import java.io.*;

import com.libe295.compiler.sr.ptree.TreeNode;

import java_cup.runtime.*;

/****
 *
 * Test program for CSC 330 Assignment 3.  See comment for EJayParserTest for
 * further information.
 *
 */
public class PascalParserTest {

    /**
     * See the class comment for documentation.
     */
    public static void main(String[] args) {
        TreeNode t;
        try {
            PascalParser parser = new PascalParser(
                new PascalLexer(new FileReader(args[0])));
            parser.initSymbolTable(parser.PROC_SYMTAB_SIZE);
            t = (TreeNode) parser.parse().value;
            System.out.println(t);
            System.out.println(parser.getSymbolTable());
        }
        catch (Exception e) {
            System.out.println("Exception ");
	    e.printStackTrace();
        }
    }
}
