import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DanhSachDoiTuongSinhVien_1 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while(t-->0) {
			String ten = sc.nextLine();
			String lop = sc.nextLine();
			String ns = sc.nextLine();
			float gpa = Float.parseFloat(sc.nextLine());
			System.out.println(new SinhVien(ten, lop, ns, gpa));
		}
		sc.close();
	}

}

class SinhVien{
	private String ma, ten, lop, ngaySinh;
	private float gpa;
	private static int STT = 1;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public SinhVien() {
		this.ma = this.ten = this.lop = this.ngaySinh = "";
		this.gpa = 0;
	}

	public SinhVien(String ten, String lop, String ngaySinh, float gpa){
		this.ma = String.format("B20DCCN%03d", STT++);
		this.ten = ten;
		this.lop = lop;
		this.ngaySinh = chuanHoaNgaySinh(ngaySinh);
		this.gpa = gpa;
	}
	 
	private String chuanHoaNgaySinh(String s) {
		if(s.charAt(1) == '/') {
			s = "0" + s.substring(0);
		}
		if(s.charAt(4) == '/') {
			s = s.substring(0,3) + "0" + s.substring(3);
		}
		return s;
	}
	
	public String toString() {
		return this.ma + " " + this.ten +" "+ this.lop + " "+ this.ngaySinh+" "+String.format("%.2f", this.gpa);
	}
}
