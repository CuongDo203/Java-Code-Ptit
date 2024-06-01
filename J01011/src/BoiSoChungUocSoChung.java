import java.util.Scanner;

public class BoiSoChungUocSoChung {

	public static long gcd(int a, int b) {
		if(b==0) return a;
		else return gcd(b, a%b);
	}
	
	public static long lcm(int a, int b) {
		return a/gcd(a,b)*b;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(lcm(a,b)+" " +gcd(a,b));
		}
		sc.close();
	}

}
