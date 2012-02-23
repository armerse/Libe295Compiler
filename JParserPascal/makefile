

JFLEX      = ./jflex-1.4.3/bin/jflex
JAVA       = java
JAVAC      = javac
JAVACFLAGS = 

# --------------------------------------------------

all: test

test.txt: compile
	$(JAVA) com.cscie119.compiler.sr.lexer.Lexer src/test/resources/test.txt > lexer-test.txt


compile: scanner parser unicode
	$(JAVAC) $(JAVACFLAGS) JavaParser.java TestLexer.java

parser: parser.java 

parser.java: java12.cup
	$(CUP) java12.cup

scanner: Scanner.java

Scanner.java: java.flex
	$(JFLEX) java.flex

unicode: UnicodeEscapes.java

UnicodeEscapes.java: unicode.flex
	$(JFLEX) unicode.flex

clean:
	rm -f *.class
	rm -f *~
	rm -f Scanner.java
	rm -f parser.java
	rm -f sym.java
	rm -f UnicodeEscapes.java
	rm -f lexer-output.txt
