package visitor;
import syntaxtree.*;
import java.util.*;
import set.*;
public class MhpVisitor extends DepthFirstVisitor {
    StringPairSet M;
    StringSet L;
    StringSet O;
    
    public MhpVisitor(){
	M = new StringPairSet();
	L = new StringSet();
	O = new StringSet();
    }

    public void visit(File n ) {
      n.f0.accept(this);
      n.f1.accept(this);
      System.out.println(this.M);
    }

    /**
    * f0 -> Assignment()
    *       | AsyncStatement()
    *       | Block()
    *       | FinishStatement()
    *       | IfStatement()
    *       | LoopStatement()
    *       | PostfixStatement()
    *       | PrintlnStatement()
    *       | ReturnStatement()
    *       | ThrowStatement()
    *       | WhileStatement()
    */
   public void visit(Statement n) {
      n.f0.accept(this);
      Object o = n.f0.choice;
      copySets(n, o);	  
   }


   /**
    * f0 -> Expression()
    * f1 -> ";"
    */

    public void visit(PostfixStatement statement) {
	// TODO: Need to check whether Expression is a function
	Expression expr = statement.f0;
	TextVisitor t = new TextVisitor();
	t.visit(expr);
	
	// Add the expression to the L field of L
	statement.L.add(t.getText());

	updateBlockProduction(statement);
    }

    /**
    * f0 -> Expression()
    * f1 -> "="
    * f2 -> Expression()
    * f3 -> ";"
    */

    public void visit(Assignment n) { 
	TextVisitor t = new TextVisitor();
	n.f0.accept(t);
	n.f1.accept(t);
	n.f2.accept(t);
	n.f3.accept(t);
	n.L.add(t.getText());
	updateBlockProduction(n);
    }

       /**
	* f0 -> "async"
	* f1 -> "("
	* f2 -> Expression()
	* f3 -> ")"
	* f4 -> Block()
	*/

    public void visit(AsyncStatement n) {
	n.f0.accept(this);
	n.f1.accept(this);
	n.f2.accept(this);
	n.f3.accept(this);
	n.f4.accept(this);
	copySets(n, n.f4);
	updateAsyncProduction(n);
    }

    
    /**
    * f0 -> "{"
    * f1 -> ( BlockStatement() )*
    * f2 -> "}"
    */
   public void visit(Block n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);

      // Run through all the blocks and pick up the M, L and O values
      if(n.f1.present()) {
	  for(Enumeration e = n.f1.elements(); e.hasMoreElements(); ) {
	      Object node = e.nextElement();
	      unionSets(n, node);
	  }
      }
   }

    /**
    * f0 -> FinalVariableDeclaration()
    *       | UpdatableVariableDeclaration()
    *       | Statement()
    */

    public void visit(BlockStatement n) {
      n.f0.accept(this);
      Object o = n.f0.choice;
      copySets(n, o);
   }

    private void updateBlockProduction(MhpStatement statement) {
	// Update the global and local M, O, L values
	// s1;s2 = 
	// M' = M1 U M2 U symcross(O1, L2)
	// O' = O1 U O2
	// L' = L1 U L2
	StringPairSet mdash = this.M.union(statement.M);
	mdash = mdash.union(this.O.symcross(statement.L));
	
	this.M = mdash;
	statement.M = mdash;
	
	StringSet odash = this.O.union(statement.O);
	this.O = odash;
	statement.O = odash;

	StringSet ldash = this.L.union(statement.L);
	      
	this.L = ldash;

    }

    private void updateAsyncProduction(MhpStatement statement) {
	this.O = statement.L;
	this.L = statement.L;	    
    }
    
    private void copySets(MhpStatement n, Object o) {
	if(o instanceof MhpStatement) {
	    MhpStatement statement = (MhpStatement) o;
	    n.M = statement.M;
	    n.L = statement.L;
	    n.O = statement.O;
	}
    }

    private void unionSets(MhpStatement n, Object o) {
	if(o instanceof MhpStatement) {
	    MhpStatement statement = (MhpStatement) o;
	    
	    n.L = n.L.union(statement.L);
	    n.O = n.O.union(statement.O);
	}
    }

    private void print(String s) {
	System.out.println(s);
    }

}