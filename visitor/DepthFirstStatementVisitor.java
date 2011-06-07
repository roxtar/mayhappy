package visitor;
import syntaxtree.*;
import java.util.*;

public class DepthFirstStatementVisitor extends DepthFirstVisitor {
       public void visit(Statement n) { 
	   n.f0.accept(new DepthFirstPrintVisitor());
	   System.out.println("");
       }
}