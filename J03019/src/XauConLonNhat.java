import java.util.Scanner;

public class XauConLonNhat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char c = 'a';
		StringBuilder sb = new StringBuilder();
		for(int i = s.length()-1; i>=0; i--) {
			if(s.charAt(i)>=c) {
				c = s.charAt(i);
				sb.append(s.charAt(i));
			}
		}
		System.out.println(sb.reverse());
		sc.close();
	}

}
