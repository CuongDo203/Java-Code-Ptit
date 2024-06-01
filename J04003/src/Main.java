import java.util.Scanner;

class PhanSo{
	private long tu, mau;

	public PhanSo(long tu, long mau) {
		this.tu = tu;
		this.mau = mau;
	}
	
	static long gcd(long a, long b) {
		if(b==0)
			return a;
		return gcd(b,a%b);
	}
	
	public void rutGon() {
		long ucln = gcd(this.tu, this.mau);
		this.tu = this.tu/ucln;
		this.mau = this.mau/ucln;
	}

	@Override
	public String toString() {
		return tu + "/" + mau;
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		PhanSo ps = new PhanSo(a, b);
		ps.rutGon();
		System.out.println(ps);
		sc.close();
	}

}
