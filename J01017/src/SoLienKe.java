import java.util.Scanner;

public class SoLienKe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			String s = sc.next();
			boolean ok = true;
			for(int i = 1; i < s.length(); i++) {
//				System.out.println((s.charAt(i)-'0') - (s.charAt(i-1)-'0'));
				if(Math.abs((s.charAt(i)-'0') - (s.charAt(i-1)-'0')) != 1) {
					ok = false;
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
		sc.close();
	}
}
