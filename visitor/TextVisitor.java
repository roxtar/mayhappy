package visitor;
import syntaxtree.*;
import java.util.*;
import java.lang.StringBuilder;
public class TextVisitor extends DepthFirstVisitor {
    public StringBuilder _text;

    public String getText() {
	Text.toString().trim();
    }
    public TextVisitor() {
	Text = new StringBuilder();
    }

    public void visit(NodeToken n) { 
	_text.append(n.toString() + " ");
    }
}