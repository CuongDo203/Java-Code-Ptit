import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class MatHang{
	private String maMh, tenMh, donViTinh;
	private int giaMua, giaBan;
	
	public String taoMa(String s) {
		while(s.length() < 3) {
			s = "0" + s;
		}
		return "MH" + s;
	}
	
	public String getMaMh() {
		return maMh;
	}

	public void setMaMh(String maMh) {
		this.maMh = maMh;
	}

	public MatHang(String maMh, String tenMh, String donViTinh, int giaMua, int giaBan) {
		this.maMh = taoMa(maMh);
		this.tenMh = tenMh;
		this.donViTinh = donViTinh;
		this.giaMua = giaMua;
		this.giaBan = giaBan;
	}
	
	public int getLoiNhuan() {
		return this.giaBan - this.giaMua;
	}
	
	@Override
	public String toString() {
		return maMh + " " + tenMh + " " + donViTinh + " " + giaMua + " " + giaBan + " " + getLoiNhuan();
	}
}

public class DanhSachMatHang {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		List<MatHang> dsmh = new ArrayList<MatHang>();
		for(int i = 1; i <= n; i++) {
			String ten = sc.nextLine();
			String dv = sc.nextLine();
			int giaMua = Integer.parseInt(sc.nextLine());
			int giaBan = Integer.parseInt(sc.nextLine());
			MatHang mh = new MatHang(i+"", ten, dv, giaMua, giaBan);
			dsmh.add(mh);
		}
		dsmh.sort(new Comparator<MatHang>() {
			@Override
			public int compare(MatHang o1, MatHang o2) {
				if(o1.getLoiNhuan() == o2.getLoiNhuan()) {
					return o1.getMaMh().compareTo(o2.getMaMh());
				}
				else {
					return o2.getLoiNhuan() - o1.getLoiNhuan();
				}
			}
		});
		for(MatHang mh : dsmh) {
			System.out.println(mh);
		}
		sc.close();
	}

}
