//
// Generated by JTB 1.2.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> <STRING_LITERAL>
 */
public class StringLiteral implements Node {
   public NodeToken f0;

   public StringLiteral(NodeToken n0) {
      f0 = n0;
   }

   public StringLiteral() {
      f0 = new NodeToken("\"");
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public Object accept(visitor.ObjectVisitor v, Object argu) {
      return v.visit(this,argu);
   }
}

