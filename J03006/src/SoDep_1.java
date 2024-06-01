import java.util.Scanner;

public class SoDep_1 {

	public static boolean isOK(String s) {
		char res[] = s.toCharArray();
		int l = 0, r = s.length()-1;
		while(l <= r) {
			if(res[l] != res[r]) {
				return false;
			}
			if((res[l]-'0')%2==1) {
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
			if(isOK(s)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		sc.close();
	}

}
