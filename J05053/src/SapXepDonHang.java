import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SapXepDonHang {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<DonHang> ds = new ArrayList<>();
		while(t-->0) {
			String ten = sc.nextLine();
			String ma = sc.nextLine();
			double donGia = Double.parseDouble(sc.nextLine());
			int sl = Integer.parseInt(sc.nextLine());
			DonHang dh = new DonHang(ten, ma, donGia, sl);
			ds.add(dh);
		}
		ds.sort(new Comparator<DonHang>() {
			@Override
			public int compare(DonHang o1, DonHang o2) {
				return o1.getThuTu().compareTo(o2.getThuTu());
			}
		});
		for(DonHang dh : ds) {
			System.out.println(dh);
		}
		sc.close();
	}

}

class DonHang{
	private String ten, ma;
	private double donGia;
	private int soLuong;
	DecimalFormat df = new DecimalFormat("##.##");
	
	public DonHang(String ten, String ma, double donGia, int soLuong) {
		this.ten = ten;
		this.ma = ma;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}

	public String getThuTu() {
		return this.ma.substring(1,4);
	}
	
	public double getGiamGia() {
		if(this.ma.substring(4).equals("1")) {
			return this.donGia*this.soLuong*50/100;
		}
		else {
			return this.donGia*this.soLuong*30/100;
		}
	}
	
	public double getThanhTien() {
		return this.donGia*this.soLuong - getGiamGia();
	}

	@Override
	public String toString() {
		return ten+" "+ma+" "+getThuTu()+" "+df.format(getGiamGia())+" "+df.format(getThanhTien());
	}
	
}