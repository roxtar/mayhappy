//
// Generated by JTB 1.2.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> "dist.UNIQUE"
 */
public class DistUnique implements Node {
   public NodeToken f0;

   public DistUnique(NodeToken n0) {
      f0 = n0;
   }

   public DistUnique() {
      f0 = new NodeToken("dist.UNIQUE");
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public Object accept(visitor.ObjectVisitor v, Object argu) {
      return v.visit(this,argu);
   }
}
