public class Simple {    
    public static void main(String[] args) {
	new Foo().foo();
    }
}
class Foo {
    public void foo() {
	int i = 0;
	System.out.println("Hello there");
	async (0) {
	    i = i + 1;
	    i = i + 3;
	}	
	i  = i - 1;
	i = i + 2;

    }

}