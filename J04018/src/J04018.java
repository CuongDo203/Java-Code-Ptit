import java.util.Scanner;

public class J04018 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			SoPhuc a = new SoPhuc(sc.nextInt(), sc.nextInt());
			SoPhuc b = new SoPhuc(sc.nextInt(), sc.nextInt());
			SoPhuc c = a.add(b);
			SoPhuc d = c.mul(a);
			SoPhuc e = c.mul(c);
			System.out.println(d + ", " + e);
		}
		sc.close();
	}

}

class SoPhuc{
	private int thuc, ao;

	public SoPhuc(int thuc, int ao) {
		this.thuc = thuc;
		this.ao = ao;
	}
	
	public SoPhuc add(SoPhuc o) {
		int t = this.thuc + o.thuc;
		int a = this.ao + o.ao;
		return new SoPhuc(t, a);
	}
	
	public SoPhuc mul(SoPhuc o) {
		int t = this.thuc*o.thuc - this.ao*o.ao;
		int a = this.thuc*o.ao + this.ao*o.thuc;
		return new SoPhuc(t, a);
	}
	
	@Override
	public String toString() {
		int dau = 0;
		if(this.ao<0) dau = 1;
		return this.thuc + (dau==1 ? " - " : " + ") + Math.abs(this.ao)+"i";
	}
}