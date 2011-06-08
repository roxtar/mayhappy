MAIN_CLASS=$(MAIN_SRC:.java=.class)

MAIN_SRC=MayHappyMain.java
X10PARSER_SRC = MiniX10Parser.java
SYNTAX_SRC=$(wildcard syntaxtree/*.java)
SYNTAX_CLASS=$(SYNTAX_SRC:.java=.class)

VISITOR_SRC=$(wildcard visitor/*.java)
VISITOR_CLASS=$(VISITOR_CLASS:.java=.class)

SET_SRC=$(wildcard set/*.java)
SET_CLASS=$(SET_CRC:.java=.class)
CLASSPATH=/usr/share/java/junit4.jar:.

TEST_SRC=$(wildcard *Test.java)
TEST_CLASS=$(TEST_SRC:.java=.class)
TEST_OUT=$(TEST_SRC:.java= )


all: $(MAIN_CLASS)

test: $(TEST_CLASS)
	for i in $(TEST_OUT); do junit -text $$i; done

$(MAIN_CLASS): $(MAIN_SRC) $(SYNTAX_SRC) $(VISITOR_SRC) $(SET_SRC)

$(TEST_CLASS): $(TEST_SRC) $(VISITOR_SRC) $(SYNTAX_SRC) $(SET_SRC)

$(MAIN_SRC): $(X10PARSER_SRC)


$(X10PARSER_SRC): jtb.out.jj
	javacc $<


%.class : %.java
	javac -classpath $(CLASSPATH) $<

jtb.out.jj : miniX10.jj
	jtb $<

clean: 
	rm -rf *.class syntaxtree/*.class visitor/*.class 



