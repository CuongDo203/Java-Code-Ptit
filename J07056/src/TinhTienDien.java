import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TinhTienDien {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("KHACHHANG.in"));
		int n = Integer.parseInt(sc.nextLine());
		List<KhachHang> dskh = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			String ten = sc.nextLine();
			String w[] = sc.nextLine().split(" ");
			String loai = w[0];
			int soDau = Integer.parseInt(w[1]);
			int soCuoi = Integer.parseInt(w[2]);
			dskh.add(new KhachHang(i+"", ten, loai, soCuoi-soDau));
		}
		dskh.sort(new Comparator<KhachHang>() {

			@Override
			public int compare(KhachHang o1, KhachHang o2) {
				return o2.tinhTongTien() - o1.tinhTongTien();
			}
		});
		for(KhachHang kh : dskh) {
			System.out.println(kh);
		}
		sc.close();
	}

}

class KhachHang{
	private String ma, ten, loai;
	private int soDien, tienTrongDinhMuc, tienVuotDinhMuc, tienPhaiNop;
	
	public KhachHang(String ma, String ten, String loai, int soDien) {
		while(ma.length() < 2) {
			ma = "0" + ma;
		}
		this.ma = "KH"+ma;
		this.ten = chuanHoaTen(ten);
		this.loai = loai;
		this.soDien = soDien;
		this.tienTrongDinhMuc = 0;
		this.tienVuotDinhMuc = 0;
		this.tienPhaiNop = 0;
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
	
	public int getSoDien() {
		return soDien;
	}

	private int getDinhMuc() {
		if(loai.equals("A")) {
			return 100;
		}
		if(loai.equals("B")) {
			return 500;
		}
		if(loai.equals("C")) {
			return 200;
		}
		return -1;
	}
	
	public int getTienTrongDinhMuc() {
		if(getSoDien() < getDinhMuc()) {
			this.tienTrongDinhMuc = getSoDien()*450;
		}
		else {
			this.tienTrongDinhMuc = getDinhMuc()*450;
		}
		return tienTrongDinhMuc;
	}

	public int getTienVuotDinhMuc() {
		if(getSoDien() > getDinhMuc()) {
			this.tienVuotDinhMuc = (getSoDien()-getDinhMuc())*1000;
		}
		return tienVuotDinhMuc;
	}

	public int getVAT() {
		return (int)(tienVuotDinhMuc*0.05);
	}
	
	public int tinhTongTien() {
		this.tienPhaiNop = (int) (getTienTrongDinhMuc() + getTienVuotDinhMuc() + getVAT());
		return this.tienPhaiNop;
	}

	@Override
	public String toString() {
		return ma + " " + ten + " " + tienTrongDinhMuc + " " + tienVuotDinhMuc + " "
				+ getVAT() + " " + tinhTongTien();
	}
	
}