import junit.framework.TestCase;
import set.*;
import visitor.*;
import syntaxtree.*;
import java.util.*;
public class MapReduceTest extends TestCase {
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

    public void testMhpSimple() {
	File f = Parse("examples/MapReduce.x10");
	MhpVisitor v = new MhpVisitor(false);
	v.visit(f);	
	assertEquals(v.M.size(), 0);

	MethodFindVisitor finder = new MethodFindVisitor();	
	MethodDeclaration method = finder.find(f, "map");
	Block block = method.f6;
	Enumeration e = block.f1.elements();
	Object node = e.nextElement(); //finish


	BlockStatement blockstatement = (BlockStatement) node;
	Statement statement = (Statement)blockstatement.f0.choice;
	FinishStatement finish = (FinishStatement)statement.f0.choice;
	statement = finish.f1;
	LoopStatement loopstatement = (LoopStatement)statement.f0.choice;
	assertEquals(loopstatement.M.size(), 4);
    }
}