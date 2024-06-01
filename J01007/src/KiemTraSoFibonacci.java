import java.util.Scanner;

public class KiemTraSoFibonacci {

static Long fb[] = new Long[95];
	
	public static void init() {
		fb[0] = 0l;
		fb[1] = 1l;
		fb[2] = 1l;
		for(int i = 3; i <= 92; i++) {
			fb[i] = fb[i-1]+fb[i-2];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		init();
		int t = sc.nextInt();
		while(t-- > 0) {
			long n = sc.nextLong();
			boolean ok = false;
			for(int i = 0; i <= 92; i++) {
				if(n == fb[i]) {
					ok = true;
					break;
				}
			}
			if(ok) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}

}
