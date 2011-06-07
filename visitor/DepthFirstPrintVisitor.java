package visitor;
import syntaxtree.*;
import java.util.*;
import java.lang.StringBuilder;
public class TextVisitor extends DepthFirstVisitor {
    public StringBuilder Text;
    public TextVisitor() {
	Text = new StringBuilder();
    }

    public void visit(NodeToken n) { 
	Text.append(n.toString() + " ");
    }
}