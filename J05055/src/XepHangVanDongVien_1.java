import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class XepHangVanDongVien_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<VanDongVien> ds = new ArrayList<>();
		while(t-->0) {
			String ten = sc.nextLine();
			String dob = sc.nextLine();
			String bd = sc.nextLine();
			String kt = sc.nextLine();
			ds.add(new VanDongVien(ten, dob, bd, kt));
		}
		List<VanDongVien> tmp = new ArrayList<>(ds);
		Map<String, Integer> mp = new HashMap<>();
		tmp.sort(new Comparator<VanDongVien>() {
			@Override
			public int compare(VanDongVien o1, VanDongVien o2) {
				return Long.compare(o1.getThanhTichXepHang(), o2.getThanhTichXepHang());
			}
		});
		tmp.get(0).setXepHang(1);
		mp.put(tmp.get(0).getMa(), 1);
		for(int i = 1; i < tmp.size(); i++) {
			if(tmp.get(i).getThanhTichXepHang()==tmp.get(i-1).getThanhTichXepHang()) {
				mp.put(tmp.get(i).getMa(), mp.get(tmp.get(i-1).getMa()));
			}
			else {
				mp.put(tmp.get(i).getMa(), i+1);
			}
		}
		for(VanDongVien v : ds) {
			v.setXepHang(mp.get(v.getMa()));
			System.out.println(v);
		}
		sc.close();
	}

}

class VanDongVien{
	private String ma,ten, ngaySinh, tgBatDau, tgKetThuc;
	private static int STT = 1;
	private int xepHang;
	
	public VanDongVien(String ten, String ngaySinh, String tgBatDau, String tgKetThuc) {
		this.ma = "VDV"+String.format("%02d", STT++);
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.tgBatDau = tgBatDau;
		this.tgKetThuc = tgKetThuc;
	}
	
	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public int getTuoi() {
		String d[] = this.ngaySinh.trim().split("/");
		return 2021 - Integer.parseInt(d[2]);
	}
	
	public int getUuTien() {
		if(getTuoi()>=32) {
			return 3;
		}
		else if(getTuoi()>=25) {
			return 2;
		}
		else if(getTuoi()>=18) {
			return 1;
		}
		else return 0;
	}
	
	public int getXepHang() {
		return xepHang;
	}

	public long getThanhTichXepHang() {
		return getThanhTich(tgBatDau, tgKetThuc)-getUuTien();
	}
	
	public void setXepHang(int xepHang) {
		this.xepHang = xepHang;
	}

	public long getThanhTich(String tgBd, String tgKt) {
		String s1[] = tgBd.trim().split(":");
		long start = Long.parseLong(s1[0])*3600+Long.parseLong(s1[1])*60+Long.parseLong(s1[2]);
		String s2[] = tgKt.trim().split(":");
		long end = Long.parseLong(s2[0])*3600+Long.parseLong(s2[1])*60+Long.parseLong(s2[2]);
		return end - start;
	}

	public String thoiGian(long s) {
		return String.format("%02d:%02d:%02d", s/3600,(s%3600)/60, s%60);
	}
	
	@Override
	public String toString() {
		return ma+" "+ten+" "+thoiGian(getThanhTich(tgBatDau, tgKetThuc))
		+" "+thoiGian(getUuTien())+" "+thoiGian(getThanhTich(tgBatDau, tgKetThuc)-getUuTien())+" "+xepHang;
	}
	
}