import java.util.Scanner;

public class MaTranNhiPhan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		for(int i = 0; i < n; i++) {
			int cnt = 0;
			for(int j = 0; j < 3; j++) {
				cnt += sc.nextInt();
			}
			if(cnt>1) {
				ans++;
			}
		}
		System.out.println(ans);
		sc.close();
	}

}
