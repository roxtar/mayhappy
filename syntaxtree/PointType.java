//
// Generated by JTB 1.2.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> "point"
 * f1 -> "("
 * f2 -> ":"
 * f3 -> RankEquation()
 * f4 -> ")"
 */
public class PointType implements Node {
   public NodeToken f0;
   public NodeToken f1;
   public NodeToken f2;
   public RankEquation f3;
   public NodeToken f4;

   public PointType(NodeToken n0, NodeToken n1, NodeToken n2, RankEquation n3, NodeToken n4) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
   }

   public PointType(RankEquation n0) {
      f0 = new NodeToken("point");
      f1 = new NodeToken("(");
      f2 = new NodeToken(":");
      f3 = n0;
      f4 = new NodeToken(")");
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public Object accept(visitor.ObjectVisitor v, Object argu) {
      return v.visit(this,argu);
   }
}

