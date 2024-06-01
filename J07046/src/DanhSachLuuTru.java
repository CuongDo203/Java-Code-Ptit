import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DanhSachLuuTru {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		Scanner sc = new Scanner(new File("KHACH.in"));
		int n = Integer.parseInt(sc.nextLine());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<KhachHang> dsKh = new ArrayList<>(); 
		for(int i = 1; i <= n; i++) {
			String ten = sc.nextLine();
			String maPhong = sc.nextLine();
			Date den  = sdf.parse(sc.nextLine());
			Date di = sdf.parse(sc.nextLine());
			KhachHang kh = new KhachHang(i+"", ten, maPhong, den, di);
			dsKh.add(kh);
		}
		dsKh.sort(new Comparator<KhachHang>() {
			@Override
			public int compare(KhachHang o1, KhachHang o2) {
				return o2.soNgayLuuTru() - o1.soNgayLuuTru();
			}
		});
		for(KhachHang kh : dsKh) {
			System.out.println(kh);
		}
		sc.close();
	}

}

class KhachHang{
	private String maKh, hoTen, maPhong;
	private Date ngayDen, ngayDi;
	
	public KhachHang(String maKh, String hoTen, String maPhong, Date ngayDen, Date ngayDi) {
		while(maKh.length() < 2) {
			maKh = "0" + maKh;
		}
		this.maKh = "KH"+maKh;
		this.hoTen = hoTen;
		this.maPhong = maPhong;
		this.ngayDen = ngayDen;
		this.ngayDi = ngayDi;
	}
	
	public int soNgayLuuTru(){
		return (int)((this.ngayDi.getTime() - this.ngayDen.getTime())/ (1000 * 60 * 60 * 24));
	}

	@Override
	public String toString() {
		return maKh + " " + hoTen + " " + maPhong + " " + soNgayLuuTru();
	}
	
}
