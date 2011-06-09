public class Simple {    
    public static void main(String[] args) {
	new Foo().foo();
    }
}
class Foo {
    public void foo() {
	this.baz();
    }

    public void baz() {
	async (0) {
	    System.out.println("I am in baz");
	    this.baz();
	}
    } 
}