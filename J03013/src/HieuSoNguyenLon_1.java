import java.math.BigInteger;
import java.util.Scanner;

public class HieuSoNguyenLon_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			BigInteger a = new BigInteger(sc.next());
			BigInteger b = new BigInteger(sc.next());
			BigInteger c = a.subtract(b).abs();
			int maxLen = Math.max(a.toString().length(), b.toString().length());
			StringBuffer bf = new StringBuffer(c.toString());
			while(bf.length() < maxLen) {
				bf.insert(0, '0');
			}
			System.out.println(bf.toString());
		}
		sc.close();
	}

}
