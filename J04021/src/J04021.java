import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class J04021 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);
	}

}

class IntSet{
	private Set<Integer> se;
	
	public IntSet(int a[]) {
		se = new TreeSet<Integer>();
		for(int i = 0; i < a.length; i++) {
			se.add(a[i]);
		}
	}
	
	public IntSet union(IntSet o) {
		Set<Integer> tmp = new TreeSet<Integer>(this.se);
		tmp.addAll(o.se);
		int a[] = new int[tmp.size()];
		int i = 0;
		for(Integer x : tmp) {
			a[i++] = x;
		}
		return new IntSet(a);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Integer x : se) {
			sb.append(x+" ");
		}
		return sb.toString();
	}
}
