import java.util.Scanner;

public class SoXaCach {

	static int a[] = new int[15];
	static boolean vs[] = new boolean[15];
	
	static boolean check(int n) {
		for(int i = 2; i <= n; i++) {
			if(Math.abs(a[i] - a[i-1]) == 1)
				return false;
		}
		return true;
	}
	
	static void Dq(int i, int n) {
		if(i==n+1) {
			if(check(n)) {
				for(int k = 1; k <= n; k++) {
					System.out.print(a[k]);
				}
				System.out.println();
			}
			return;
		}
		for(int j = 1; j <= n; j++) {
			if(!vs[j]) {
				a[i] = j;
				vs[j] = true;
				Dq(i+1, n);
				vs[j] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			Dq(1,n);
		}
		sc.close();
	}

}
