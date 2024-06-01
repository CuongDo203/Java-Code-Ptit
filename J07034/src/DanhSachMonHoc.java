import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class DanhSachMonHoc {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("MONHOC.in"));
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<MonHoc> dsmh = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			String ma = sc.nextLine();
			String tenMh = sc.nextLine();
			int soTin = Integer.parseInt(sc.nextLine());
			MonHoc mh = new MonHoc(ma, tenMh, soTin);
			dsmh.add(mh);
		}
		dsmh.sort(new Comparator<MonHoc>() {
			@Override
			public int compare(MonHoc o1, MonHoc o2) {
				return o1.getTenMh().compareTo(o2.getTenMh());
			}
		});
		for(MonHoc x : dsmh) {
			System.out.println(x);
		}
		sc.close();
	}

}

class MonHoc{
	private String maMh, tenMh;
	private int soTinChi;
	
	public MonHoc(String maMh, String tenMh, int soTinChi) {
		this.maMh = maMh;
		this.tenMh = tenMh;
		this.soTinChi = soTinChi;
	}

	public String getTenMh() {
		return tenMh;
	}

	public void setTenMh(String tenMh) {
		this.tenMh = tenMh;
	}
	
	@Override
	public String toString() {
		return maMh + " " + tenMh + " " + soTinChi;
	}
	
}