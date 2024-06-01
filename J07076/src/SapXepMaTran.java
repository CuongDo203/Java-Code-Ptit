import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SapXepMaTran {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("MATRIX.in"));
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int r = sc.nextInt();
			int a[][] = new int[n][m];
			List<Integer> lst = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					a[i][j] = sc.nextInt();
					if(j==r-1) {
						lst.add(a[i][j]);
					}
				}
			}
			Collections.sort(lst);
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(j == r-1) {
						System.out.print(lst.get(i) + " ");
					}
					else {
						System.out.print(a[i][j] + " ");
					}
				}
				System.out.println();
			}
		}
		sc.close();
	}

}
