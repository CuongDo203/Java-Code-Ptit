import java.util.Scanner;

public class MangDoiXung {

	public static boolean isSymmetrical(int a[], int n) {
		int l = 0, r = n-1;
		while(l < r) {
			if(a[l] != a[r])
				return false;
			l++;
			r--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			if(isSymmetrical(a, n)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		sc.close();
	}

}
