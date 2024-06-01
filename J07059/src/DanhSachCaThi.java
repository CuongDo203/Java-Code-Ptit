import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DanhSachCaThi {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("CATHI.in"));
		List<CaThi> dsct = new ArrayList<>();
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 1; i <= n; i++) {
			String ngay = sc.nextLine();
			String gio = sc.nextLine();
			String maPhong = sc.nextLine();
			dsct.add(new CaThi(i+"", ngay, gio, maPhong));
		}
		dsct.sort(new Comparator<CaThi>() {
			@Override
			public int compare(CaThi o1, CaThi o2) {
				if(o1.getNgay().equals(o2.getNgay())) {
					return o1.getGio().compareTo(o2.getGio());
				}
				else {
					int nam1 = Integer.parseInt(o1.getNgay().substring(6));
					int thang1 = Integer.parseInt(o1.getNgay().substring(3, 5));
					int gio1 = Integer.parseInt(o1.getNgay().substring(0, 2));
					int nam2 = Integer.parseInt(o2.getNgay().substring(6));
					int thang2 = Integer.parseInt(o2.getNgay().substring(3, 5));
					int gio2 = Integer.parseInt(o2.getNgay().substring(0, 2));
					if(nam1!=nam2) {
						return nam1-nam2;
					}
					else {
						if(thang1!=thang2) {
							return thang1 - thang2;
						}
						else {
							return gio1-gio2;
						}
					}
				}
			}
		});
		for(CaThi ct : dsct) {
			System.out.println(ct);
		}
		sc.close();
	}

}

class CaThi{
	private String ma, ngay, gio, maPhong;

	public CaThi(String ma, String ngay, String gio, String maPhong) {
		while(ma.length() < 3) {
			ma = "0"+ma;
		}
		this.ma = "C"+ma;
		this.ngay = ngay;
		this.gio = gio;
		this.maPhong = maPhong;
	}
	
	public String getNgay() {
		return ngay;
	}

	public String getGio() {
		return gio;
	}

	@Override
	public String toString() {
		return ma + " " + ngay + " " + gio + " " + maPhong;
	}
	
}