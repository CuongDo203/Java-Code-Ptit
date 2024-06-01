import java.util.Scanner;

public class TichMaTranVoiChuyenViCuaNo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int test = 1; test <= t; test++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int a[][] = new int[n][m];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					a[i][j] = sc.nextInt();
				}
			}
			int b[][] = new int[m][n];
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					b[i][j] = a[j][i];
				}
			}
			int mul[][] = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					mul[i][j] = 0;
					for(int k = 0; k < m; k++) {
						mul[i][j] += a[i][k] * b[k][j]; 
					}
				}
			}
			System.out.println("Test "+test+":");
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(mul[i][j]+ " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
