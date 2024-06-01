import java.util.Scanner;

public class TinhToanPhanSo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			PhanSo a = new PhanSo(sc.nextLong(), sc.nextLong());
			PhanSo b = new PhanSo(sc.nextLong(), sc.nextLong());
			PhanSo c = a.add(b);
			c = c.mul(c);
			c.rutGon();
			PhanSo d = a.mul(b).mul(c);
			System.out.println(c + " " + d);
		}
		sc.close();
	}

}

class PhanSo{
	private long tu, mau;

	public PhanSo(long tu, long mau) {
		this.tu = tu;
		this.mau = mau;
		rutGon();
	}
	
	static long gcd(long a, long b) {
		if(b==0) return a;
		return gcd(b, a%b);
	}
	
	public PhanSo mul(PhanSo p) {
		long t = this.tu * p.tu;
		long m = this.mau * p.mau;
		return new PhanSo(t, m);
	}
	
	public void rutGon() {
		long tmp = gcd(this.tu, this.mau);
		this.tu /= tmp;
		this.mau /= tmp;
	}
	
	public PhanSo add(PhanSo p) {
		long t = this.tu*p.mau + p.tu*this.mau;
		long m = this.mau * p.mau;
		return new PhanSo(t, m);
	}

	@Override
	public String toString() {
		return this.tu + "/" + this.mau;
	}
	
}