import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class LopIntset_2 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.intersection(s2);
        System.out.println(s3);
	}

}

class IntSet{
	private TreeSet<Integer> se;
	
	public IntSet() {
		se = new TreeSet<>();
	}
	
	public IntSet(int a[]) {
		se = new TreeSet<>();
		for(int i = 0; i < a.length; i++) {
			se.add(a[i]);
		}
	}
	
	public TreeSet<Integer> getSe() {
		return se;
	}

	public void setSe(TreeSet<Integer> se) {
		this.se = se;
	}


	public IntSet intersection(IntSet o) {
		TreeSet<Integer> tmp = this.getSe();
		tmp.retainAll(o.getSe());
		IntSet res = new IntSet();
		res.setSe(tmp);
		return res;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Integer x : this.se) {
			sb.append(x+" ");
		}
		return sb.toString();
	}
	
}