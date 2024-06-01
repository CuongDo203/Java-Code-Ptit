import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DanhSachThucTap_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<SinhVien> ds = new ArrayList<>();
		while(t-->0) {
			String ma = sc.nextLine();
			String ten = sc.nextLine();
			String lop = sc.nextLine();
			String email = sc.nextLine();
			String dn = sc.nextLine();
			ds.add(new SinhVien(ma, ten, lop, email, dn));
		}
		ds.sort(new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getMa().compareTo(o2.getMa());
			}
		});
		int q = Integer.parseInt(sc.nextLine());
		while(q-->0) {
			String dn = sc.nextLine();
			for(SinhVien sv : ds) {
				if(sv.getDoanhNghiep().equalsIgnoreCase(dn)) {
					System.out.println(sv);
				}
			}
		}
		sc.close();
	}

}

class SinhVien{
	private static int STT = 1;
	private int stt;
	private String ma, ten, lop, email, doanhNghiep;
	
	public SinhVien(String ma, String ten, String lop, String email, String doanhNghiep) {
		this.stt = STT++;
		this.ma = ma;
		this.ten = ten;
		this.lop = lop;
		this.email = email;
		this.doanhNghiep = doanhNghiep;
	}

	public String getMa() {
		return ma;
	}

	public String getTen() {
		return ten;
	}

	public String getDoanhNghiep() {
		return doanhNghiep;
	}

	@Override
	public String toString() {
		return stt+" "+ ma +" "+ten+" "+lop+ " "+email+" "+doanhNghiep;
	}
	
}