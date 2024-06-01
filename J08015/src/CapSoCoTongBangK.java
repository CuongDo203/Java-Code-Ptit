import java.util.Arrays;
import java.util.Scanner;

public class CapSoCoTongBangK {

	public static long lower(long a[], int l, int r, long x) {
		long ans = -1;
		while(l <= r) {
			int m = (l+r)/2;
			if(a[m]==x) {
				ans = m;
				r = m-1;
			}
			else if(a[m] > x) {
				r = m-1;
			}
			else {
				l = m+1;
			}
		}
		return ans;
	}
	
	public static long upper(long a[], int l, int r, long x) {
		long ans = -1;
		while(l<=r) {
			int m = (l+r)/2;
			if(a[m] == x) {
				ans = m;
				l = m+1;
			}
			else if(a[m] > x) {
				r = m-1;
			}
			else {
				l = m+1;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			long a[] = new long[n];
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			Arrays.sort(a);
			long cnt = 0;
			for(int i = 0; i < n; i++) {
				long u = upper(a, i+1, n-1, k-a[i]);
				if(u!=-1) {
					long d = lower(a, i+1, n-1, k-a[i]);
					cnt += u-d+1;
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}

}
