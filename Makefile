MAIN_CLASS=$(MAIN_SRC:.java=.class)

MAIN_SRC=MayHappyMain.java
X10PARSER_SRC = MiniX10Parser.java
SYNTAX_SRC=$(wildcard syntaxtree/*.java)
VISITOR_SRC=$(wildcard visitor/*.java)
SET_SRC=$(wildcard set/*.java)
CLASSPATH=/usr/share/java/junit4.jar:.

SET_TEST_CLASS=StringSetTest.class StringPairSetTest.class
SET_TEST=StringSetTest StringPairSetTest

all: $(MAIN_CLASS)

test: $(SET_TEST_CLASS)
	for i in $(SET_TEST); do junit -text $$i; done


$(MAIN_CLASS): $(MAIN_SRC) $(SYNTAX_SRC) $(VISITOR_SRC) $(SET_SRC)

$(SET_TEST_CLASS): $(SET_SRC)

$(MAIN_SRC): $(X10PARSER_SRC)

$(X10PARSER_SRC): jtb.out.jj
	javacc $<


%.class : %.java
	javac -classpath $(CLASSPATH) $<

jtb.out.jj : miniX10.jj
	jtb $<

clean: 
	rm -rf *.class jtb.out.jj



