package com.libe295.compiler.sr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import com.libe295.compiler.sr.enums.EnumBaseTokenTypes;

/**
 * 
 * @author Sreeram Ramalingam This is the entry point class with the main
 *         function The main function checks if there are any command line
 *         arguments. Each command line argument is considered to be an input
 *         file. The main function creates a BufferedReader object and calls the
 *         function scanStream(). The scanStream() function invokes the yylex()
 *         function from the class LexScanner that is generated by the lexer
 * 
 */
public class Parser {
	/**
	 * @param args
	 */
	static PrintWriter outputFile;
	static HashMap<EnumBaseTokenTypes, Integer> summaryMap = new HashMap<EnumBaseTokenTypes, Integer>();

	public static void main(String argv[]) {

		BufferedReader in;
		if (argv.length == 0) { // Command line mode
			in = new BufferedReader(new InputStreamReader(System.in));
//			scanStream(in);
			parseStream(in);
		} else {
			System.out.println("Processing file : " + argv[0] + "");
			if (argv.length > 1) {
				try {
					outputFile = new PrintWriter(new BufferedWriter(
							new FileWriter(argv[1])));
				} catch (java.io.IOException e) {
					System.out
							.println("Output file cannot be opened. Could be a directory : \""
									+ argv[1] + "\"");
				}
			}
			try {
				in = new BufferedReader(new FileReader(argv[0]));
//				scanStream(in);
				parseStream(in);
			} catch (java.io.FileNotFoundException e) {
				System.out.println("File not found : \"" + argv[0] + "\"");
			}
			printStats();
			if (outputFile != null)
				outputFile.flush();
		}

	}

	private static void printStats() {
		StringBuffer printStr = new StringBuffer();

		printStr.append("*******LEXER TOKENS SUMMARY*******\n");

		for (EnumBaseTokenTypes tts : summaryMap.keySet()) {

			printStr.append(tts + "   \t-\t" + summaryMap.get(tts) + "\n");

		}
		printStr.append("COMMENT & WSPACE are only 'counted'\n");
		printStr.append("**********************************");
		System.out.println(printStr);
		if (outputFile != null)
			outputFile.write(printStr.toString() + "\n");
	}

	/**
	 * This function takes in a Reader stream and calls yylex() function on a
	 * LexScanner object which is the class generated by JFlex.
	 * 
	 * @param in
	 */
	/*public static void scanStream(BufferedReader in) {
		LexScanner scanner = null;
		try {
			scanner = new LexScanner(in);
			BaseToken bt;
			while ((bt = scanner.yylex()).tType != EnumBaseTokenTypes.EOF) {
				switch (bt.tType) {
				case CHARCONST:
				case STRCONST:
				case IDENT:
				case OPERTR:
				case NUMCONST:
				case RWORD:
				case SEPARTR:
					System.out.println(bt.toString());
					if (outputFile != null)
						outputFile.write(bt.toString() + "\n");
					break;
				}
				updateStats(bt);
			}

		} catch (Exception e) {
			System.out.println("Unexpected exception:");
			e.printStackTrace();
		}
	}*/
	
	public static void parseStream(BufferedReader in) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(in);
			BaseToken bt;
			while ((bt = scanner.yylex()).tType != EnumBaseTokenTypes.EOF) {
				switch (bt.tType) {
				case CHARCONST:
				case STRCONST:
				case IDENT:
				case OPERTR:
				case NUMCONST:
				case RWORD:
				case SEPARTR:
					System.out.println(bt.toString());
					if (outputFile != null)
						outputFile.write(bt.toString() + "\n");
					break;
				}
				updateStats(bt);
			}

		} catch (Exception e) {
			System.out.println("Unexpected exception:");
			e.printStackTrace();
		}
	}

	private static void updateStats(BaseToken bt) {
		if (summaryMap.containsKey(bt.tType))
			summaryMap.put(bt.tType, summaryMap.get(bt.tType) + 1);
		else {
			summaryMap.put(bt.tType, new Integer(1));
		}
	}

}
