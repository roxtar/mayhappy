package visitor;
import syntaxtree.*;
import java.util.*;

public class MethodFindVisitor extends DepthFirstVisitor {
    public MethodDeclaration Find(File n, string name) {
	n.f0.accept(this, name);
	n.f1.accept(this, name);
    }    
    
    public Object visit(ClassMember n, Object argu) {
	Objct _ret = null;
	_ret = n.f0.accept(this, argu);
	return _ret;
    }
    
    /**
    * f0 -> "public"
    * f1 -> ReturnType()
    * f2 -> Identifier()
    * f3 -> "("
    * f4 -> ( FormalParameterList() )?
    * f5 -> ")"
    * f6 -> Block()
    */

    public Object visit(MethodDeclaration n, Object argu) {
	Object _ret = null;
	TextVisitor t = new TextVisitor();
	//n.f0.accept(this, argu);
	//n.f1.accept(this, argu);
	n.f2.accept(t, argu);
	//n.f3.accept(this, argu);
	//n.f4.accept(this, argu);
	//n.f5.accept(this, argu);
	//n.f6.accept(this, argu);

    }

}