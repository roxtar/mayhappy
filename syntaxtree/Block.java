//
// Generated by JTB 1.2.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> "{"
 * f1 -> ( BlockStatement() )*
 * f2 -> "}"
 */
public class Block extends MhpStatement implements Node {
   public NodeToken f0;
   public NodeListOptional f1;
   public NodeToken f2;

   public Block(NodeToken n0, NodeListOptional n1, NodeToken n2) {
       super();
      f0 = n0;
      f1 = n1;
      f2 = n2;
   }

   public Block(NodeListOptional n0) {
       super();
      f0 = new NodeToken("{");
      f1 = n0;
      f2 = new NodeToken("}");
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public Object accept(visitor.ObjectVisitor v, Object argu) {
      return v.visit(this,argu);
   }
}

