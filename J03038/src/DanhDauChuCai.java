import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DanhDauChuCai {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		Set<Character> se = new HashSet<Character>();
		for(int i = 0; i < s.length(); i++) {
			se.add(s.charAt(i));
		}
		System.out.println(se.size());
		sc.close();
	}

}
