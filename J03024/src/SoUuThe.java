import java.util.Scanner;

public class SoUuThe {

	public static String isOk(String s) {
		if(s.charAt(0) == '0') {
			return "INVALID";
		}
		int odd = 0, even = 0, cnt = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) < '0' || s.charAt(i) > '9') {
				return "INVALID";
			}
			cnt++;
			if((s.charAt(i)-'0')%2==0) {
				even++;
			}
			else {
				odd++;
			}
		}
		System.out.println(cnt + " " + odd + " " + even);
		if(cnt % 2 == 1) {
			if(odd > even) {
				return "YES";
			}
			else {
				return "NO";
			}
		}
		else {
			if(even > odd) {
				return "YES";
			}
			else {
				return "NO";
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			String s = sc.next();
			System.out.println(isOk(s));
		}
		sc.close();
	}

}
