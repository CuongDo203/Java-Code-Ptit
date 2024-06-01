import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class SinhVien{
	private String ten;
	private String ma;
	private String lop;
	private String ngaySinh;
	private float gpa;
	
	private String chuanHoaNgaySinh(String s) {
		if(s.charAt(1) == '/') {
			s = "0" + s.substring(0);
		}
		if(s.charAt(4) == '/') {
			s = s.substring(0,3) + "0" + s.substring(3);
		}
		return s;
	}
	
	public SinhVien(String ten, String ma, String lop, String ngaySinh, float gpa) {
		this.ten = ten;
		while(ma.length() < 3) {
			ma = "0" + ma;
		}
		this.ma = "B20DCCN" + ma;
		this.lop = lop;
		this.ngaySinh = chuanHoaNgaySinh(ngaySinh);
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return ma +" "+ ten +" "+lop+" "+ngaySinh+" "+String.format("%.2f", gpa);
	}
		
}

public class DanhSachSinhVienTrongFile_2 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("SV.in"));
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 1; i <= n; i++) {
			String ten = sc.nextLine();
			String lop = sc.nextLine();
			String ns = sc.nextLine(); 
			float gpa = Float.parseFloat(sc.nextLine());
			SinhVien sv = new SinhVien(ten, i+"", lop, ns, gpa);
			System.out.println(sv);
		}
		sc.close();
	}

}