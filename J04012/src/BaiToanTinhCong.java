import java.util.Scanner;

public class BaiToanTinhCong {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ten = sc.nextLine();
		int luongCb = Integer.parseInt(sc.nextLine());
		int soNgayCong = Integer.parseInt(sc.nextLine());
		String chucVu = sc.nextLine();
		NhanVien nv = new NhanVien(ten, luongCb, soNgayCong, chucVu);
		System.out.println(nv);
		sc.close();
	}

}

class NhanVien{
	private String ma, ten;
	private int luongCb, soNgayCong;
	private String chucVu;
	
	public NhanVien(String ten, int luongCb, int soNgayCong, String chucVu) {
		this.ma = "NV01";
		this.ten = ten;
		this.luongCb = luongCb;
		this.soNgayCong = soNgayCong;
		this.chucVu = chucVu;
	}
	
	public int tinhTienLuong() {
		return this.luongCb * this.soNgayCong;
	}
	
	public int tinhTienThuong() {
		if(this.soNgayCong >= 25) {
			return tinhTienLuong()*20/100;
		}
		else if(this.soNgayCong >= 22) {
			return tinhTienLuong()*10/100;
		}
		else {
			return 0;
		}
	}
	
	public int tinhPhuCap() {
		if(this.chucVu.equals("GD")) {
			return 250000;
		}
		if(this.chucVu.equals("PGD")) {
			return 200000;
		}
		if(this.chucVu.equals("TP")) {
			return 180000;
		}
		if(this.chucVu.equals("NV")) {
			return 150000;
		}
		return 0;
	}
	
	public int tinhThuNhap() {
		return tinhTienLuong()+tinhTienThuong()+tinhPhuCap();
	}

	@Override
	public String toString() {
		return ma + " " + ten + " " + tinhTienLuong() + " " + tinhTienThuong()
		+ " " + tinhPhuCap() + " " + tinhThuNhap();
	}
	
}
