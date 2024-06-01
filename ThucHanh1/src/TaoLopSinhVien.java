import java.util.Calendar;
import java.util.Scanner;

public class TaoLopSinhVien {

	public static void main(String[] args) {
        Sinhvien sv = new Sinhvien();
        sv.input();
        sv.out();
    }

}

class Sinhvien{
	private String ma, ten;
	private int tuoi;
	private double d1, d2;
	
	public Sinhvien() {
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

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public double getD1() {
		return d1;
	}

	public void setD1(double d1) {
		this.d1 = d1;
	}

	public double getD2() {
		return d2;
	}

	public void setD2(double d2) {
		this.d2 = d2;
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		String ma = sc.nextLine();
		String ten = sc.nextLine();
		int tuoi = Integer.parseInt(sc.nextLine());
		double d1 = Double.parseDouble(sc.next());
		double d2 = Double.parseDouble(sc.next());
		setMa(ma.toUpperCase());
		setTen(ten);
		setTuoi(tuoi);
		setD1(d1);
		setD2(d2);
	}
	
	public void out() {
		System.out.print(ma + " " + ten + " " + (2023 - tuoi) + " " + String.format("%.1f", getGpa()));
	}
	
	public double getGpa() {
		return (d1 + 2*d2)/3;
	}

	public int getNamSinh() {
		Calendar cd = Calendar.getInstance();
		return (Calendar.YEAR - tuoi) + 1984;
	}
}

