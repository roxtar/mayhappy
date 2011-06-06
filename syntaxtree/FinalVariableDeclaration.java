//
// Generated by JTB 1.2.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> "final"
 * f1 -> Type()
 * f2 -> Identifier()
 * f3 -> "="
 * f4 -> Expression()
 * f5 -> ";"
 */
public class FinalVariableDeclaration implements Node {
   public NodeToken f0;
   public Type f1;
   public Identifier f2;
   public NodeToken f3;
   public Expression f4;
   public NodeToken f5;

   public FinalVariableDeclaration(NodeToken n0, Type n1, Identifier n2, NodeToken n3, Expression n4, NodeToken n5) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
      f5 = n5;
   }

   public FinalVariableDeclaration(Type n0, Identifier n1, Expression n2) {
      f0 = new NodeToken("final");
      f1 = n0;
      f2 = n1;
      f3 = new NodeToken("=");
      f4 = n2;
      f5 = new NodeToken(";");
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public Object accept(visitor.ObjectVisitor v, Object argu) {
      return v.visit(this,argu);
   }
}

