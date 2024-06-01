import java.util.Scanner;

public class SoKhongLienKe {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			String s = sc.next();
			long sum = s.charAt(0)-'0';
			boolean ok = true;
			for(int i = 1; i < s.length(); i++) {
				if(Math.abs(s.charAt(i)-s.charAt(i-1))!=2) {
					ok = false;
					break;
				}
				sum += (s.charAt(i)-'0');
			}
//			System.out.println(sum);
			if(ok) {
				if(sum%10==0) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
			else {
				System.out.println("NO");
			}
		}
	}
}
