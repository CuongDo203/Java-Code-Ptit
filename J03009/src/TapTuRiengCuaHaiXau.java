import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TapTuRiengCuaHaiXau {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while(t-- > 0) {
			String[] s1 = sc.nextLine().split(" ");
			String s2[] = sc.nextLine().split(" ");
			Set<String> a = new TreeSet<String>();
			Set<String> b = new TreeSet<String>();
			for(String x : s1) {
				a.add(x);
			}
			for(String x : s2) {
				b.add(x);
			}
			a.removeAll(b);
			for(String x : a) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}

