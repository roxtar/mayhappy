public class MapReduce {
    public static void main(String[] args) { new MR().run(); }
}

class MR {
  public static final region(:rank==1) r = [0:300];
  public static final dist(:rank==1) d = (dist(:rank==1))dist.factory.block(r);
  public static final int[:rank==1] a = new int[d](point(:rank==1) [i]) { return i; };
  public int total;

  public void run() {
    total=0; this.map(); this.reduce(); System.out.println(total);
  }
  public void map() {
    finish for (point(:rank==1) [p]: a) { 
      async(d[p]) {
        int x = a[p];
        a[p]=this.f(x);
      }
    }
  }
  public int f(int x) { return x*x; }
  public void reduce() {
    final place h = here;
    for (point(:rank==1) [p]: a) {
      finish {
        async(d[p]) { 
          final int v = a[p];
          async(h) { 
            total = total + v; 
          }
        }
      }
    }
  }
}
