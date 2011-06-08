public class Simple {    
    public static void main(String[] args) {
	new Foo().foo();
    }
}
class Foo {
    public void foo() {
	int i = 0;
	while(i==0) {
	    async (0) {
		i = i + 1;
		i = i + 3;
	    }	
	 
	}
    }

}