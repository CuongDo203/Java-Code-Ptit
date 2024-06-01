import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SapXepDanhSachDoiTuongNhanVien {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<NhanVien> dsnv = new ArrayList<>();
		int t = Integer.parseInt(sc.nextLine());
		while(t-->0) {
			NhanVien nv = new NhanVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
			dsnv.add(nv);
		}
		dsnv.sort(new Comparator<NhanVien>() {
			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				String ns1 = o1.getNgaySinh();
				int nam1 = Integer.parseInt(ns1.substring(ns1.lastIndexOf('/')+1));
				int thang1 = Integer.parseInt(ns1.substring(3, 5));
				int ngay1 = Integer.parseInt(ns1.substring(0,2));
				String ns2 = o2.getNgaySinh();
				int nam2 = Integer.parseInt(ns2.substring(ns2.lastIndexOf('/')+1));
				int thang2 = Integer.parseInt(ns2.substring(3,5));
				int ngay2 = Integer.parseInt(ns2.substring(0,2));
				if(nam1 == nam2) {
					if(thang1==thang2) {
						return ngay1-ngay2;
					}
					else {
						return thang1 - thang2;
					}
				}
				else {
					return nam1 - nam2;
				}
			}
		});
		for(NhanVien nv : dsnv) {
			System.out.println(nv);
		}
		sc.close();
	}

}

class NhanVien{
	private String ma, ten, gt, ngaySinh, diaChi, mst, ngayKyHd;
	private static int STT=1;
	
	public NhanVien(String ten, String gt, String ngaySinh, String diaChi, String mst, String ngayKyHd) {
		this.ma = String.format("%05d", STT++);
		this.ten = ten;
		this.gt = gt;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.mst = mst;
		this.ngayKyHd = ngayKyHd;
	}
	
	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	@Override
	public String toString() {
		return ma + " " + ten + " "+ gt+" "+ngaySinh+
				" "+diaChi+" "+mst+" "+ ngayKyHd;
	}
	
	
}