import java.util.Scanner;

class GiaoVien{
	private String ma;
	private String ten;
	private long luongCb;
	
	public GiaoVien(String ma, String ten, long luongCb) {
		this.ma = ma;
		this.ten = ten;
		this.luongCb = luongCb;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public long getLuongCb() {
		return luongCb;
	}

	public void setLuongCb(long luongCb) {
		this.luongCb = luongCb;
	}
	
	public long getPhuCap() {
		if(ma.substring(0, 2).equals("HT")) {
			return 2000000;
		}
		else if(ma.substring(0,2).equals("HP")) {
			return 900000;
		}
		else {
			return 500000;
		}
	}
	
	public long getLuong() {
		int heSo = Integer.parseInt(ma.substring(2));
		return luongCb*heSo + getPhuCap();
	}

	@Override
	public String toString() {
		return ma + " " + ten + " " + Integer.parseInt(ma.substring(2)) + " " + getPhuCap() + " " + getLuong();
	}
	
}

public class TinhThuNhapGiaoVien {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ma = sc.nextLine();
		String ten = sc.nextLine();
		long luongCb = sc.nextLong();
		GiaoVien gv = new GiaoVien(ma, ten, luongCb);
		System.out.println(gv);
		sc.close();
	}

}