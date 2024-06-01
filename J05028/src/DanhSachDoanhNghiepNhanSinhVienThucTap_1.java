import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DanhSachDoanhNghiepNhanSinhVienThucTap_1 {

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
				if(o1.getSoSv()==o2.getSoSv()) {
					return o1.getMa().compareTo(o2.getMa());
				}
				return o2.getSoSv()-o1.getSoSv();
			}
		});
		for(DoanhNghiep dn : ds) {
			System.out.println(dn);
		}
		sc.close();
	}

}

class DoanhNghiep{
	private String ma, ten;
	private int SoSv;
	
	public DoanhNghiep(String ma, String ten, int soSv) {
		this.ma = ma;
		this.ten = ten;
		SoSv = soSv;
	}

	public String getMa() {
		return ma;
	}

	public int getSoSv() {
		return SoSv;
	}

	@Override
	public String toString() {
		return ma +" "+ten+" "+SoSv;
	}
	
}