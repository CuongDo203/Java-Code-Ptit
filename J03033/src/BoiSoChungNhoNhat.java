import java.math.BigInteger;
import java.util.Scanner;

public class BoiSoChungNhoNhat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			BigInteger a = new BigInteger(sc.next());
			BigInteger b = new BigInteger(sc.next());
			BigInteger lcm = a.multiply(b).divide(a.gcd(b));
			System.out.println(lcm);
		}
	}

}
