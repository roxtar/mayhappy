import junit.framework.TestCase;
import set.*;
import visitor.*;
import syntaxtree.*;

public class MayHappyTest extends TestCase {
    public void testMethodFindVisitor() {	
	MiniX10Parser parser;
	try {
	    parser = new MiniX10Parser(new java.io.FileInputStream("examples/MapReduce.x10"));	    
	    File f = parser.File();
	    MethodFindVisitor v = new MethodFindVisitor();
	    MethodDeclaration method = v.Find(f, "map");

	    assertEquals(method != null, true);

	    TextVisitor t = new TextVisitor();
	    t.visit(method.f2);
	    assertEquals(t.getText(), "map");

	    method = v.Find(f, "foobar");
	    assertEquals(method == null, true);
	    
	}
	catch (Exception e) {
	    System.err.println(e);
	    return;
	}
	
    }
}