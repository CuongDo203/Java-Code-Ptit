import java.text.DecimalFormat;
import java.util.Scanner;

public class GiaiPhuongTrinhBacNhat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Float a, b;
		a = sc.nextFloat();
		b = sc.nextFloat();
		if(a==0) {
			if(b!=0) {
				System.out.println("VN");
			}
			else {
				System.out.println("VSN");
			}
		}
		else {
			Float ans = -b/a;
			DecimalFormat dc = new DecimalFormat("0.00");
			System.out.println(dc.format(ans));
		}
	}

}
