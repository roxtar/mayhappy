
import junit.framework.TestCase;
import set.*;
public class StringSetTest extends TestCase{

    public void testSimpleAdd() {
	StringSet s = new StringSet();
	s.add("foo");
	s.add("foo");
	s.add("bar");
	s.add("baz");
	assertEquals(s.size(), 3);
    }
}