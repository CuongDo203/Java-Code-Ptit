import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BangDiemHocSinh {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<HocSinh> ds = new ArrayList<>();
		int t=Integer.parseInt(sc.nextLine());
		while(t-->0) {
			ds.add(new HocSinh(sc.nextLine(), sc.nextLine()));
		}
		ds.sort(new Comparator<HocSinh>() {

			@Override
			public int compare(HocSinh o1, HocSinh o2) {
				if(o1.getDtb()==o2.getDtb()) {
					return o1.getMa().compareTo(o2.getMa());
				}
				return Double.compare(o2.getDtb(), o1.getDtb());
			}
		});
		for(HocSinh hs : ds) {
			System.out.println(hs);
		}
		sc.close();
	}

}

class HocSinh{
	private String ma, ten;
	private double dtb;
	private String xepLoai;
	private static int STT=1;
	DecimalFormat df = new DecimalFormat("#.#");
	
	public HocSinh(String ten, String diem) {
		this.ma = "HS"+String.format("%02d", STT++);
		this.ten = ten;
		String d[] = diem.trim().split("\\s+");
		double dtb = 0;
		dtb += Double.parseDouble(d[0]);
		dtb += Double.parseDouble(d[1]);
		for(int i = 0; i < 10; i++) {
			dtb += Double.parseDouble(d[i]);
		}
		dtb/=12;
		this.dtb = (double)Math.round(dtb*10)/10;
		this.xepLoai = getXepLoai();
	}
	
	public String getMa() {
		return ma;
	}

	private String getXepLoai() {
		if(this.dtb>=9) {
			return "XUAT SAC";
		}
		else if(this.dtb >= 8) {
			return "GIOI";
		}
		else if(this.dtb>=7) {
			return "KHA";
		}
		else if(this.dtb>=5) {
			return "TB";
		}
		else {
			return "YEU";
		}
	}

	public double getDtb() {
		return dtb;
	}
	
	public String toString() {
		return ma+" "+ten+" "+String.format("%.1f", dtb)+" "+xepLoai; 
	}
}

