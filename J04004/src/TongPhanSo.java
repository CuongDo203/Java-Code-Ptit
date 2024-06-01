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
	
	public PhanSo add(PhanSo b) {
		PhanSo c = new PhanSo(0, 0);
		long bcnnCuaHaiMau = this.mau / gcd(this.mau, b.mau) * b.mau;
		c.mau = bcnnCuaHaiMau;
		c.tu = bcnnCuaHaiMau/this.mau * this.tu + bcnnCuaHaiMau/b.mau * b.tu;
		c.rutGon();
		return c;
	}
	
	@Override
	public String toString() {
		return tu + "/" + mau;
	}
}

public class TongPhanSo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		long d = sc.nextLong();
		PhanSo ps1 = new PhanSo(a, b);
		PhanSo ps2 = new PhanSo(c, d);
		PhanSo psTong = ps1.add(ps2);
		System.out.println(psTong);
		sc.close();
	}

}
