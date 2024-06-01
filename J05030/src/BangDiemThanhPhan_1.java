import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BangDiemThanhPhan_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<SinhVien> ds = new ArrayList<>();
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n; i++) {
			ds.add(new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), 
					Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
		}
		ds.sort(new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getMa().compareTo(o2.getMa());
			}
		});
		for(int i = 1; i <= n; i++) {
			System.out.println(i+" "+ds.get(i-1));
		}
		sc.close();
	}

}

class SinhVien{
	private String ma, ten, lop;
	private double d1, d2, d3;
	
	public SinhVien(String ma, String ten, String lop, double d1, double d2, double d3) {
		this.ma = ma;
		this.ten = ten;
		this.lop = lop;
		this.d1 = d1;
		this.d2 = d2;
		this.d3 = d3;
	}

	public String getMa() {
		return ma;
	}

	@Override
	public String toString() {
		return ma+" "+ten +" "+lop+" "+d1+" "+d2+" "+d3;
	}
	
	
}