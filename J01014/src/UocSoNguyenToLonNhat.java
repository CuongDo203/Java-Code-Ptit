import java.util.Scanner;

public class UocSoNguyenToLonNhat {
	
	public static boolean isPrime(long n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return n > 1;
    }
	
	public static void pt(long n) {
		long ans = 0;
		for(int i = 1; i*i <= n; i++) {
			if(n%i==0) {
				if(isPrime(n/i)) {
					System.out.println(n/i);
					return;
				}
				if(isPrime(i)) {
					ans = i;
				}
			}
		}
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			long n = sc.nextLong();
			pt(n);
		}
	}
}
