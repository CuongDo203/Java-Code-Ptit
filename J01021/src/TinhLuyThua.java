import java.util.Scanner;

public class TinhLuyThua {

	public static int mod = (int) (1e9+7);
	
	public static long powMod(long a, long b) {
		if(b==0) {
			return 1;
		}
		long x = powMod(a, b/2) % mod;
		if(b%2==1) {
			return ((x*x)%mod * (a%mod))%mod; 
		}
		else {
			return (x*x)%mod;
		}
	}
	
	public static void main(String[] args) {
		long a, b;
		Scanner sc = new Scanner(System.in);
		while(true) {
			a = sc.nextLong();
			b = sc.nextLong();
			if(a==0&&b==0) {
				return;
			}
			System.out.println(powMod(a, b));
		}
	}

}
