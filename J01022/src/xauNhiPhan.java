import java.util.Scanner;

public class xauNhiPhan {

	public static long fb[] = new long[94];
	
	public static void fibo() {
		fb[0] = 0;
		fb[1] = 1;
		fb[2] = 1;
		for(int i = 3; i <= 92; i++) {
			fb[i] = fb[i-1] + fb[i-2];
		}
	}
	
	public static char find(int n, long k) {
		if(n==1) return '0';
		if(n==2) return '1';
		if(k <= fb[n-2]) {
			return find(n-2, k);
		}
		else {
			return find(n-1, k - fb[n-2]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		fibo();
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			long k = sc.nextLong();
			System.out.println(find(n,k));
		}
		sc.close();
	}

}
