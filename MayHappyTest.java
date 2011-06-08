import junit.framework.TestCase;
import set.*;
import visitor.*;
import syntaxtree.*;

public class MayHappyTest extends TestCase {
    MiniX10Parser _parser;
    public File Parse(String file) {
	try {	    
	    java.io.InputStream stream = new java.io.FileInputStream(file);
	    _parser = new MiniX10Parser(stream);
	    File f = _parser.File();
	    return f;
	}
	catch (Exception e) {
	    System.err.println(e);
	    return null;
	}
    }
    public void testMethodFindVisitor() {	
	File f = Parse("examples/MapReduce.x10");
	MethodFindVisitor v = new MethodFindVisitor();
	MethodDeclaration method = v.find(f, "map");

	assertEquals(method != null, true);

	TextVisitor t = new TextVisitor();
	t.visit(method.f2);
	assertEquals(t.getText(), "map");

	method = v.find(f, "foobar");
	assertEquals(method == null, true);	    	
    }
}