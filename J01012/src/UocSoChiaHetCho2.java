import java.util.Scanner;

public class UocSoChiaHetCho2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			long cnt=0;
			for(int i = 1; i*i <= n; i++) {
				if(n%i==0) {
					if(i!=n/i) {
						if(i%2==0) {
							cnt++;
						}
						if((n/i)%2==0) {
							cnt++;
						}
					}
					else {
						if(i%2==0) {
							cnt++;
						}
					}
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}

}
