import java.util.Scanner;

public class DienThoaiCucGach {

	public static char convert(char c) {
		if(c == 'a' || c == 'b' || c == 'c') {
			return '2';
		}
		else if(c == 'd' || c == 'e' || c == 'f') {
			return '3';
		}
		else if(c == 'g' || c == 'h' || c == 'i') {
			return '4';
		}
		else if(c == 'j' || c == 'k' || c == 'l') {
			return '5';
		}
		else if(c == 'm' || c == 'n' || c == 'o') {
			return '6';
		}
		else if(c == 'p' || c == 'q' || c == 'r' || c == 's') {
			return '7';
		}
		else if(c == 't' || c == 'u' || c == 'v') {
			return '8';
		}
		else {
			return '9';
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			String s = sc.next().toLowerCase();
			StringBuffer bf = new StringBuffer();
			for(int i = 0; i < s.length(); i++) {
				bf.append(convert(s.charAt(i)));
			}
			if(bf.toString().equals(bf.reverse().toString())) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		sc.close();
	}

}
