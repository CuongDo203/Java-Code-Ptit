package main;

import java.util.Scanner;

public class LopXau {
	private String xau;
	Scanner sc = new Scanner(System.in);
	public LopXau() {
	}
	
	public String getXau() {
		return xau;
	}

	public void setXau(String xau) {
		this.xau = xau;
	}



	public void nhap() {
		System.out.println("Moi ban nhap vao 1 xau: ");
		String s = sc.nextLine();
		setXau(s);
	}
	
	public boolean isMaSinhVien() {
		xau = xau.toUpperCase();
		String reg = "^B\\d{2}DC(CN|AT)\\d{3}$";
		if(this.xau.matches(reg)) {
			return true;
		}
		return false;
	}
	
	public void tachTu() {
		System.out.println("Cac tu co trong xau la: ");
		String w[] = xau.trim().split("[\\s\\d]+");
		for(String x : w) {
			System.out.println(x + " ");
		}
	}
	
	public void chuanHoaDoanVanBan() {
		xau = xau.toLowerCase();
		xau.replaceAll("\\s*\\,", "\\,");
		xau.replaceAll("\\,\\s*", "\\, ");
		xau.replaceAll("\\s+", " ");
		xau.replaceAll("\\s*\\.", "\\.");
		xau.replaceAll("\\.\\s*", "\\. ");
		xau.replaceAll("\\s*\\!", "\\!");
		xau.replaceAll("\\!\\s*", "\\! ");
		xau.replaceAll("\\s*\\?", "\\?");
		xau.replaceAll("\\?\\s*", "\\? ");
		System.out.println(xau);
	}
}
