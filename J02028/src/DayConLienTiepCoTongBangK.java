import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DayConLienTiepCoTongBangK {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			long k = sc.nextLong();
			Map<Long, Integer> mp = new HashMap<>();
			mp.put(0l, 0);
			long a[] = new long[n];
			long pre[] = new long[n+1];
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextLong();
			}
			for(int i = 1; i <= n; i++) {
				pre[i] = pre[i-1] + a[i-1];
			}
			boolean ok = false;
			for(int i = 0; i < n; i++) {
				if(!mp.containsKey(pre[i+1]-k)) {
					mp.put(pre[i+1], i);
				}
				else {
					ok = true;
					break;
				}
			}
			System.out.println(ok ? "YES" : "NO");
			mp.clear();
		}
		sc.close();
	}

}
