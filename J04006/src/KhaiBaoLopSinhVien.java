import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class SinhVien{
	private String maSv, hoTen, lop, ngaySinh;
	private float gpa;
	
	public SinhVien() {
		maSv = hoTen = lop = ngaySinh = "";
		gpa = 0;
	}

	String chuanHoaNgaySinh(String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date date = sdf.parse(s);
			return sdf.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public SinhVien(String hoTen, String lop, String ngaySinh, float gpa) {
		this.maSv = "B20DCCN001";
		this.hoTen = hoTen;
		this.lop = lop;
		this.ngaySinh = chuanHoaNgaySinh(ngaySinh); 
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s %.2f", maSv, hoTen, lop, ngaySinh, gpa);
	}
	
	
}

public class KhaiBaoLopSinhVien {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		String lop = sc.nextLine();
		String ns = sc.nextLine();
		float gpa = sc.nextFloat();
		SinhVien sv = new SinhVien(name, lop, ns, gpa);
		System.out.println(sv);
		sc.close();
	}
}