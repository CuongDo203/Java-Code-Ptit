import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SapXepDanhSachGiangVien {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<GiangVien> ds = new ArrayList<>();
		while(t-->0) {
			ds.add(new GiangVien(sc.nextLine(), sc.nextLine()));
		}
		ds.sort(new Comparator<GiangVien>() {

			@Override
			public int compare(GiangVien o1, GiangVien o2) {
				if(o1.getTen().equalsIgnoreCase(o2.getTen())) {
					return o1.getMa().compareToIgnoreCase(o2.getMa());
				}
				return o1.getTen().compareToIgnoreCase(o2.getTen());
			}
		});
		for(GiangVien gv : ds) {
			System.out.println(gv);
		}
		sc.close();
	}

}

class GiangVien{
	private String ma, ten, boMon;
	private static int STT=1;
	
	public GiangVien(String ten, String boMon) {
		this.ma = "GV"+String.format("%02d", STT++);
		this.ten = ten;
		String w[] = boMon.trim().split("\\s+");
		String res= "";
		for(String x : w) {
			res += x.charAt(0);
		}
		res = res.toUpperCase();
		this.boMon = res;
	}
	
	public String getMa() {
		return ma;
	}

	public String getTen() {
		String w[] = this.ten.trim().split("\\s+");
		return w[w.length-1];
	}

	@Override
	public String toString() {
		return ma+" "+ten+" "+boMon;
	}
	
}