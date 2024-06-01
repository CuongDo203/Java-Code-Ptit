import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BangKeNhapKho {

	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		List<HangHoa> ds = new ArrayList<>();
		int t = Integer.parseInt(sc.nextLine());
		List<String> lstId = new ArrayList<>();
		while(t-->0) {
			String ten = sc.nextLine();
			Long sl = Long.parseLong(sc.nextLine());
			Double donGia = Double.parseDouble(sc.nextLine());
			HangHoa hh = new HangHoa(ten, sl, donGia);
			int dem = 1;
			for(String x : lstId) {
				if(x.contains(hh.getPrefixId())) {
					dem++;
				}
			}
			lstId.add(hh.getPrefixId());
			hh.setMa(dem);
			ds.add(hh);
		}
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