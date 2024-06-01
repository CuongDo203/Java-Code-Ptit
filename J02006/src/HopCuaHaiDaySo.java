import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class HopCuaHaiDaySo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[] = new int[n];
		int b[] = new int[m];
		Set<Integer> se = new HashSet<Integer>();
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			se.add(a[i]);
		}
		for(int j = 0; j < m; j++) {
			b[j] = sc.nextInt();
			se.add(b[j]);
		}
		Vector<Integer> v = new Vector<Integer>(se);
		Collections.sort(v);
		for(int it : v) {
			System.out.print(it + " ");
		}
		sc.close();
	}

}
