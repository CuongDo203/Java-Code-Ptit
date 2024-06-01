import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DanhSachDoanhNghiep {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("DN.in"));
		int n = Integer.parseInt(sc.nextLine());
		List<DoanhNghiep> dsDn = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String maDn = sc.nextLine();
			String tenDn = sc.nextLine();
			int soSv = Integer.parseInt(sc.nextLine());
			DoanhNghiep dn = new DoanhNghiep(maDn, tenDn, soSv);
			dsDn.add(dn);
		}
		dsDn.sort(new Comparator<DoanhNghiep>() {
			@Override
			public int compare(DoanhNghiep o1, DoanhNghiep o2) {
				return o1.getMaDn().compareTo(o2.getMaDn());
			}
		});
		for(DoanhNghiep dn : dsDn) {
			System.out.println(dn);
		}
		sc.close();
	}

}

class DoanhNghiep{
	private String maDn, tenDn;
	private int SoSvCoTheNhan;
	
	public DoanhNghiep(String maDn, String tenDn, int soSvCoTheNhan) {
		this.maDn = maDn;
		this.tenDn = tenDn;
		SoSvCoTheNhan = soSvCoTheNhan;
	}

	public String getMaDn() {
		return maDn;
	}

	public void setMaDn(String maDn) {
		this.maDn = maDn;
	}
	
	@Override
	public String toString() {
		return maDn + " " + tenDn + " " + SoSvCoTheNhan;
	}
}