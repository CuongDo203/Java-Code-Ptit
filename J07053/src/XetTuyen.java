import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class XetTuyen {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("XETTUYEN.in"));
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 1; i <= n; i++) {
			String ten = sc.nextLine();
			String ns = sc.nextLine();
			float lyThuyet = Float.parseFloat(sc.nextLine());
			float thucHanh = Float.parseFloat(sc.nextLine());
			Interviewee ts = new Interviewee(i+"", ten, ns, lyThuyet, thucHanh);
			System.out.println(ts);
		}
		sc.close();
	}

}

class Interviewee{
	private String ma, ten, ngaySinh;
	private float lyThuyet, thucHanh;
	
	public Interviewee(String ma, String ten, String ngaySinh, float lyThuyet, float thucHanh) {
		while(ma.length() < 2) {
			ma = "0" + ma;
		}
		this.ma = "PH"+ma;
		this.ten = chuanHoaTen(ten);
		this.ngaySinh = ngaySinh;
		this.lyThuyet = lyThuyet;
		this.thucHanh = thucHanh;
	}
	
	private String chuanHoaTen(String s) {
		String w[] = s.trim().split("\\s+");
		String res = "";
		for(String x : w) {
			res += x.substring(0,1).toUpperCase() + x.substring(1).toLowerCase() + " ";
		}
		res = res.substring(0, res.length()-1);
		return res;
	}
	
	private float getDiemThuong() {
		if(thucHanh >= 1 && lyThuyet >= 8) {
			return 1f;
		}
		if(thucHanh >= 7.5 && lyThuyet >= 7.5) {
			return 0.5f;
		}
		return 0;
	}
	
	private int getTuoi() {
		String res = "";
		int cnt = 0;
		for(int i = ngaySinh.length()-1; i >= 0; i--) {
			res = ngaySinh.charAt(i) + res;
			cnt++;
			if(cnt==4) {
				break;
			}
		}
		return 2021 - Integer.parseInt(res);
	}
	
	private float getTongDiem() {
		float diem = (lyThuyet + thucHanh)/2 + getDiemThuong();
		return diem >= 10f ? 10f : diem;
	}
	
	private String getXepLoai() {
		long diem = Math.round(getTongDiem());
		if(diem< 5) {
			return "Truot";
		}
		else if(diem <= 6) {
			return "Trung binh";
		}
		else if(diem == 7) {
			return "Kha";
		}
		else if(diem == 8) {
			return "Gioi";
		}
		else {
			return "Xuat sac";
		}
	}
	
	@Override
	public String toString() {
		return ma + " " + ten + " " + getTuoi() + " " + Math.round(getTongDiem()) + " " + getXepLoai();
	}
	
}