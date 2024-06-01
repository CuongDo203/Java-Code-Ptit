import java.util.Scanner;

public class SoDep_3 {

	public static boolean isPrimeDigit(int n) {
		return n == 2 || n == 5 || n == 7 || n == 3;
	}
	
	public static boolean isOk(String s) {
		char res[] = s.toCharArray();
		for(int i = 0; i < s.length(); i++) {
			if(!isPrimeDigit(res[i]-'0')) {
				return false;
			}
		}
		int l = 0, r = s.length()-1;
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
