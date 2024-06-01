import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimKiemGiangVien {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<GiangVien> ds = new ArrayList<>();
		while(t-->0) {
			ds.add(new GiangVien(sc.nextLine(), sc.nextLine()));
		}
		int q = Integer.parseInt(sc.nextLine());
		while(q-->0) {
			String s = sc.nextLine();
			System.out.println("DANH SACH GIANG VIEN THEO TU KHOA "+s+":");
			for(GiangVien gv : ds) {
				if(gv.getTen().toLowerCase().contains(s.toLowerCase())) {
					System.out.println(gv);
				}
			}
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
	
	public String getBoMon() {
		return boMon;
	}
	
	public String getTen() {
		return ten;
	}

	@Override
	public String toString() {
		return ma+" "+ten+" "+boMon;
	}
	
}