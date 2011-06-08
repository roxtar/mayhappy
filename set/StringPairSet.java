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

    public String toString() {
	java.util.Iterator i = this.iterator();
	StringBuilder str = new StringBuilder();
	str.append("{\n");
	while(i.hasNext()) {
	    StringPair strpair = (StringPair)i.next();
	    str.append("(" + strpair.v1 + ", " + strpair.v2 + ")\n");
	}
	str.append("}\n");
	return str.toString();
    }

}