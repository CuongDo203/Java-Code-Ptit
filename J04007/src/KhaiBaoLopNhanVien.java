import java.util.Scanner;

class NhanVien{
	private String maNv, hoTen, gioiTinh, ngaySinh, diaChi, maSoThue, ngayKiHd;

	public NhanVien(String hoTen, String gioiTinh, String ngaySinh, String diaChi, String maSoThue, String ngayKiHd) {
		this.maNv = "00001";
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.maSoThue = maSoThue;
		this.ngayKiHd = ngayKiHd;
	}

	@Override
	public String toString() {
		return maNv + " " + hoTen + " " + gioiTinh + " " +ngaySinh + " " + diaChi + " " + maSoThue + " " + ngayKiHd;
	}
	
}

public class KhaiBaoLopNhanVien {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		String gt = sc.nextLine();
		String ns = sc.nextLine();
		String dc = sc.nextLine();
		String mst = sc.nextLine();
		String nkhd = sc.nextLine();
		NhanVien nv = new NhanVien(name, gt, ns, dc, mst, nkhd);
		System.out.println(nv);
		sc.close();
	}

}

