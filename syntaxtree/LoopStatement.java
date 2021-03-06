//
// Generated by JTB 1.2.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> "for"
 * f1 -> "("
 * f2 -> PointType()
 * f3 -> ExplodedSpecification()
 * f4 -> ":"
 * f5 -> Expression()
 * f6 -> ")"
 * f7 -> Statement()
 */
public class LoopStatement extends MhpStatement implements Node {
   public NodeToken f0;
   public NodeToken f1;
   public PointType f2;
   public ExplodedSpecification f3;
   public NodeToken f4;
   public Expression f5;
   public NodeToken f6;
   public Statement f7;

   public LoopStatement(NodeToken n0, NodeToken n1, PointType n2, ExplodedSpecification n3, NodeToken n4, Expression n5, NodeToken n6, Statement n7) {

       super();
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
      f5 = n5;
      f6 = n6;
      f7 = n7;
   }

   public LoopStatement(PointType n0, ExplodedSpecification n1, Expression n2, Statement n3) {
       super();
      f0 = new NodeToken("for");
      f1 = new NodeToken("(");
      f2 = n0;
      f3 = n1;
      f4 = new NodeToken(":");
      f5 = n2;
      f6 = new NodeToken(")");
      f7 = n3;
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public Object accept(visitor.ObjectVisitor v, Object argu) {
      return v.visit(this,argu);
   }
}

