import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SapXepBangTinhTienDien {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<TienDien> ds = new ArrayList<>();
		while (t-- > 0) {
			ds.add(new TienDien(sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
		}
		ds.sort(new Comparator<TienDien>() {
			@Override
			public int compare(TienDien o1, TienDien o2) {
				return Double.compare(o2.getTongTienPhaiTra(), o1.getTongTienPhaiTra());
			}
		});
		for (TienDien td : ds) {
			System.out.println(td);
		}
		sc.close();
	}

}

class TienDien {
	private String maKh, loaiSd;
	private double soCu, soMoi;
	private static int STT = 1;
	DecimalFormat df = new DecimalFormat("##.##");

	public TienDien(String loaiSd, double soCu, double soMoi) {
		this.maKh = "KH" + String.format("%02d", STT++);
		this.loaiSd = loaiSd;
		this.soCu = soCu;
		this.soMoi = soMoi;
	}

	private int getHeSo() {
		if (loaiSd.equals("KD"))
			return 3;
		else if (loaiSd.equals("NN"))
			return 5;
		else if (loaiSd.equals("TT"))
			return 4;
		else
			return 2;
	}

	public double thanhTien() {
		return (soMoi - soCu) * getHeSo() * 550;
	}

	public double getPhuTroi() {
		if (soMoi - soCu > 100)
			return Math.round(thanhTien());
		else if (soMoi - soCu >= 50)
			return Math.round(thanhTien() * 35 / 100);
		else
			return 0;
	}

	public double getTongTienPhaiTra() {
		return thanhTien() + getPhuTroi();
	}

	@Override
	public String toString() {
		return maKh + " " + getHeSo() + " " + df.format(thanhTien()) + " " + df.format(getPhuTroi()) + " "
				+ df.format(getTongTienPhaiTra());
	}

}