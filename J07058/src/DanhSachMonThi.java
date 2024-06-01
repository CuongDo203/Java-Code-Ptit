import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DanhSachMonThi {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("MONHOC.in"));
		List<MonHoc> dsmh = new ArrayList<>();
		int n = Integer.parseInt(sc.nextLine());
		while(n-- > 0) {
			String ma = sc.nextLine();
			String ten = sc.nextLine();
			String htt = sc.nextLine();
			dsmh.add(new MonHoc(ma, ten, htt));
		}
		Collections.sort(dsmh);
		for(MonHoc mh : dsmh) {
			System.out.println(mh);
		}
		sc.close();
	}

}

class MonHoc implements Comparable<MonHoc>{
	private String ma, ten, hinhThucThi;

	public MonHoc(String ma, String ten, String hinhThucThi) {
		this.ma = ma;
		this.ten = ten;
		this.hinhThucThi = hinhThucThi;
	}

	@Override
	public String toString() {
		return ma + " " + ten + " " + hinhThucThi;
	}

	@Override
	public int compareTo(MonHoc o) {
		return ma.compareTo(o.ma);
	}
	
	
}