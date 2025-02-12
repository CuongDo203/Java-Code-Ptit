import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class XepHangHocSinh {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<HocSinh> ds = new ArrayList<>();
		while(t-->0) {
			ds.add(new HocSinh(sc.nextLine(), Double.parseDouble(sc.nextLine())));
		}
		List<HocSinh> lst = new ArrayList<>(ds);
		ds.sort(new Comparator<HocSinh>() {
			@Override
			public int compare(HocSinh o1, HocSinh o2) {
				return Double.compare(o2.getDtb(), o1.getDtb());
			}
		});
		ds.get(0).setXephang(1);
		for(int i = 1; i < ds.size(); i++) {
			if(ds.get(i).getDtb()==ds.get(i-1).getDtb()) {
				ds.get(i).setXephang(ds.get(i-1).getXephang());
			}
			else {
				ds.get(i).setXephang(i+1);
			}
		}
		for(int i = 0; i < lst.size(); i++) {
			for(HocSinh hs : ds) {
				if(lst.get(i).getMa().equals(hs.getMa())) {
					lst.get(i).setXephang(hs.getXephang());
				}
			}
		}
		for(HocSinh hs : lst) {
			System.out.println(hs);
		}
		sc.close();
	}

}

class HocSinh{
	private String ma, ten;
	private double dtb;
	private static int STT=1;
	private int xephang;
	
	public HocSinh(String ten, double dtb) {
		this.ma = "HS" + String.format("%02d", STT++);
		this.ten = ten;
		this.dtb = dtb;
	}
	
	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getXepLoai() {
		if(this.dtb>9) return "Gioi";
		else if(this.dtb>=7) return "Kha";
		else if(this.dtb >= 5) return "Trung Binh";	
		else return "Yeu";
	}

	public int getXephang() {
		return xephang;
	}

	public void setXephang(int xephang) {
		this.xephang = xephang;
	}

	public double getDtb() {
		return dtb;
	}

	public void setDtb(double dtb) {
		this.dtb = dtb;
	}

	@Override
	public String toString() {
		return ma+" "+ten+" "+dtb+" "+ getXepLoai()+" "+xephang;
	}
	
}