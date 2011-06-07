package set;
public class StringPairSet extends java.util.HashSet<StringPair> {
        public StringPairSet union(StringPairSet s) {
	StringPairSet result = new StringPairSet();
	java.util.Iterator i = this.iterator();
	while(i.hasNext()) {
	    result.add((StringPair)i.next());
	}
	if(s != null) {
	    i = s.iterator();
	    while(i.hasNext()) {
		result.add((StringPair)i.next());
	    }
	}
	return result;		
    }

    public StringPairSet intersect(StringPairSet s) {
	StringPairSet result = new StringPairSet();
	if(s != null) {
	    java.util.Iterator i = s.iterator();
	    while(i.hasNext()) {
		StringPair strpair = (StringPair)i.next();
		if(this.contains(strpair))
		    result.add(strpair);
	    }
	}
	return result;
    }

}