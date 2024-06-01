import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BangKeNhapKhoTheoChietKhau {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<HangHoa> ds = new ArrayList<>();
		List<String> lstId = new ArrayList<>();
		while(t-->0) {
			String ten = sc.nextLine();
			int sl = Integer.parseInt(sc.nextLine());
			Double donGia = Double.parseDouble(sc.nextLine());
			HangHoa hh = new HangHoa(ten, sl, donGia);
			int dem = 1;
			for(String x : lstId) {
				if(x.contains(hh.getPrefixId())) {
					dem++;
				}
			}
			hh.setMa(dem);
			ds.add(hh);
			lstId.add(hh.getMa());
		}
		ds.sort(new Comparator<HangHoa>() {
			@Override
			public int compare(HangHoa o1, HangHoa o2) {
				return Double.compare(o2.getTienChietKhau(), o1.getTienChietKhau());
			}
		});
		for(HangHoa hh : ds) {
			System.out.println(hh);
		}
		sc.close();
	}

}

class HangHoa{
	private String ma, ten;
	private long soLuong;
	private double donGia;
	private static int STT=1;
	DecimalFormat df = new DecimalFormat("##.##");
	
	public HangHoa(String ten, long soLuong, double donGia) {
		this.ten = ten;
		String w[] = this.ten.trim().split("\\s+");
		this.ma = w[0].substring(0,1).toUpperCase()+w[1].substring(0,1).toUpperCase()
				+'0';
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	
	public String getPrefixId() {
		String w[] = this.ten.trim().split("\\s+");
		return w[0].substring(0,1).toUpperCase()+w[1].substring(0,1).toUpperCase()+'0';
	}
	
	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}
	
	public void setMa(int id) {
		this.ma = this.ma+Integer.toString(id);
	}
	
	private double getPtChietKhau() {
		if(this.soLuong>10) {
			return 0.05;
		}
		else if(this.soLuong>=8) {
			return 0.02;
		}
		else if(this.soLuong>=5) {
			return 0.01;
		}
		else {
			return 0;
		}
	}
	
	public double getTienChietKhau() {
		return this.donGia*this.soLuong*getPtChietKhau();
	}
	
	public double getThanhTien() {
		return this.donGia*this.soLuong-getTienChietKhau();
	}

	@Override
	public String toString() {
		return ma+" "+ten+" "+df.format(getTienChietKhau())+" "+df.format(getThanhTien());
	}
}