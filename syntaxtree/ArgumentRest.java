//
// Generated by JTB 1.2.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> ","
 * f1 -> Expression()
 */
public class ArgumentRest implements Node {
   public NodeToken f0;
   public Expression f1;

   public ArgumentRest(NodeToken n0, Expression n1) {
      f0 = n0;
      f1 = n1;
   }

   public ArgumentRest(Expression n0) {
      f0 = new NodeToken(",");
      f1 = n0;
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public Object accept(visitor.ObjectVisitor v, Object argu) {
      return v.visit(this,argu);
   }
}

