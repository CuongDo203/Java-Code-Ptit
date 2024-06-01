import java.util.Scanner;
import java.util.Arrays;

public class TongUocSo1 {

	public static int p[] = new int[2000001]; 
	
	public static void sieve() {
		for(int i = 0; i <= 2000000; i++) {
			p[i] = i;
		}
		for(int i = 2; i*i <= 2000000; i++) {
			if(p[i]==i) {
				for(int j = i*i; j <= 2000000; j+=i) {
					if(p[j]==j) {
						p[j] = i;
					}
				}
			}
		}
	}
	
	public static long solve(int n) {
		long cnt= 0;
		while(n!=1) {
			cnt += p[n];
			n/=p[n];
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sieve();
		int t = sc.nextInt();
		long ans = 0;
		while(t-- > 0) {
			int  n =sc.nextInt();
			ans += solve(n);
		}
		System.out.println(ans);
		sc.close();
	}

}
