import java.util.Scanner;

public class DanhSachDoiTuongNhanVien {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while(t-->0) {
			NhanVien nv = new NhanVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
			System.out.println(nv);
		}
		sc.close();
	}

}

class NhanVien{
	private String ma, ten, gt, ngaySinh, diaChi, mst, ngayKyHd;
	private static int STT=1;
	
	public NhanVien(String ten, String gt, String ngaySinh, String diaChi, String mst, String ngayKyHd) {
		this.ma = String.format("%05d", STT++);
		this.ten = ten;
		this.gt = gt;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.mst = mst;
		this.ngayKyHd = ngayKyHd;
	}

	@Override
	public String toString() {
		return ma + " " + ten + " "+ gt+" "+ngaySinh+
				" "+diaChi+" "+mst+" "+ ngayKyHd;
	}
	
	
}