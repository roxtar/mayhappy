MAIN_CLASS=$(MAIN_SRC:.java=.class)

MAIN_SRC=MayHappyMain.java
X10PARSER_SRC = MiniX10Parser.java
SYNTAX_SRC=$(wildcard syntaxtree/*.java)
VISITOR_SRC=$(wildcard visitor/*.java)


all: $(MAIN_CLASS)

$(MAIN_CLASS): $(MAIN_SRC) $(SYNTAX_SRC) $(VISITOR_SRC)
	javac $<

$(MAIN_SRC): $(X10PARSER_SRC)

$(X10PARSER_SRC): jtb.out.jj
	javacc $<


jtb.out.jj : miniX10.jj
	jtb $<

clean: 
	rm -rf *.class jtb.out.jj



