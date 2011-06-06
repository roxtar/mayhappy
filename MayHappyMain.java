import syntaxtree.*;
import visitor.*;

public class MayHappyMain {
    public static void main(String args[]) {
	MiniX10Parser parser = new MiniX10Parser(System.in);
	try {
	    Node root = parser.File();
	    System.err.println("Success: Parse");
	    root.accept(new DepthFirstVisitor());
	}
	catch (ParseException e) {
	    System.err.println("Error: Parse");
	}
    }
}