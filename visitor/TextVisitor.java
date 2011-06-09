package visitor;
import syntaxtree.*;
import java.util.*;
import java.lang.StringBuilder;
public class TextVisitor extends DepthFirstVisitor {
    private StringBuilder _text;
    private int _indent;

    public String getText() {
	return  _text.toString().trim();     
    }

    public TextVisitor() {
	_text = new StringBuilder();
	_indent = 0;
    }

    public void visit(NodeToken n) { 
	_text.append(n.toString());
    }


    /**
     * f0 -> Expression()
     * f1 -> "="
     * f2 -> Expression()
     * f3 -> ";"
     */

    public void visit(Assignment n) {
	addIndent();
	n.f0.accept(this);
	addSpace();
	n.f1.accept(this);
	addSpace();
	n.f2.accept(this);
	n.f3.accept(this);
    }

       /**
    * f0 -> "new"
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> [ ExpressionList() ]
    * f4 -> ")"
    */
   public void visit(NewObject n) {
       addIndent();
       n.f0.accept(this);
       addSpace();
       n.f1.accept(this);
       n.f2.accept(this);
       n.f3.accept(this);
       n.f4.accept(this);
   }


   /**
    * f0 -> "new"
    * f1 -> NonArrayType()
    * f2 -> "["
    * f3 -> Identifier()
    * f4 -> "]"
    * f5 -> [ ArrayInitializer() ]
    */
   public void visit(NewUpdatableArray n) {
       addIndent();
      n.f0.accept(this);
      addSpace();
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
   }


    /**
     * f0 -> "{"
     * f1 -> ( BlockStatement() )*
     * f2 -> "}"
     */

    public void visit(Block n) {
	addSpace();
	n.f0.accept(this);
	addLine();
	incIndent();
	n.f1.accept(this);
	decIndent();
	addLine();
	addIndent();
	n.f2.accept(this);
    }

    /**
     * f0 -> "async"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> Block()
     */

    public void visit(AsyncStatement n) {
	addIndent();
	n.f0.accept(this);
	addSpace();
	n.f1.accept(this);
	n.f2.accept(this);
	n.f3.accept(this);
	n.f4.accept(this);
    }

    /**
     * f0 -> "final"
     * f1 -> Type()
     * f2 -> Identifier()
     * f3 -> "="
     * f4 -> Expression()
     * f5 -> ";"
     */
    public void visit(FinalVariableDeclaration n) {
	addIndent();
	n.f0.accept(this);
	addSpace();
	n.f1.accept(this);
	addSpace();
	n.f2.accept(this);
	addSpace();
	n.f3.accept(this);
	addSpace();
	n.f4.accept(this);
	n.f5.accept(this);
	addLine();
    }

    /**
     * f0 -> "finish"
     * f1 -> Statement()
     */
    public void visit(FinishStatement n) {
	addIndent();
	n.f0.accept(this);
	addSpace();
	n.f1.accept(this);
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     * f2 -> "="
     * f3 -> Expression()
     * f4 -> ";"
     */
    public void visit(UpdatableVariableDeclaration n) {
	addIndent();
	n.f0.accept(this);
	addSpace();
	n.f1.accept(this);
	addSpace();
	n.f2.accept(this);
	addSpace();
	n.f3.accept(this);      
	n.f4.accept(this);
	addLine();
    }

    /**
     * f0 -> "while"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> Statement()
     */
    public void visit(WhileStatement n) {
	addIndent();
	n.f0.accept(this);
	addSpace();
	n.f1.accept(this);
	n.f2.accept(this);
	n.f3.accept(this);
	n.f4.accept(this);
    }

       /**
    * f0 -> "return"
    * f1 -> [ Expression() ]
    * f2 -> ";"
    */
    public void visit(ReturnStatement n) {
	addIndent();
      n.f0.accept(this);      
      addSpace();
      n.f1.accept(this);
      n.f2.accept(this);
   }




    private void addSpace() {
	_text.append(" ");
    }

    private void addLine() {
	_text.append("\n");
    }

    private void incIndent() {
	_indent++;
    }

    private void decIndent() {
	_indent--;
    }

    private void addIndent() {
	for(int i=0; i < _indent; i++) 
	    _text.append("    ");
    }
}