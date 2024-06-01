import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class XauDayDu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			String s = sc.next();
			Set<Character> se = new HashSet<>();
			int k = sc.nextInt();
			if(s.length()<26) {
				System.out.println("NO");
			}
			else {
				for(int i = 0; i < s.length(); i++) {
					se.add(s.charAt(i));
				}
				if(26-se.size()<=k) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
			
		}
		sc.close();
	}

}
