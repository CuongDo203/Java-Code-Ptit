import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SapXepKetQuaTuyenSinh {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<ThiSinh> ds = new ArrayList<>();
		int t = Integer.parseInt(sc.nextLine());
		while(t-->0) {
			String ma = sc.nextLine();
			String ten = sc.nextLine();
			double dToan = Double.parseDouble(sc.nextLine());
			double dLy = Double.parseDouble(sc.nextLine());
			double dHoa = Double.parseDouble(sc.nextLine());
			ds.add(new ThiSinh(ma, ten, dToan, dLy, dHoa));
		}
		ds.sort(new Comparator<ThiSinh>() {
			@Override
			public int compare(ThiSinh o1, ThiSinh o2) {
				if(o1.getDiemXetTuyen()==o2.getDiemXetTuyen()) {
					return o1.getMa().compareTo(o2.getMa());
				}
				return Double.compare(o2.getDiemXetTuyen(), o1.getDiemXetTuyen());
			}
		});
		for(ThiSinh ts : ds) {
			System.out.println(ts);
		}
		sc.close();
	}

}

class ThiSinh{
	private String ma, ten;
	private double dToan, dLy, dHoa;
	DecimalFormat df = new DecimalFormat("##.#");
	
	public ThiSinh(String ma, String ten, double dToan, double dLy, double dHoa) {
		this.ma = ma;
		this.ten = ten;
		this.dToan = dToan;
		this.dLy = dLy;
		this.dHoa = dHoa;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public double getDiemUuTien() {
		if(ma.substring(0,3).equals("KV1")) {
			return 0.5;
		}
		else if(ma.substring(0,3).equals("KV2")) {
			return 1;
		}
		else {
			return 2.5;
		}
	}
	
	public double getTongDiem() {
		return this.dToan*2+this.dLy+this.dHoa;
	}
	
	public double getDiemXetTuyen() {
		return getTongDiem()+getDiemUuTien();
	}

	@Override
	public String toString() {
		return ma+" "+ten+" "+df.format(getDiemUuTien())+" "
				+df.format(getDiemXetTuyen())+" "+((getTongDiem()+getDiemUuTien()>=24)?"TRUNG TUYEN" : "TRUOT");
	}
	
}