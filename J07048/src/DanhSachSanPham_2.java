import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DanhSachSanPham_2 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("SANPHAM.in"));
		int n = Integer.parseInt(sc.nextLine());
		List<SanPham> dssp = new ArrayList<>();
		while(n-->0) {
			String ma = sc.nextLine();
			String ten = sc.nextLine();
			int giaBan = Integer.parseInt(sc.nextLine());
			int tgbh = Integer.parseInt(sc.nextLine());
			dssp.add(new SanPham(ma, ten, giaBan, tgbh));
		}
		sc.close();
		dssp.sort(new Comparator<SanPham>() {
			@Override
			public int compare(SanPham o1, SanPham o2) {
				if(o1.getGiaBan() == o2.getGiaBan()) {
					return o1.getMaSp().compareTo(o2.getMaSp());
				}
				return o2.getGiaBan()-o1.getGiaBan();
			}
		});
		for(SanPham sp : dssp) {
			System.out.println(sp);
		}
	}

}

class SanPham{
	private String maSp, tenSp;
	private int giaBan, thoiGianBaoHanh;
	
	public SanPham(String maSp, String tenSp, int giaBan, int thoiGianBaoHanh) {
		this.maSp = maSp;
		this.tenSp = tenSp;
		this.giaBan = giaBan;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}

	public String getMaSp() {
		return maSp;
	}

	public int getGiaBan() {
		return giaBan;
	}

	@Override
	public String toString() {
		return maSp + " " + tenSp + " " + giaBan + " " + thoiGianBaoHanh;
	}
	
}