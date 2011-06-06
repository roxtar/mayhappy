//
// Generated by JTB 1.2.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> "return"
 * f1 -> [ Expression() ]
 * f2 -> ";"
 */
public class ReturnStatement implements Node {
   public NodeToken f0;
   public NodeOptional f1;
   public NodeToken f2;

   public ReturnStatement(NodeToken n0, NodeOptional n1, NodeToken n2) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
   }

   public ReturnStatement(NodeOptional n0) {
      f0 = new NodeToken("return");
      f1 = n0;
      f2 = new NodeToken(";");
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public Object accept(visitor.ObjectVisitor v, Object argu) {
      return v.visit(this,argu);
   }
}

