import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyBaiTapNhom_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		List<SinhVien> dssv = new ArrayList<>();
		while(n-->0) {
			SinhVien sv = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));
			dssv.add(sv);
		}
		List<Nhom> dsNhom = new ArrayList<>();
		for(int i = 1; i <= m; i++) {
			String tenBt = sc.nextLine();
			dsNhom.add(new Nhom(tenBt, dssv, i));
		}
		int q = Integer.parseInt(sc.nextLine());
		while(q-->0) {
			int nhom = Integer.parseInt(sc.nextLine());
			System.out.println("DANH SACH NHOM "+nhom+":");
			for(Nhom x : dsNhom) {
				if(x.getSttNhom()==nhom) {
					System.out.println(x);
				}
			}
		}
		sc.close();
	}

}

class SinhVien{
	private String ma, ten, sdt;
	private int SttNhom;
	
	public SinhVien(String ma, String ten, String sdt, int sttNhom) {
		this.ma = ma;
		this.ten = ten;
		this.sdt = sdt;
		SttNhom = sttNhom;
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

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public int getSttNhom() {
		return SttNhom;
	}

	public void setSttNhom(int sttNhom) {
		SttNhom = sttNhom;
	}

	@Override
	public String toString() {
		return ma+" "+ten+" "+sdt;
	}
	
}

class Nhom{
	private String tenBtap;
	private List<SinhVien> dssv;
	private int SttNhom;
	
	public Nhom(String tenBtap, List<SinhVien> dssv, int sttNhom) {
		this.tenBtap = tenBtap;
		this.dssv = new ArrayList<>();
		this.SttNhom = sttNhom;
		for(SinhVien sv : dssv) {
			if(sv.getSttNhom() == SttNhom) {
				this.dssv.add(sv);
			}
		}
	}
	
	public int getSttNhom() {
		return SttNhom;
	}

	@Override
	public String toString() {
		String s = "";
		for(SinhVien tmp : this.dssv) {
			s += tmp+"\n";
		}
		s += "Bai tap dang ky: "+this.tenBtap;
		return s;
	}
	
}