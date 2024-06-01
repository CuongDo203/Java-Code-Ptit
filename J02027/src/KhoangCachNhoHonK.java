import java.util.Arrays;
import java.util.Scanner;

public class KhoangCachNhoHonK {

	public static int lowerBound(int a[],int l, int r, int key) {
		while(l<r) {
			int m = l + (r-l)/2;
			if(key<=a[m]) {
				r = m;
			}
			else {
				l = m + 1;
			}
		}
		if(l < a.length && a[l] < key) {
			l++;
		}
		return l;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int a[] = new int[n];
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			Arrays.sort(a);
			long cnt=0;
			for(int i = 0; i < n; i++) {
				int idx = lowerBound(a, i+1, n-1, a[i]+k)-1;
				cnt += idx-i;
			}
			System.out.println(cnt);
		}
		sc.close();
	}

}
