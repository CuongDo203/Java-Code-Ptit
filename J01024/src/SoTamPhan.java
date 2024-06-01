import java.util.Scanner;

public class SoTamPhan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int  t = sc.nextInt();
		while(t-- > 0) {
			String s = sc.next();
			boolean ok = true;
			for(int i = 0; i < s.length(); i++) {
				if(!(s.charAt(i) == '0' || s.charAt(i) == '1' || s.charAt(i)=='2')) {
					ok = false;
					break;
				}
			}
			if(ok) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		sc.close();
	}

}
