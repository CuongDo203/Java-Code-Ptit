import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TinhGiaBan_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<MatHang> ds = new ArrayList<>();
		while(t-->0) {
			ds.add(new MatHang(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), 
					Integer.parseInt(sc.nextLine())));
		}
		ds.sort(new Comparator<MatHang>() {
			@Override
			public int compare(MatHang o1, MatHang o2) {
				return Double.compare(o2.getGiaBan(), o1.getGiaBan());
			}
		});
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
		this.giaBan =Math.ceil(((this.thanhTien + this.thanhTien*2/100)/this.soLuong/100))*100;
	}
	
	public double getGiaBan() {
		return giaBan;
	}

	@Override
	public String toString() {
		return ma+" "+ten+" "+donVi+" "+String.format("%.0f", phiVanChuyen)+" "+
				String.format("%.0f", thanhTien)+" "+String.format("%.0f", giaBan);
	}
	
}