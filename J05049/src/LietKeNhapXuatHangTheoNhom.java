import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LietKeNhapXuatHangTheoNhom {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<HangNongSan> ds = new ArrayList<>();
		while(t-->0) {
			ds.add(new HangNongSan(sc.nextLine(),Long.parseLong(sc.nextLine())));
		}
		String s = sc.nextLine();
		ds.sort(new Comparator<HangNongSan>() {
			@Override
			public int compare(HangNongSan o1, HangNongSan o2) {
				return Double.compare(o2.getThue(), o1.getThue());
			}
		});
		for(HangNongSan hns : ds) {
			if(hns.getMa().startsWith(s))
				System.out.println(hns);
		}
		sc.close();
	}

}

class HangNongSan{
	private String ma;
	private long soLuongNhap;
	DecimalFormat df = new DecimalFormat("##.##");
	
	public HangNongSan(String ma, long soLuongNhap) {
		this.ma = ma;
		this.soLuongNhap = soLuongNhap;
	}
	
	public String getMa() {
		return ma;
	}

	public long getSoLuongXuat() {
		if(this.ma.startsWith("A")) {
			return Math.round(this.soLuongNhap*60/100.0);
		}
		else if(this.ma.startsWith("B"))
			return Math.round(this.soLuongNhap*70/100.0);
		else
			return 0;
	}
	
	public long getDonGia() {
		if(this.ma.endsWith("Y")) {
			return 110000;
		}
		else
			return 135000;
	}
	
	public double getTien() {
		return getSoLuongXuat()*getDonGia();
	}
	
	public double getThue() {
		if(this.ma.startsWith("A")) {
			if(this.ma.endsWith("Y")) {
				return getTien()*8/100;
			}
			else {
				return getTien()*11/100;
			}
		}
		else {
			if(this.ma.endsWith("Y")) {
				return getTien()*17/100;
			}
			else {
				return getTien()*22/100;
			}
		}
	}

	@Override
	public String toString() {
		return ma+" "+soLuongNhap+" "+getSoLuongXuat()+" "+df.format(getDonGia())+" "
				+df.format(getTien())+" "+df.format(getThue());
	}
	
}