package set;
public class StringPair {
    public String v1; 
    public String v2;
    

    public StringPair(String s1, String s2) {
	v1 = s1;
	v2 = s2;
    }
    
    public StringPair() {
    }

    @Override public boolean equals(Object that) {
	if(this == that) return true;
	if(this instanceof StringPair == false) return false;

	StringPair p = (StringPair)that;
	return v1.equals(p.v1) && v2.equals(p.v2);
    }

    @Override public int hashCode() {
	int hash = 13;
	hash = 31 * hash + (this.v1 == null ? 0 : this.v1.hashCode());
	hash = 31 * hash + (this.v2 == null ? 0 :this.v2.hashCode());
	return hash;
    }
}