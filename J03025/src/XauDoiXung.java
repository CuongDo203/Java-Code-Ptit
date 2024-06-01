import java.util.Scanner;

public class XauDoiXung {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			String s  =sc.next();
			int l = 0, r = s.length()-1;
			int cnt= 0;
			while(l < r) {
				if(s.charAt(l) != s.charAt(r)) {
					cnt++;
				}
				l++;
				r--;
			}
			if((s.length()%2==0 && cnt == 1) || (s.length()%2==1 && cnt <= 1)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		sc.close();
	}

}

