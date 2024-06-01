import java.util.Scanner;

public class CatDoi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			String s = sc.next();
			int ok = 0;
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '1') {
					ok = 1;
				}
				else if(!(s.charAt(i) == '0' || s.charAt(i)=='8'||s.charAt(i)=='9')){
					ok = 0;
					break;
				}
			}
			if(ok==0) {
				System.out.println("INVALID");
			}
			else {
				String res  = "";
				for(int i = 0; i < s.length(); i++) {
					if(s.charAt(i)=='1') {
						res += '1';
						ok = 1;
					}
					else if(ok!=0) {
						res += '0';
					}
				}
				if(!res.isEmpty()) {
					long ans = Long.parseLong(res);
					System.out.print(ans);
				}
			}
			System.out.println();
		}
		sc.close();
	}

}
