import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SapXepSinhVienTheoLop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<SinhVien> ds = new ArrayList<>();
		while(t-->0) {
			ds.add(new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
		}
		ds.sort(new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				if(o1.getLop().equals(o2.getLop())) {
					return o1.getMa().compareTo(o2.getMa());
				}
				return o1.getLop().compareTo(o2.getLop());
			}
		});
		for(SinhVien sv : ds) {
			System.out.println(sv);
		}
		sc.close();
	}

}

class SinhVien{
	private String ma, ten, lop, email;

	public SinhVien(String ma, String ten, String lop, String email) {
		this.ma = ma;
		this.ten = ten;
		this.lop = lop;
		this.email = email;
	}
	
	public String getMa() {
		return ma;
	}

	public String getLop() {
		return lop;
	}

	@Override
	public String toString() {
		return ma+" "+ten+" "+lop+" "+email;
	}
	
}