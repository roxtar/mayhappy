package syntaxtree;
import set.*;

public class MhpStatement {
    public static int _label_count = 0;
    public StringPairSet M;
    public StringSet L;
    public StringSet O; 

    String _label;

    public MhpStatement() {
	M = new StringPairSet();
	L = new StringSet();
	O = new StringSet();
	_label = "";
    }

    public String getLabel() {
	if(_label.equals("")) {
	    _label = "L"+_label_count+++":";
	}
	return _label;
    }
}
