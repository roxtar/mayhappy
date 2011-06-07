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

    public void testSimpleUnion() {
	StringSet s1 = new StringSet();
	StringSet s2 = new StringSet();
	s1.add("lbl1");
	s2.add("lbl2");
	s2.add("lbl1");
	s2.add("lbl3");
	s2.add("lbl4");

	StringSet s3 = s1.union(s2);
	assertEquals(s3.size(), 4);
	assertEquals(s3.contains("lbl4"), true);
	assertEquals(s3.contains("lbl1"), true);
	    
    }

    public void testSimpleIntersect() {
	StringSet s1 = new StringSet();
	StringSet s2 = new StringSet();
	s1.add("lbl1");
	s1.add("lbl1");
	s1.add("lbl2");
	s2.add("lbl2");
	s2.add("lbl9");
	s2.add("foobar");

	StringSet s3 = s1.intersect(s2);
	
	assertEquals(s3.size(), 1);
	assertEquals(s3.contains("lbl2"), true);
    }
}