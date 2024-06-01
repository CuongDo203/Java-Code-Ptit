import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DanhSachTrungTuyen {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("THISINH.in"));
		int n = Integer.parseInt(sc.nextLine());
		List<ThiSinh> dsts = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String ma = sc.nextLine();
			String ten = sc.nextLine();
			float toan = Float.parseFloat(sc.nextLine());
			float ly = Float.parseFloat(sc.nextLine());
			float hoa = Float.parseFloat(sc.nextLine());
			dsts.add(new ThiSinh(ma, ten, toan, ly, hoa));
		}
		int chiTieu = sc.nextInt();
		dsts.sort(new Comparator<ThiSinh>() {
			@Override
			public int compare(ThiSinh o1, ThiSinh o2) {
				if(o1.getTongDiem() == o2.getTongDiem()) {
					return o1.getMa().compareTo(o2.getMa());
				}
				else {
					return o1.getTongDiem() < o2.getTongDiem() ? 1 : -1;
				}
			}
		});
		float diemTrungTuyen = dsts.get(chiTieu-1).getTongDiem();
		System.out.println(diemTrungTuyen);
		for(ThiSinh x : dsts) {
			System.out.print(x);
			if(x.getTongDiem()>=diemTrungTuyen) {
				System.out.println(" TRUNG TUYEN");
			}
			else {
				System.out.println(" TRUOT");
			}
		}
		sc.close();
	}

}

class ThiSinh{
	private String ma, khuVuc, ten;
	private float toan, ly, hoa;
	DecimalFormat df = new DecimalFormat("#.#");
	
	public ThiSinh(String ma, String ten, float toan, float ly, float hoa) {
		this.ma = ma;
		this.khuVuc = ma.substring(0, 3);
		this.ten = chuanHoaTen(ten);
		this.toan = toan;
		this.ly = ly;
		this.hoa = hoa;
	}
	
	public String getMa() {
		return ma;
	}

	private String chuanHoaTen(String s) {
		String w[] = s.trim().split("\\s+");
		String res = "";
		for(String x : w) {
			res += x.substring(0,1).toUpperCase() + x.substring(1).toLowerCase() + " ";
		}
		res = res.substring(0, res.length()-1);
		return res;
	}
	
	private float getDiemUuTien() {
		if(khuVuc.equals("KV1")) {
			return 0.5f;
		}
		else if(khuVuc.equals("KV2")) {
			return 1.0f;
		}
		else {
			return 2.5f;
		}
	}
	
	public float getTongDiem() {
		return toan*2 + ly + hoa + getDiemUuTien();
	}
	
	@Override
	public String toString() {
		return ma + " " + ten + " " + df.format(getDiemUuTien()) + " " + df.format(getTongDiem());
	}
}