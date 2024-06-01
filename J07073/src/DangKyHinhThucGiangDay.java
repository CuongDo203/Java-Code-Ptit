import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DangKyHinhThucGiangDay {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("MONHOC.in"));
		int n = Integer.parseInt(sc.nextLine());
		List<MonHoc> dsmh = new ArrayList<>();
		while(n-->0) {
			String ma = sc.nextLine();
			String ten = sc.nextLine();
			int soTin = Integer.parseInt(sc.nextLine());
			String lt = sc.nextLine();
			String th = sc.nextLine();
			if(th.equals("Truc tuyen") || th.endsWith(".ptit.edu.vn")) {
				dsmh.add(new MonHoc(ma, ten, lt, th, soTin));
			}
		}
		dsmh.sort(new Comparator<MonHoc>() {
			@Override
			public int compare(MonHoc o1, MonHoc o2) {
				return o1.getMa().compareTo(o2.getMa());
			}
		});
		for(MonHoc mh : dsmh) {
			System.out.println(mh);
		}
		sc.close();
	}

}

class MonHoc{
	private String ma, ten, lyThuyet, thucHanh;
	private int soTin;
	
	public MonHoc(String ma, String ten, String lyThuyet, String thucHanh, int soTin) {
		this.ma = ma;
		this.ten = ten;
		this.lyThuyet = lyThuyet;
		this.thucHanh = thucHanh;
		this.soTin = soTin;
	}
		
	public String getMa() {
		return ma;
	}

	public String getThucHanh() {
		return thucHanh;
	}

	@Override
	public String toString() {
		return ma + " " + ten + " " + soTin + " " + lyThuyet + " " + thucHanh;
	}
	
	
}