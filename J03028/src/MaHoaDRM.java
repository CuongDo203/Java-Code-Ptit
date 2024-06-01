import java.util.Scanner;

public class MaHoaDRM {

	public static String rotate(String s) {
		String res = "";
		int sum= 0 ;
		for(int i = 0; i < s.length(); i++) {
			sum += (s.charAt(i)-'A');
		}
		for(int i = 0; i < s.length(); i++) {
			res +=  (char)((s.charAt(i)-'A'+sum)%26+'A');
		}
		return res;
	}
	
	public static String merge(String s, String r) {
		String res = "";
		for(int i = 0; i < s.length(); i++) {
			res += (char)((s.charAt(i)-'A' + r.charAt(i)-'A')%26+'A');
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			String s = sc.next();
			int n = s.length();
			String head = s.substring(0, n/2);
			String tail = s.substring(n/2);
			head = rotate(head);
			tail = rotate(tail);
			System.out.println(merge(head, tail));
		}
		sc.close();
	}

}
