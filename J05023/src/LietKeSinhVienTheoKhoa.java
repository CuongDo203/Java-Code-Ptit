import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LietKeSinhVienTheoKhoa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<SinhVien> ds = new ArrayList<>();
		while(t-->0) {
			ds.add(new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
		}
		int q = Integer.parseInt(sc.nextLine());
		while(q-->0) {
			String nam = sc.nextLine();
			System.out.println("DANH SACH SINH VIEN KHOA "+nam+":");
			for(SinhVien sv : ds) {
				if(sv.getKhoa().equals(nam.substring(2))) {
					System.out.println(sv);
				}
			}
		}
		sc.close();
	}

}

class SinhVien{
	private String ma, ten, lop, email;

	public SinhVien(String ma, String ten, String lop, String email) {
		this.ma = ma;
		this.ten = ten;
		this.lop = lop;
		this.email = email;
	}
	
	public String getMa() {
		return ma;
	}
	
	public String getLop() {
		return lop;
	}
	
	public String getKhoa() {
		return this.lop.substring(1, 3);
	}
	
	@Override
	public String toString() {
		return ma+" "+ten+" "+lop+" "+email;
	}
	
}