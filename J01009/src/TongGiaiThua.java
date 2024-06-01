import java.util.Scanner;

public class TongGiaiThua {

	public static long gt(int n) {
		long res = 1;
		for(int i = 2; i <= n; i++) {
			res = res*i;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long ans = 0;
		for(int i = 1; i <= n; i++) {
			ans += gt(i);
		}
		System.out.println(ans);
	}

}
