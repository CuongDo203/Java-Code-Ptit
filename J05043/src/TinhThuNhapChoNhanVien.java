import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TinhThuNhapChoNhanVien {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<NhanVien> ds = new ArrayList<>();
		while(t-->0) {
			String ten = sc.nextLine();
			String cv = sc.nextLine();
			double luongCb = Double.parseDouble(sc.nextLine());
			int soNgayCong = Integer.parseInt(sc.nextLine());
			ds.add(new NhanVien(ten, cv, luongCb, soNgayCong));
		}
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
	DecimalFormat df = new DecimalFormat("##.#");
	
	public NhanVien(String ten, String chucVu, double luongCb, int soNgayCong) {
		this.ma = "NV"+String.format("%02d", STT++);
		this.ten = ten;
		this.chucVu = chucVu;
		this.luongCb = luongCb;
		this.soNgayCong = soNgayCong;
	}
	
	public int getPhuCap() {
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
	
	public double getLuongChinh() {
		return this.luongCb*this.soNgayCong;
	}
	
	public double getTamUng() {
		if((getLuongChinh()+ getPhuCap())*2/3<25000) {
			return Math.round((getLuongChinh()+ getPhuCap())*2/3/1000)*1000;
		}
		else {
			return 25000;
		}
	}
	
	public double getTienConLai() {
		return getLuongChinh()+ getPhuCap()-getTamUng();
	}

	@Override
	public String toString() {
		return ma+" "+ten+" "+df.format(getPhuCap())
				+" "+df.format(getLuongChinh())+" "+df.format(getTamUng())+" "+df.format(getTienConLai());
	}
	
}