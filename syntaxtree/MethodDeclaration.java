//
// Generated by JTB 1.2.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> "public"
 * f1 -> ReturnType()
 * f2 -> Identifier()
 * f3 -> "("
 * f4 -> ( FormalParameterList() )?
 * f5 -> ")"
 * f6 -> Block()
 */
public class MethodDeclaration extends MhpStatement implements Node {
   public NodeToken f0;
   public ReturnType f1;
   public Identifier f2;
   public NodeToken f3;
   public NodeOptional f4;
   public NodeToken f5;
   public Block f6;

   public MethodDeclaration(NodeToken n0, ReturnType n1, Identifier n2, NodeToken n3, NodeOptional n4, NodeToken n5, Block n6) {
       super();
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
      f5 = n5;
      f6 = n6;
   }

   public MethodDeclaration(ReturnType n0, Identifier n1, NodeOptional n2, Block n3) {
       super();
      f0 = new NodeToken("public");
      f1 = n0;
      f2 = n1;
      f3 = new NodeToken("(");
      f4 = n2;
      f5 = new NodeToken(")");
      f6 = n3;
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public Object accept(visitor.ObjectVisitor v, Object argu) {
      return v.visit(this,argu);
   }
}

