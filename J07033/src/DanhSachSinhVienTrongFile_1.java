import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class SinhVien{
	private String maSv, hoTen, lop, email;

	public SinhVien(String maSv, String hoTen, String lop, String email) {
		this.maSv = maSv;
		this.hoTen = chuanHoaTen(hoTen);
		this.lop = lop;
		this.email = email;
	}
	
	private String chuanHoaTen(String s) {
		String res = "";
		String word[] = s.trim().split("\\s+");
		for(String x : word) {
			res += x.substring(0,1).toUpperCase() + x.substring(1).toLowerCase() + " ";
		}
		res = res.substring(0,res.length()-1);
		return res;
	}

	public String toString() {
		return maSv + " " + hoTen + " " + lop + " " + email;
	}

	public String getMaSv() {
		return maSv;
	}

	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}
	
	
}

public class DanhSachSinhVienTrongFile_1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("SINHVIEN.in"));
		int t = Integer.parseInt(sc.nextLine());
		List<SinhVien> dssv = new ArrayList<>();
		for(int i = 1; i <= t; i++) {
			String ma = sc.nextLine();
			String ten = sc.nextLine();
			String lop = sc.nextLine();
			String email = sc.nextLine();
			SinhVien sv = new SinhVien(ma, ten, lop, email);
			dssv.add(sv);
		}
		dssv.sort(new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getMaSv().compareTo(o2.getMaSv());
			}
		});
		for(SinhVien x : dssv) {
			System.out.println(x);
		}
		sc.close();
	}

}
