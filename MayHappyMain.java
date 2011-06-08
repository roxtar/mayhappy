import syntaxtree.*;
import visitor.*;
import set.*;
public class MayHappyMain {
    public static void main(String args[]) {
	
	java.io.InputStream fs = System.in;
	if(args.length > 0) {
	    try {
		fs = new java.io.FileInputStream(args[0]);
	    }
	    catch (Exception e) {
		System.err.println(e);
		return;
	    }
	}
	MiniX10Parser parser = new MiniX10Parser(fs);
	try {
	    Node root = parser.File();
	    System.err.println("Success: Parse");
	    root.accept(new MhpVisitor());
	}
	catch (ParseException e) {
	    System.err.println("Error: Parse" + e);
	}
    }
}