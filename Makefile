
MAIN_SRC=MayHappyMain.java
MAIN_CLASS=$(MAIN_SRC:.java=.class)
X10PARSER_SRC = MiniX10Parser.java

all: $(MAIN_CLASS)

$(MAIN_CLASS): $(MAIN_SRC)
	javac $<

$(MAIN_SRC): $(X10PARSER_SRC)

$(X10PARSER_SRC): jtb.out.jj
	javacc $<


jtb.out.jj : miniX10.jj
	jtb $<



