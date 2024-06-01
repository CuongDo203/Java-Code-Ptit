import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SapXepDanhSachSinhVien {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("SINHVIEN.in"));
		int n = Integer.parseInt(sc.nextLine());
		List<SinhVien> lst = new ArrayList<>();
		while(n-->0) {
			String ma = sc.nextLine();
			String ten = sc.nextLine();
			String sdt = sc.nextLine();
			String email = sc.nextLine();
			lst.add(new SinhVien(ma, ten, sdt, email));
		}
		Collections.sort(lst);
		for(SinhVien sv : lst) {
			System.out.println(sv);
		}
		sc.close();
	}

}

class SinhVien implements Comparable<SinhVien>{
	private String ma, ten, soDt, email;

	public SinhVien(String ma, String ten, String soDt, String email) {
		this.ma = ma;
		this.ten = ten;
		this.soDt = soDt;
		this.email = email;
	}

	private String getTen() {
		String w[] = ten.trim().split("\\s+");
		return w[w.length-1];
	}
	
	private String getHo() {
		String w[] = ten.trim().split("\\s+");
		return w[0];
	}
	
	private String getHoDem() {
		String w[] = ten.trim().split("\\s+");
		StringBuilder sb = new StringBuilder();
		for(String x : w) {
			sb.append(x);
		}
		return sb.toString();
	}
	
	private String getMa() {
		return this.ma;
	}
	
	@Override
	public String toString() {
		return ma + " " + ten + " " + soDt + " " + email;
	}
	
	@Override
	public int compareTo(SinhVien o) {
		if(ten.equals(o.ten)) {
			return ma.compareTo(o.ma);
		}
		else {
			if(getTen().equals(o.getTen())) {
				if(getHo().equals(o.getHo())) {
					return getHoDem().compareTo(o.getHoDem());
				}
				else {
					return getHo().compareTo(o.getHo());
				}
			}
			else {
				return getTen().compareTo(o.getTen());
			}
		}
	}
}