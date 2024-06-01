import java.util.Arrays;
import java.util.Scanner;

public class BoSungDaySo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dd[] = new int[205];
		int a[] = new int[n];
		Arrays.fill(dd, 0);
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			dd[a[i]] = 1;
		}
		boolean ok = true;
		for(int i = 1; i <= a[n-1]; i++) {
			if(dd[i]==0) {
				ok = false;
				System.out.println(i);
			}
		}
		if(ok) {
			System.out.println("Excellent!");
		}
		sc.close();
	}

}
