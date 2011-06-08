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

    public StringPairSet subtract(StringPairSet s) {
	StringPairSet result = new StringPairSet();
	java.util.Iterator j = this.iterator();
	while(j.hasNext()) {
	    StringPair str = (StringPair)j.next();
	    result.add(str);
	}
	    
	if(s != null) {
	    java.util.Iterator i = s.iterator();
	    while(i.hasNext()) {
	        StringPair str = (StringPair)i.next();
		if(this.contains(str)) {
		    result.remove(str);
		}
	    }
	}
	return result;
    }

    public StringPairSet subtract(StringSet s) {
	StringPairSet result = new StringPairSet();
	java.util.Iterator j = this.iterator();
	while(j.hasNext()) {
	    StringPair str = (StringPair)j.next();
	    if(!s.contains(str.v1) && !s.contains(str.v2)) {
		System.out.println("adding " + str.v1);
		System.out.println("adding " + str.v2);
		result.add(str);
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