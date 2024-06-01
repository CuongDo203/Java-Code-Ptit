import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LapBangTinhCong {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<NhanVien> ds = new ArrayList<>();
		while(t-->0) {
			ds.add(new NhanVien(sc.nextLine(), Long.parseLong(sc.nextLine()), 
					Long.parseLong(sc.nextLine()), sc.nextLine()));
		}
		for(NhanVien nv : ds) {
			System.out.println(nv);
		}
		sc.close();
	}
}

class NhanVien{
	private String ma, ten;
	private long luongNgay, soNgayCong;
	private String chucVu;
	private static int STT = 1;
	
	public NhanVien(String ten, long luongNgay, long soNgayCong, String chucVu) {
		this.ma = "NV"+String.format("%02d", STT++);
		this.ten = ten;
		this.luongNgay = luongNgay;
		this.soNgayCong = soNgayCong;
		this.chucVu = chucVu;
	}
	
	public int getPhuCap() {
		if(this.chucVu.equals("GD")) {
			return 250000;
		}
		else if(this.chucVu.equals("PGD")) {
			return 200000;
		}
		else if(this.chucVu.equals("TP")) {
			return 180000;
		}
		else {
			return 150000;
		}
	}
	
	public long getLuongThang() {
		return this.luongNgay*this.soNgayCong;
	}
	
	public long getThuong() {
		if(this.soNgayCong>=25) {
			return getLuongThang()*20/100;
		}
		else if(this.soNgayCong>=22) {
			return getLuongThang()*10/100;
		}
		else {
			return 0;
		}
	}

	public long getThucLinh() {
		return getLuongThang()+getThuong()+getPhuCap();
	}
	
	@Override
	public String toString() {
		return ma+" "+ten+" "+getLuongThang()+" "+getThuong()+" "+getPhuCap()+" "+getThucLinh();
	}
	
}