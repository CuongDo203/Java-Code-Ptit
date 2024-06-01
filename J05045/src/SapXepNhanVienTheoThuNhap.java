import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SapXepNhanVienTheoThuNhap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<NhanVien> ds = new ArrayList<>();
		while(t-->0) {
			ds.add(new NhanVien(sc.nextLine(), sc.nextLine(),
					Double.parseDouble(sc.nextLine()), Integer.parseInt(sc.nextLine())));
		}
		ds.sort(new Comparator<NhanVien>() {
			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				if(o1.getThucLinh()==o2.getThucLinh()) {
					return o1.getMa().compareTo(o2.getMa());
				}
				return Double.compare(o2.getThucLinh(), o1.getThucLinh());
			}
		});
		for(NhanVien nv : ds) {
			System.out.println(nv);
		}
		sc.close();
	}

}

class NhanVien{
	private String ma, ten, chucVu;
	private double luongCb;
	private int soNgayCong;
	private static int STT = 1;
	DecimalFormat df = new DecimalFormat("##.##");
	
	public NhanVien(String ten,String chucVu, double luongCb, int soNgayCong) {
		this.ma = "NV"+String.format("%02d", STT++);
		this.ten = ten;
		this.chucVu = chucVu;
		this.luongCb = luongCb;
		this.soNgayCong = soNgayCong;
	}
	
	public String getMa() {
		return ma;
	}

	public double getPhuCap() {
		if(this.chucVu.equals("GD")) {
			return 500;
		}
		else if(this.chucVu.equals("PGD")) {
			return 400;
		}
		else if(this.chucVu.equals("TP")) {
			return 300;
		}
		else if(this.chucVu.equals("KT")) {
			return 250;
		}
		else {
			return 100;
		}
	}
	
	public double getLuongThang() {
		return this.luongCb*this.soNgayCong;
	}
	
	public double getThucLinh() {
		return getLuongThang()+getPhuCap();
	}
	
	public double getTamUng() {
		if((getPhuCap()+getLuongThang())*2/3 < 25000) {
			return Math.round((getPhuCap()+getLuongThang())*2/3/1000)*1000;
		}
		else {
			return 25000;
		}
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	@Override
	public String toString() {
		return ma+" "+ten+" "+df.format(getPhuCap())+" "+df.format(getLuongThang())+" "
	+df.format(getTamUng())+" "+df.format((getLuongThang()-getTamUng()+getPhuCap()));
	}
	
}