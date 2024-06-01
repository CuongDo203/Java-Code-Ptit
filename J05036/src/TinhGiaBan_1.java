import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TinhGiaBan_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<MatHang> ds = new ArrayList<>();
		while(t-->0) {
			String ten = sc.nextLine();
			String dv = sc.nextLine();
			double donGia = Double.parseDouble(sc.nextLine());
			int sl = Integer.parseInt(sc.nextLine());
			ds.add(new MatHang(ten, dv, donGia, sl));
		}
		for(MatHang mh : ds) {
			System.out.println(mh);
		}
		sc.close();
	}

}

class MatHang{
	private String ma, ten, donVi;
	private double donGia;
	private int soLuong;
	private double phiVanChuyen, giaBan, thanhTien;
	private static int STT = 1;
	DecimalFormat df = new DecimalFormat("#.#");
	
	public MatHang(String ten, String donVi, double donGia, int soLuong) {
		this.ma = "MH"+String.format("%02d", STT++);
		this.ten = ten;
		this.donVi = donVi;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.phiVanChuyen = Math.round((donGia*soLuong)*5/100);
		this.thanhTien = Math.round(donGia*soLuong + this.phiVanChuyen);
		this.giaBan = Math.round(this.thanhTien + this.thanhTien*2/100);
	}

	@Override
	public String toString() {
		return ma+" "+ten+" "+donVi+" "+String.format("%.0f", phiVanChuyen)+" "+
				String.format("%.0f", thanhTien)+" "+String.format("%.0f", giaBan);
	}
	
}