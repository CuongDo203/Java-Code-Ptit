import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LietKeSinhVienTheoNganh {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<SinhVien> ds = new ArrayList<>();
		int t = Integer.parseInt(sc.nextLine());
		while(t-->0) {
			ds.add(new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
		}
		int q = Integer.parseInt(sc.nextLine());
		while(q-->0) {
			String nganh = sc.nextLine();
			nganh = nganh.toUpperCase();
			System.out.println("DANH SACH SINH VIEN NGANH "+nganh+":");
			for(SinhVien sv : ds) {
				if(sv.getNganh().equals(nganh)) {
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
	
	public String getNganh() {
		if(this.ma.substring(3, 7).equals("DCDT")) {
			return "DIEN TU";
		}
		else if(this.ma.substring(3,7).equals("DCVT")) {
			return "VIEN THONG";
		}
		else if(this.ma.substring(3,7).equals("DCKT")) {
			return "KE TOAN";
		}
		else if(this.ma.substring(3,7).equals("DCAT")) {
			if(!this.lop.substring(0,1).equals("E")) {
				return "AN TOAN THONG TIN";
			}
			else {
				return "";
			}
		}
		else {
			if(!this.lop.substring(0,1).equals("E")) {
				return "CONG NGHE THONG TIN";
			}
			else {
				return "";
			}
		}
	}
	
	@Override
	public String toString() {
		return ma+" "+ten+" "+lop+" "+email;
	}
	
}