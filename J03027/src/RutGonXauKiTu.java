import java.util.Scanner;

public class RutGonXauKiTu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		while(true) {
			boolean ok = true;
			for(int i = 0; i < s.length()-1; i++) {
				if(s.charAt(i) == s.charAt(i+1)) {
					s = s.substring(0,i) + s.substring(i+2);
					ok = false;
					break;
				}
			}
			if(ok) {
				break;
			}
		}
		if(s.isEmpty()) {
			System.out.println("Empty String");
		}
		else {
			System.out.println(s);
		}
	}

}
