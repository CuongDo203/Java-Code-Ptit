import java.util.Scanner;

public class SoDep_2 {

	public static boolean isOk(String s) {
		char res[] = s.toCharArray();
		if(res[0] != res[res.length - 1]) {
			return false;
		}
		if(res[0] == res[res.length-1] && res[0] != '8') {
			return false;
		}
		int sum = 0;
		for(int i = 0; i < res.length; i++) {
			sum += (res[i]-'0');
		}
		if(sum % 10 != 0) {
			return false;
		}
		int l = 1, r = s.length()-2;
		while(l <= r) {
			if(res[l] != res[r]) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			String s = sc.next();
			if(isOk(s)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		sc.close();
	}

}
