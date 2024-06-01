import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class XepLoai {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("BANGDIEM.in"));
		int n = Integer.parseInt(sc.nextLine());
		List<SinhVien> dssv = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			String ten = sc.nextLine();
			int d1 = Integer.parseInt(sc.nextLine());
			int d2 = Integer.parseInt(sc.nextLine());
			int d3 = Integer.parseInt(sc.nextLine());
			dssv.add(new SinhVien(i+"", ten, d1, d2, d3));
		}
		dssv.sort(new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getDiemTb() < o2.getDiemTb() ? 1 : -1;
			}
		});
		for(SinhVien sv : dssv) {
			System.out.println(sv);
		}
		sc.close();
	}

}

class SinhVien{
	private String ma, ten;
	private int diem1, diem2, diem3;
	
	public SinhVien(String ma, String ten, int diem1, int diem2, int diem3) {
		while(ma.length() < 2) {
			ma = "0"+ma;
		}
		this.ma = "SV"+ma;
		this.ten = chuanHoaTen(ten);
		this.diem1 = diem1;
		this.diem2 = diem2;
		this.diem3 = diem3;
	}
	
	private String chuanHoaTen(String s) {
		String w[] = s.trim().split("\\s+");
		String res = "";
		for(String x : w) {
			res += x.substring(0,1).toUpperCase() + x.substring(1).toLowerCase() + " ";
		}
		res = res.substring(0, res.length()-1);
		return res;
	}
	
	public double getDiemTb() {
		return (double) (diem1*0.25 + diem2*0.35 + diem3*0.4);
	}
	
	public String getXepLoai() {
		if(getDiemTb() < 5) {
			return "KEM";
		}
		else if(getDiemTb() < 6.5) {
			return "TRUNG BINH";
		}
		else if(getDiemTb() < 8) {
			return "KHA";
		}
		else {
			return "GIOI";
		}
	}

	@Override
	public String toString() {
		return ma + " " + ten + " " + String.format("%.2f", getDiemTb()) + " " + getXepLoai();
	}
	
	
}