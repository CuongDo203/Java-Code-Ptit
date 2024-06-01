import java.util.Scanner;

public class DiemCanBang {
	
	public static long pre[] = new long[100005];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int a[] = new int[n+1];
			//Arrays.fill(pre, 0);
			for(int i = 1; i <= n; i++) {
				a[i] = sc.nextInt();
				if(i == 1) {
					pre[i] = a[i];
				}
				else {
					pre[i] = pre[i-1] + a[i];
				}
			}
			boolean ok = false;
			for(int i = 1; i <= n; i++) {
				if(pre[i-1] == pre[n] - pre[i]) {
					System.out.println(i);
					ok = true;
					break;
				}
			}
			if(!ok)
				System.out.println("-1");
		}
		sc.close();
	}

}
