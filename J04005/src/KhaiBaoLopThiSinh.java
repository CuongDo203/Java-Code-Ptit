import java.util.Scanner;

class ThiSinh{
	private String hoTen;
	private String ngaySinh;
	private double diem1, diem2, diem3;
	
	public ThiSinh(String hoTen, String ngaySinh, double diem1, double diem2, double diem3) {
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.diem1 = diem1;
		this.diem2 = diem2;
		this.diem3 = diem3;
	}
	
	public double getTongDiem() {
		return this.diem1 + this.diem2 + this.diem3;
	}

	@Override
	public String toString() {
		return String.format("%s %s %.1f", hoTen, ngaySinh, getTongDiem());
	}
	
}

public class KhaiBaoLopThiSinh {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		String dob = sc.nextLine();
		double d1 = sc.nextDouble();
		double d2 = sc.nextDouble();
		double d3 = sc.nextDouble();
		ThiSinh ts = new ThiSinh(name, dob, d1, d2, d3);
		System.out.println(ts);
		sc.close();
	}

}
