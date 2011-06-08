//
// Generated by JTB 1.2.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> Assignment()
 *       | AsyncStatement()
 *       | Block()
 *       | FinishStatement()
 *       | IfStatement()
 *       | LoopStatement()
 *       | PostfixStatement()
 *       | PrintlnStatement()
 *       | ReturnStatement()
 *       | ThrowStatement()
 *       | WhileStatement()
 */
public class Statement extends MhpStatement implements Node {
   public NodeChoice f0;

   public Statement(NodeChoice n0) {
       super();
      f0 = n0;
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public Object accept(visitor.ObjectVisitor v, Object argu) {
      return v.visit(this,argu);
   }
}

