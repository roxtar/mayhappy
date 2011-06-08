//
// Generated by JTB 1.2.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> FinalVariableDeclaration()
 *       | UpdatableVariableDeclaration()
 *       | Statement()
 */
public class BlockStatement extends MhpStatement implements Node {
   public NodeChoice f0;

   public BlockStatement(NodeChoice n0) {
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

