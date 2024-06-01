package main;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		LopXau lx = null;
		MaTran m = null;
		SoThuc st = null;
		while(true) {
			System.out.print("""
			0. Thoat
			1. Nhap vao 1 xau
			2. Kiem tra xem xau co phai ma sinh vien hay khong
			3. Tach tu trong xau
			4. Chuan hoa doan van ban
			5. Nhap vao mot ma tran A
			6. Viet ra ma tran chuyen vi cua A
			7. Dua ra cac hang chi co so nguyen to
			8. Nhap vao x va epsilon(la 2 so thuc, co epsilon rat nho)
			9. Tinh cosx		
			""");   
			System.out.print("Moi ban nhap lua chon: ");
			Scanner sc = new Scanner(System.in);
			int chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
				case 0->{
					System.out.println("Cam on vi da su dung ung dung!");
					System.exit(0);
				}
				case 1->{
					lx = new LopXau();
					lx.nhap();
				}
				case 2->{
					if(lx.isMaSinhVien()) {
						System.out.println("Day la mot ma sinh vien");
					}
					else {
						System.out.println("Day khong phai la mot ma sinh vien");
					}
				}
				case 3->{
					lx.tachTu();
				}
				case 4->{
					lx.chuanHoaDoanVanBan();
				}
				case 5->{
					System.out.print("Nhap vao so hang ma tran: ");
					int r = sc.nextInt();
					System.out.println("Nhap vao so cot cua ma tran: ");
					int c = sc.nextInt();
					m = new MaTran(r, c);
					m.nhap();
				}
				case 6->{
					m.vietRaMaTranChuyenVi();
				}
				case 7->{
					m.duaRaCacHangChiCoCacSoNguyenTo();
				}
				case 8->{
					st.nhap();
				}
				case 9->{
					
				}
				default ->{
					System.out.println("Vui long chi chon cac lua chon tu 0 den 9!");
				}
			}
		}
	}

}
