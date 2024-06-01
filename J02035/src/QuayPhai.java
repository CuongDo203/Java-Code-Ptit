import java.util.Scanner;

public class QuayPhai {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			boolean ok = false;
			for(int i = 1; i < n; i++) {
				if(a[i] < a[i-1]) {
					System.out.println(i);
					ok = true;
					break;
				}
			}
			if(!ok) {
				System.out.println(0);
			}
		}
		sc.close();
	}

}
