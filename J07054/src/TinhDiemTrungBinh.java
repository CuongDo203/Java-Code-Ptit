import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TinhDiemTrungBinh {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		List<SinhVien> dssv = new ArrayList<>();
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 1; i <= n; i++) {
			String ten = sc.nextLine();
			int diem1= Integer.parseInt(sc.nextLine());
			int diem2 = Integer.parseInt(sc.nextLine());
			int diem3 = Integer.parseInt(sc.nextLine());
			dssv.add(new SinhVien(i+"", ten, diem1, diem2, diem3));
		}
		dssv.sort(new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				if(o1.getDiemTb()==o2.getDiemTb()) {
					return o1.getMa().compareTo(o2.getMa());
				}
				return o1.getDiemTb() < o2.getDiemTb() ? 1 : -1;
			}
		});
		dssv.get(0).setXepHang(1);
		System.out.println(dssv.get(0));
		for(int i = 1; i < dssv.size(); i++) {
			if(dssv.get(i).getDiemTb() == dssv.get(i-1).getDiemTb()) {
				dssv.get(i).setXepHang(dssv.get(i-1).getXepHang());
			}
			else {
				dssv.get(i).setXepHang(i+1);
			}
			System.out.println(dssv.get(i));
		}
		sc.close();
	}

}


class SinhVien{
	private String ten, ma;
	private int diem1, diem2, diem3, xepHang;
	
	public SinhVien(String ma, String ten, int diem1, int diem2, int diem3) {
		while(ma.length() < 2) {
			ma = "0" + ma;
		}
		this.ma = "SV"+ma;
		this.ten = chuanHoaTen(ten);
		this.diem1 = diem1;
		this.diem2 = diem2;
		this.diem3 = diem3;
	}
	
	public String getMa() {
		return ma;
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
	
	public void setXepHang(int xepHang) {
		this.xepHang = xepHang;
	}
	
	public int getXepHang() {
		return xepHang;
	}

	public float getDiemTb() {
		return 1f*(diem1*3 + diem2*3 + diem3*2)/8; 
	}

	@Override
	public String toString() {
		return ma + " " + ten + " " + String.format("%.2f", getDiemTb()) + " "+ xepHang;
	}
	
}