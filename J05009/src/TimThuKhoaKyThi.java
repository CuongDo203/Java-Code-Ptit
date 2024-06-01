import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TimThuKhoaKyThi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<ThiSinh> dsts = new ArrayList<>();
		while(t-->0) {
			String ten = sc.nextLine();
			String ns = sc.nextLine();
			float d1 = Float.parseFloat(sc.nextLine());
			float d2 = Float.parseFloat(sc.nextLine());
			float d3 = Float.parseFloat(sc.nextLine());
			dsts.add(new ThiSinh(ten, ns, d1, d2, d3));
		}
		dsts.sort(new Comparator<ThiSinh>() {

			@Override
			public int compare(ThiSinh o1, ThiSinh o2) {
				return Float.compare(o2.getTongDiem(), o1.getTongDiem());
			}
		});
		float maxScore = dsts.get(0).getTongDiem();
		List<ThiSinh> tmp = new ArrayList<>();
		tmp.add(dsts.get(0));
		for(int i = 1; i < dsts.size(); i++) {
			if(dsts.get(i).getTongDiem() == maxScore) {
				tmp.add(dsts.get(i));
			}
		}
		tmp.sort(new Comparator<ThiSinh>() {

			@Override
			public int compare(ThiSinh o1, ThiSinh o2) {
				return Integer.compare(o1.getMa(), o2.getMa());
			}
		});
		sc.close();
		for(ThiSinh ts : tmp) {
			System.out.println(ts);
		}
	}

}

class ThiSinh{
	private int ma;
	private String ten, ngaySinh;
	private Float d1, d2, d3;
	private static int STT = 1;
	
	public int getMa() {
		return ma;
	}

	public ThiSinh(String ten, String ngaySinh, Float d1, Float d2, Float d3) {
		this.ma = STT++;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.d1 = d1;
		this.d2 = d2;
		this.d3 = d3;
	}
	
	public float getTongDiem() {
		return this.d1+this.d2+this.d3; 
	}

	@Override
	public String toString() {
		return ma + " "+ ten+ " "+ngaySinh+" "+getTongDiem();
	}
	
}
