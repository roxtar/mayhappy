package set;

public class StringSet extends java.util.HashSet<String>{
    
    public StringSet union(StringSet s) {
	StringSet result = new StringSet();
	java.util.Iterator i = this.iterator();
	while(i.hasNext()) {
	    result.add(i.next().toString());
	}
	if(s != null) {
	    i = s.iterator();
	    while(i.hasNext()) {
		result.add(i.next().toString());
	    }
	}
	return result;		
    }

    public StringSet intersect(StringSet s) {
	StringSet result = new StringSet();
	if(s != null) {
	    java.util.Iterator i = s.iterator();
	    while(i.hasNext()) {
		String str = i.next().toString();
		if(this.contains(str))
		    result.add(str);
	    }
	}
	return result;
    }

    public StringSet subtract(StringSet s) {
	StringSet result = new StringSet();
	java.util.Iterator j = this.iterator();
	while(j.hasNext()) {
	    String str = j.next().toString();
	    result.add(str);
	}
	    
	if(s != null) {
	    java.util.Iterator i = s.iterator();
	    while(i.hasNext()) {
	        String str = i.next().toString();
		if(this.contains(str)) {
		    result.remove(str);
		}
	    }
	}
	return result;
    }

    // Cartesian product
    // A x B = {(a, b) | a \in A and b \in B}
    // A x \phi = \phi
    public StringPairSet cross(StringSet s) {
	StringPairSet result = new StringPairSet();
	if(s != null) {
	    java.util.Iterator i = s.iterator();
	    while(i.hasNext()) {
		java.util.Iterator j = this.iterator();
		String istr = i.next().toString();
		while(j.hasNext()) {
		    String jstr = j.next().toString();
		    StringPair pair = new StringPair(jstr, istr);
		    result.add(pair);
		}
	    }
	}
	return result;		    
    }

    public StringPairSet symcross(StringSet s) {
	StringPairSet result = new StringPairSet();
	if(s != null && s.size() > 0 && this.size() > 0) {
	    result = this.cross(s);
	    result = result.union(s.cross(this));		
	}
	return result;
    }

    public String toString() {
	StringBuilder str = new StringBuilder();
	java.util.Iterator i = this.iterator();
	str.append("{\n");
	while(i.hasNext()) {
	    String s = (String)i.next();
	    str.append("("+s+")\n");
	}
	str.append("}\n");
	return str.toString();
    }
	    
}


