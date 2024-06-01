import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DanhSachDoanhNghiepNhanSinhVienThucTap_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<DoanhNghiep> ds = new ArrayList<>();
		while(t-->0) {
			ds.add(new DoanhNghiep(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
		}
		ds.sort(new Comparator<DoanhNghiep>() {

			@Override
			public int compare(DoanhNghiep o1, DoanhNghiep o2) {
				if(o1.getSoSinhVien()==o2.getSoSinhVien()) {
					return o1.getMa().compareTo(o2.getMa());
				}
				return o2.getSoSinhVien()-o1.getSoSinhVien();
			}
		});
		int q = sc.nextInt();
		while(q-->0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println("DANH SACH DOANH NGHIEP NHAN TU "+a+" DEN "+b+" SINH VIEN:");
			for(DoanhNghiep dn : ds) {
				if(dn.getSoSinhVien()>=a && dn.getSoSinhVien()<=b) {
					System.out.println(dn);
				}
			}
		}
		sc.close();
	}

}

class DoanhNghiep{
	private String ma, ten;
	private int soSinhVien;
	
	public DoanhNghiep(String ma, String ten, int soSinhVien) {
		this.ma = ma;
		this.ten = ten;
		this.soSinhVien = soSinhVien;
	}

	public int getSoSinhVien() {
		return soSinhVien;
	}

	public String getMa() {
		return ma;
	}

	@Override
	public String toString() {
		return ma + " "+ten+" "+soSinhVien;
	}
	
	
}