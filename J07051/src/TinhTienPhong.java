import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TinhTienPhong {

	public static void main(String[] args) throws ParseException, FileNotFoundException {
		Scanner sc = new Scanner(new File("KHACHHANG.in"));
		int n = Integer.parseInt(sc.nextLine());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<KhachHang> dskh = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			String ten = sc.nextLine();
			String soPhong = sc.nextLine();
			Date ngayNhan = sdf.parse(sc.nextLine());
			Date ngayTra = sdf.parse(sc.nextLine());
			int tienDv = Integer.parseInt(sc.nextLine());
			dskh.add(new KhachHang(i+"", ten, soPhong, tienDv, ngayNhan, ngayTra));
		}
		Collections.sort(dskh);
		for(KhachHang kh : dskh) {
			System.out.println(kh);
		}
		sc.close();
	}

}

class KhachHang implements Comparable<KhachHang>{
	private String ma, ten,soPhong;
	private int tienDichVu;
	private Date ngayNhanPhong, ngayTraPhong;
	private int tienPhong;
	
	public KhachHang(String ma, String ten, String soPhong, int tienDichVu, Date ngayNhanPhong, Date ngayTraPhong) {
		while(ma.length() < 2) {
			ma = "0" + ma;
		}
		this.ma = "KH"+ ma;
		this.ten = chuanHoaTen(ten);
		this.soPhong = soPhong;
		String res = soPhong.substring(0,1);
		switch(res) {
			case "1":
	            tienPhong = 25;
	            break;
	        case "2":
	        	tienPhong = 34;
	            break;
	        case "3":
	        	tienPhong = 50;
	            break;
	        case "4":
	        	tienPhong = 80;
	            break;
		}
		this.tienDichVu = tienDichVu;
		this.ngayNhanPhong = ngayNhanPhong;
		this.ngayTraPhong = ngayTraPhong;
	}
	
	private String chuanHoaTen(String s) {
		String []words = s.trim().split("\\s+");
		String res = "";
		for(int i = 0; i < words.length; i++) {
			res += words[i].substring(0,1).toUpperCase() + words[i].substring(1).toLowerCase() + " ";
		}
		res = res.substring(0, res.length()-1);
		return res;
	}
	
	public int getSoNgayLuuTru() {
		return (int)((ngayTraPhong.getTime() - ngayNhanPhong.getTime())/(1000*60*60*24))+1;
	}
	
	public int getTongTien() {
		return tienPhong * getSoNgayLuuTru() + tienDichVu;
	}

	@Override
	public String toString() {
		return ma + " " + ten + " " + soPhong +" "+ getSoNgayLuuTru() + " " + getTongTien();
	}

	@Override
	public int compareTo(KhachHang o) {
		return o.getTongTien() - getTongTien();
	}
	
}