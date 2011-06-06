//
// Generated by JTB 1.2.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> PrimaryExpression()
 * f1 -> "+"
 * f2 -> Expression()
 */
public class PlusExpression implements Node {
   public PrimaryExpression f0;
   public NodeToken f1;
   public Expression f2;

   public PlusExpression(PrimaryExpression n0, NodeToken n1, Expression n2) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
   }

   public PlusExpression(PrimaryExpression n0, Expression n1) {
      f0 = n0;
      f1 = new NodeToken("+");
      f2 = n1;
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public Object accept(visitor.ObjectVisitor v, Object argu) {
      return v.visit(this,argu);
   }
}

