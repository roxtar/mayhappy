//
// Generated by JTB 1.2.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> "public"
 * f1 -> "static"
 * f2 -> "final"
 * f3 -> Type()
 * f4 -> Identifier()
 * f5 -> "="
 * f6 -> Expression()
 * f7 -> ";"
 */
public class ConstantDeclaration implements Node {
   public NodeToken f0;
   public NodeToken f1;
   public NodeToken f2;
   public Type f3;
   public Identifier f4;
   public NodeToken f5;
   public Expression f6;
   public NodeToken f7;

   public ConstantDeclaration(NodeToken n0, NodeToken n1, NodeToken n2, Type n3, Identifier n4, NodeToken n5, Expression n6, NodeToken n7) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
      f5 = n5;
      f6 = n6;
      f7 = n7;
   }

   public ConstantDeclaration(Type n0, Identifier n1, Expression n2) {
      f0 = new NodeToken("public");
      f1 = new NodeToken("static");
      f2 = new NodeToken("final");
      f3 = n0;
      f4 = n1;
      f5 = new NodeToken("=");
      f6 = n2;
      f7 = new NodeToken(";");
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public Object accept(visitor.ObjectVisitor v, Object argu) {
      return v.visit(this,argu);
   }
}

