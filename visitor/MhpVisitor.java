package visitor;
import syntaxtree.*;
import java.util.*;

public class MhpVisitor extends DepthFirstVisitor {
       public void visit(Assignment n) { 
	   TextVisitor t = new TextVisitor();
	   n.f0.accept(t);
	   n.f1.accept(t);
	   n.f2.accept(t);
	   n.f3.accept(t);
	   System.out.println(t.Text);
       }
}