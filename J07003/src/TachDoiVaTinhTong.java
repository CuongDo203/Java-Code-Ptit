import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class TachDoiVaTinhTong {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("DATA.in"));
		String s = sc.next();
		if(s.length()==1) {
			System.out.println(s);
			return;
		}
		while(s.length() > 1) {
			BigInteger dau = new BigInteger(s.substring(0, s.length()/2));
			BigInteger cuoi = new BigInteger(s.substring(s.length()/2));
			s = dau.add(cuoi).toString();
			System.out.println(s);
		}
		sc.close();
	}
}
