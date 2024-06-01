import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BoBaSoPytago {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			List<Long> a = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				long x = sc.nextLong();
				a.add(x*x);
			}
			Collections.sort(a);
			boolean ok = false;
			for(int i = 0; i < n-2; i++) {
				for(int j = i+1; j < n-1; j++) {
					long tmp = a.get(i) + a.get(j);
					int l = j+1, r = n-1;
					while(l <= r) {
						int m = (l+r)/2;
						if(a.get(m) == tmp) {
							ok = true;
							break;
						}
						else if(a.get(m) > tmp) {
							r = m-1;
						}
						else {
							l = m+1;
						}
					}
					if(ok) {
						i=n;
						break;
					}
				}
			}
			System.out.println(ok ? "YES" : "NO");
		}
		sc.close();
	}

}
