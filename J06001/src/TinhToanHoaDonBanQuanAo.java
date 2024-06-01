import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TinhToanHoaDonBanQuanAo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<SanPham> dsSp = new ArrayList<>();
		while(t-->0) {
			dsSp.add(new SanPham(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()), 
					Long.parseLong(sc.nextLine())));
		}
		int n = Integer.parseInt(sc.nextLine());
		List<HoaDon> dsHd = new ArrayList<>();
		while(n-->0) {
			String maHd = sc.next();
			int sl = Integer.parseInt(sc.next());
			sc.nextLine();
			HoaDon hd = new HoaDon(maHd, sl);
			for(SanPham sp : dsSp) {
				if(sp.getMaSp().equals(maHd.substring(0,2))){
					hd.setSp(sp);
					break;
				}
			}
			dsHd.add(hd);
		}
		for(HoaDon hd : dsHd) {
			System.out.println(hd);
		}
		sc.close();
	}

}

class SanPham{
	private String maSp, tenSp;
	private long giaLoai1, giaLoai2;
	
	public SanPham(String maSp, String tenSp, long giaLoai1, long giaLoai2) {
		this.maSp = maSp;
		this.tenSp = tenSp;
		this.giaLoai1 = giaLoai1;
		this.giaLoai2 = giaLoai2;
	}
	
	public String getMaSp() {
		return maSp;
	}

	public void setMaSp(String maSp) {
		this.maSp = maSp;
	}

	public String getTenSp() {
		return tenSp;
	}

	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}

	public long getGiaLoai1() {
		return giaLoai1;
	}

	public void setGiaLoai1(long giaLoai1) {
		this.giaLoai1 = giaLoai1;
	}

	public long getGiaLoai2() {
		return giaLoai2;
	}

	public void setGiaLoai2(long giaLoai2) {
		this.giaLoai2 = giaLoai2;
	}
	
}

class HoaDon{
	private String ma;
	private SanPham sp;
	private int soLuong, loai;
	private static int STT = 1;
	
	public HoaDon(String ma, int soLuong) {
		this.loai = Integer.parseInt(ma.substring(2));
		this.ma = ma+"-"+String.format("%03d", STT++);
		this.soLuong = soLuong;
	}

	public void setSp(SanPham sp) {
		this.sp = sp;
	}
	
	public long getGiamGia() {
		if(soLuong>=150) {
			return (getThanhTien())/2;
		}
		else if(soLuong >= 100) {
			return (getThanhTien())*30/100;
		}
		else if(soLuong >= 50){
			return (getThanhTien())*15/100;
		}
		else {
			return 0;
		}
	}
	
	public long getThanhTien() {
		return ((loai==1)?this.sp.getGiaLoai1():this.sp.getGiaLoai2())*soLuong;
	}
	
	public long getSoTienPhaiTra() {
		return getThanhTien()-getGiamGia();
	}
	
	@Override
	public String toString() {
		return this.ma+ " "+this.sp.getTenSp()+" "+getGiamGia()+" "+getSoTienPhaiTra();
	}
	
}