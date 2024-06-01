import java.util.Scanner;

public class HinhSao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ke[] = new int[n+2];
		for(int i = 1; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			ke[x]++;
			ke[y]++;
		}
		boolean ok = false;
		for(int i = 1; i <= n; i++) {
			if(ke[i] == n-1) {
				ok = true;
				break;
			}
		}
		System.out.println(ok ? "Yes" : "No");
		sc.close();
	}

}
