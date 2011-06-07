package visitor;
import syntaxtree.*;
import java.util.*;

public class DepthFirstExpressionVisitor extends DepthFirstVisitor {
       public void visit(Expression n) { 
	   n.f0.accept(new DepthFirstPrintVisitor());
	   System.out.println("");
       }
}