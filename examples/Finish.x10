public class Simple {    
    public static void main(String[] args) {
	new Foo().foo();
    }
}
class Foo {
    public void foo() {
	int i = 0;
	i = i + 0;
	i = i + 23;
	async (0) {
	    i = i + 1;
	    i = i + 3;
	} 
	finish {
	    async (1) {
		i = i + 5;
		i = i + 7;
	    }
	}

	i = i + 9;
	
    }

}