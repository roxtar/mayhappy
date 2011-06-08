package visitor;
import syntaxtree.*;
import java.util.*;

public class MethodFindVisitor extends ObjectDepthFirst {
    MethodDeclaration _method;
    public MethodDeclaration find(File n, String name) {
	_method = null;
	n.f0.accept(this, name);
	n.f1.accept(this, name);
	return _method;
	    
    }    
    
    public Object visit(ClassMember n, Object argu) {
	Object _ret = null;
	String name;
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
	n.f2.accept(t);
	//n.f3.accept(this, argu);
	//n.f4.accept(this, argu);
	//n.f5.accept(this, argu);
	//n.f6.accept(this, argu);
	_ret = t.getText();
	if(argu != null && argu instanceof String) {
	    if(_ret.equals((String)argu)) {
		_method = n;
	    }
	}
	return _ret;
    }

}