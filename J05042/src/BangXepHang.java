import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BangXepHang {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<SinhVien> ds = new ArrayList<>();
		while(t-->0) {
			ds.add(new SinhVien(sc.nextLine(), Integer.parseInt(sc.next()), Integer.parseInt(sc.next())));
			sc.nextLine();
		}
		ds.sort(new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				if(o1.getSoBaiLamDung()==o2.getSoBaiLamDung()) {
					if(o1.getSoLuotSubmit()==o2.getSoLuotSubmit())
						o1.getTen().compareTo(o2.getTen());
					else
						return o1.getSoLuotSubmit()-o2.getSoLuotSubmit();
				}
				return o2.getSoBaiLamDung()-o1.getSoBaiLamDung();
			}
		});
		for(SinhVien sv : ds) {
			System.out.println(sv);
		}
		sc.close();
	}

}

class SinhVien{
	private String ten;
	private int soBaiLamDung, soLuotSubmit;
	
	public SinhVien(String ten, int soBaiLamDung, int soLuotSubmit) {
		this.ten = ten;
		this.soBaiLamDung = soBaiLamDung;
		this.soLuotSubmit = soLuotSubmit;
	}

	public String getTen() {
		return ten;
	}

	public int getSoBaiLamDung() {
		return soBaiLamDung;
	}

	public int getSoLuotSubmit() {
		return soLuotSubmit;
	}

	@Override
	public String toString() {
		return ten+" "+soBaiLamDung+" "+soLuotSubmit;
	}
	
}