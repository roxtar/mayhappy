//
// Generated by JTB 1.2.2
//

package syntaxtree;

/**
 * The interface which all syntax tree classes must implement.
 */
public interface Node extends java.io.Serializable {
   public void accept(visitor.Visitor v);
   public Object accept(visitor.ObjectVisitor v, Object argu);

}
