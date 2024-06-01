import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SapXepMatHang {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("MATHANG.in"));
		int n = Integer.parseInt(sc.nextLine());
		List<MatHang> dsmh = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			String tenMh = sc.nextLine();
			String nhomMh = sc.nextLine();
			double giaMua = Double.parseDouble(sc.nextLine());
			double giaBan = Double.parseDouble(sc.nextLine());
			dsmh.add(new MatHang(i+"", tenMh, nhomMh, giaMua, giaBan));
		}
		Collections.sort(dsmh);
		for(MatHang mh : dsmh) {
			System.out.println(mh);
		}
		sc.close();
	}
}

class MatHang implements Comparable<MatHang>{
	private String maMh, tenMh, nhomMh;
	private Double giaMua, giaBan;
	
	public MatHang(String maMh, String tenMh, String nhomMh, Double giaMua, Double giaBan) {
		while(maMh.length() < 2) {
			maMh = "0" + maMh;
		}
		this.maMh = "MH"+maMh;
		this.tenMh = tenMh;
		this.nhomMh = nhomMh;
		this.giaMua = giaMua;
		this.giaBan = giaBan;
	}
	
	public Double loiNhuan() {
		return giaBan - giaMua;
	}

	@Override
	public String toString() {
		return maMh + " " + tenMh + " " + nhomMh + " " + String.format("%.2f", loiNhuan());
	}

	@Override
	public int compareTo(MatHang o) {
		return (int) (o.loiNhuan() - loiNhuan());
	}

}
