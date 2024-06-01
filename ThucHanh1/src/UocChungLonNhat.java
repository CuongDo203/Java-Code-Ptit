import java.util.Scanner;

public class UocChungLonNhat {

	public static int gcd(int a, int b) {
		if(b==0) return a;
		else {
			return gcd(b, a%b);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		while(t-->0) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int a[][] = new int[m][n];
			int b[] = new int[m];
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					a[i][j] = sc.nextInt();
				}
			}
			for(int i = 0; i < m; i++) {
				int res = a[i][0];
				
				for(int j = 1; j < n; j++) {
					res = gcd(res, a[i][j]);
				}
				b[i] = res;
			}
			for(int i = 0; i < m; i++) {
				System.out.print(b[i] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}

