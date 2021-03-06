//
// Generated by JTB 1.2.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> "new"
 * f1 -> NonArrayType()
 * f2 -> "["
 * f3 -> Identifier()
 * f4 -> "]"
 * f5 -> [ ArrayInitializer() ]
 */
public class NewUpdatableArray implements Node {
   public NodeToken f0;
   public NonArrayType f1;
   public NodeToken f2;
   public Identifier f3;
   public NodeToken f4;
   public NodeOptional f5;

   public NewUpdatableArray(NodeToken n0, NonArrayType n1, NodeToken n2, Identifier n3, NodeToken n4, NodeOptional n5) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
      f5 = n5;
   }

   public NewUpdatableArray(NonArrayType n0, Identifier n1, NodeOptional n2) {
      f0 = new NodeToken("new");
      f1 = n0;
      f2 = new NodeToken("[");
      f3 = n1;
      f4 = new NodeToken("]");
      f5 = n2;
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public Object accept(visitor.ObjectVisitor v, Object argu) {
      return v.visit(this,argu);
   }
}

