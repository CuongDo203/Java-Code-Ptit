import java.math.BigInteger;
import java.util.Scanner;

public class HieuSoNguyenLon_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger a = new BigInteger(sc.next());
		BigInteger b = new BigInteger(sc.next());
		System.out.println(a.subtract(b));
		sc.close();
	}

}
