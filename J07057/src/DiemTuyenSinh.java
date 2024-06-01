import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DiemTuyenSinh {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("THISINH.in"));
		int n = Integer.parseInt(sc.nextLine());
		List<ThiSinh> dsts = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			String ten = sc.nextLine();
			float diem = Float.parseFloat(sc.nextLine());
			String danToc = sc.nextLine();
			String kv = sc.nextLine();
			dsts.add(new ThiSinh(i+"", ten, danToc, kv, diem));
		}
		dsts.sort(new Comparator<ThiSinh>() {
			@Override
			public int compare(ThiSinh o1, ThiSinh o2) {
				if(o1.getTongDiem() == o2.getTongDiem()) {
					return o1.getMa().compareTo(o2.getMa());
				}
				else {
					return o1.getTongDiem()<o2.getTongDiem() ? 1 : -1;
				}
			}
		});
		for(ThiSinh ts : dsts) {
			System.out.println(ts);
		}
		sc.close();
	}

}

class ThiSinh{
	private String ma, ten, danToc, khuVuc;
	private float diem;
	
	public ThiSinh(String ma, String ten, String danToc, String khuVuc, float diem) {
		while(ma.length()< 2) {
			ma = "0" + ma;
		}
		this.ma = "TS"+ma;
		this.ten = chuanHoaTen(ten);
		this.danToc = danToc;
		this.khuVuc = khuVuc;
		this.diem = diem;
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
	
	public String getMa() {
		return ma;
	}

	private float getDiemUuTien() {
		float res = 0;
		if(khuVuc.equals("1")) {
			res += 1.5;
		}
		else if(khuVuc.equals("2")) {
			res += 1;
		}	
		if(!danToc.equals("Kinh")) {
			res += 1.5;
		}
		return res;
	}
	
	public float getTongDiem() {
		return this.diem + getDiemUuTien();
	}

	@Override
	public String toString() {
		return ma + " " + ten + " " + String.format("%.1f", getTongDiem())+" " + (getTongDiem()>=20.5 ? "Do" : "Truot");
	}
	
}