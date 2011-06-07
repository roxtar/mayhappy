package test;
import junit.framework.TestCase;
import set.*;
public class StringPairSetTest extends TestCase{

    public void testSimpleAdd() {
	StringPairSet s = new StringPairSet();
	s.add(new StringPair("foo", "bar"));
	s.add(new StringPair("foo", "bar"));
	s.add(new StringPair("bar", "foo"));
	s.add(new StringPair("baz", "bam"));
	assertEquals(s.size(), 3);
    }

    public void testSimpleUnion() {
	StringPairSet s1 = new StringPairSet();
	StringPairSet s2 = new StringPairSet();

	s1.add(new StringPair("foo", "bar"));
	s1.add(new StringPair("bar", "baz"));

	s2.add(new StringPair("foo", "bar"));
	s2.add(new StringPair("floo", "gloo"));

	StringPairSet s3 = s1.union(s2);
	assertEquals(s3.size(), 3);
    }	   

    public void testSimpleIntersect() {
	StringPairSet s1 = new StringPairSet();
	StringPairSet s2 = new StringPairSet();

	s1.add(new StringPair("foo", "bar"));
	s1.add(new StringPair("bar", "baz"));

	s2.add(new StringPair("foo", "bar"));
	s2.add(new StringPair("floo", "gloo"));

	StringPairSet s3 = s1.intersect(s2);
	assertEquals(s3.size(), 1);

    }

}