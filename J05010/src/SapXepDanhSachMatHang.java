import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SapXepDanhSachMatHang {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<MatHang> ds = new ArrayList<>();
		while(t-->0) {
			String ten = sc.nextLine();
			String nhom = sc.nextLine();
			float giaMua = Float.parseFloat(sc.nextLine());
			float giaBan = Float.parseFloat(sc.nextLine());
			ds.add(new MatHang(ten, nhom, giaMua, giaBan));
		}
		ds.sort(new Comparator<MatHang>() {
			public int compare(MatHang o1, MatHang o2) {
				return Float.compare(o2.getLoiNhuan(), o1.getLoiNhuan());
			}
		});
		for(MatHang mh : ds) {
			System.out.println(mh);
		}
		sc.close();
	}

}

class MatHang{
	private int ma;
	private String tenMh, nhomMh;
	private float giaMua, giaBan;
	private static int STT = 1;
	
	public MatHang(String tenMh, String nhomMh, float giaMua, float giaBan) {
		this.ma = STT++;
		this.tenMh = tenMh;
		this.nhomMh = nhomMh;
		this.giaMua = giaMua;
		this.giaBan = giaBan;
	}
	
	public float getLoiNhuan() {
		return this.giaBan - this.giaMua;
	}

	@Override
	public String toString() {
		return ma + " " + tenMh+" "+nhomMh+" "+String.format("%.2f", getLoiNhuan());
	}
	
	
}