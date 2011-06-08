package syntaxtree;
import set.*;

public class MhpStatement {
    public StringPairSet M;
    public StringSet L;
    public StringSet O; 

    public MhpStatement() {
	M = new StringPairSet();
	L = new StringSet();
	O = new StringSet();
    }
}
