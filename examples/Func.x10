public class Simple {    
    public static void main(String[] args) {
	new Foo().foo();
    }
}
class Foo {
    public void foo() {
	this.bar();
	this.baz();
    }

    public void baz() {
	async (0) {
	    System.out.println("I am in baz");
	}
    }

    public void bar() {
	int i = 0;
	System.out.println("Hello there");
	async (0) {
	    i = i + 1;
	    i = i + 3;
	}	
	i  = i -1;
	i = i + 2;
    }

}