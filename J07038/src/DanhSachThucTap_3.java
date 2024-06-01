import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DanhSachThucTap_3 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc;
		sc = new Scanner(new File("src/SINHVIEN.in"));
		int n = Integer.parseInt(sc.nextLine());
		List<SinhVien> dsSv = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			dsSv.add(new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
		}
		dsSv.sort(new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getMaSv().compareTo(o2.getMaSv());
			}
		});
		sc = new Scanner(new File("src/DN.in"));
		int m = Integer.parseInt(sc.nextLine());
		List<DoanhNgiep> dsDn = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			dsDn.add(new DoanhNgiep(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
		}
		sc = new Scanner(new File("src/THUCTAP.in"));
		List<DangKiThucTap> dsTt = new ArrayList<>();
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			String tmp[] = sc.nextLine().trim().split("\\s+");
			dsTt.add(new DangKiThucTap(tmp[0], tmp[1]));
		}
		int q = Integer.parseInt(sc.nextLine());
		while(q-->0) {
			String s = sc.nextLine();
			int sl = 1;
			for(DoanhNgiep dn : dsDn) {
				if(dn.getMaDn().contentEquals(s)) {
					String tmp = dn.getTenDn();
					System.out.println("DANH SACH THUC TAP TAI "+tmp+":");
					sl = dn.getSoSvCoTheNhan();
					break;
				}
			}
			
			for(DangKiThucTap dk : dsTt) {
				if(dk.getMaDn().contentEquals(s)) {
					String maSv = dk.getMaSv();
					for(int i = 0; i < dsSv.size() && i < sl; i++) {
						if(dsSv.get(i).getMaSv().contentEquals(maSv)) {
							System.out.println(dsSv.get(i));
							break;
						}
					}
				}
			}
		}
		sc.close();
	}

}

class SinhVien{
	private String maSv, ten, lop, email;

	public SinhVien(String maSv, String ten, String lop, String email) {
		this.maSv = maSv;
		this.ten = chuanHoaTen(ten);
		this.lop = lop;
		this.email = email;
	}

	private String chuanHoaTen(String s) {
		String w[] = s.trim().split("\\s+");
		String res = "";
		for(String x : w) {
			res += x.substring(0,1).toUpperCase()+x.substring(1).toLowerCase()+" ";
		}
		res = res.substring(0,res.length()-1);
		return res;
	}
	
	public String getMaSv() {
		return maSv;
	}

	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return maSv+ " " + ten+ " "+ lop;
	}
	
}

class DoanhNgiep{
	private String maDn, tenDn;
	private int soSvCoTheNhan;
	
	public DoanhNgiep(String maDn, String tenDn, int soSvCoTheNhan) {
		super();
		this.maDn = maDn;
		this.tenDn = tenDn;
		this.soSvCoTheNhan = soSvCoTheNhan;
	}

	public String getMaDn() {
		return maDn;
	}

	public void setMaDn(String maDn) {
		this.maDn = maDn;
	}

	public String getTenDn() {
		return tenDn;
	}

	public void setTenDn(String tenDn) {
		this.tenDn = tenDn;
	}

	public int getSoSvCoTheNhan() {
		return soSvCoTheNhan;
	}

	public void setSoSvCoTheNhan(int soSvCoTheNhan) {
		this.soSvCoTheNhan = soSvCoTheNhan;
	}
	
}

class DangKiThucTap{
	private String maSv, maDn;

	public DangKiThucTap(String maSv, String maDn) {
		super();
		this.maSv = maSv;
		this.maDn = maDn;
	}

	public String getMaSv() {
		return maSv;
	}

	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}

	public String getMaDn() {
		return maDn;
	}

	public void setMaDn(String maDn) {
		this.maDn = maDn;
	}
	
}


//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//
//public class DanhSachThucTap_3 {
//    private static class SinhVien{
//        private String idSV,tenSV,clas,email;
//
//        SinhVien(Scanner sc) {
//            this.idSV = sc.next();
//            sc.nextLine();
//            this.tenSV = standardName(sc.nextLine());
//            this.clas = sc.nextLine();
//            this.email = sc.nextLine();
//        }
//        static String standardName(String s){
//            s = s.trim().toLowerCase();
//            String res = "" + Character.toUpperCase(s.charAt(0));
//            for(int i=1; i< s.length();i++){
//                if(Character.isLetter(s.charAt(i))){
//                    if(s.charAt(i-1) == ' ') res+= " "+ Character.toUpperCase(s.charAt(i));
//                    else res += s.charAt(i);
//                }
//            }
//            return res;
//        }
//    }
//    private static class DoanhNghiep{
//        private String idDN,tenDN;
//        private int soSVnhan;
//
//        DoanhNghiep(Scanner sc) {
//            this.idDN = sc.next();
//            sc.nextLine();
//            this.tenDN = sc.nextLine();
//            this.soSVnhan = sc.nextInt();
//        }
//    }
//    private static class ThucTap implements Comparable<ThucTap>{
//        private String idSV,idDN;
//        private String tenSV,clas,email;
//        ThucTap(Scanner sc, ArrayList<SinhVien> dsSV){
//            this.idSV =sc.next();
//            this.idDN = sc.next();
//            for(SinhVien tmp : dsSV)
//                if(tmp.idSV.contains(this.idSV)){
//                    this.tenSV = tmp.tenSV;
//                    this.clas = tmp.clas;
//                    this.email = tmp.email;
//                    break;
//                }
//        }
//        @Override
//        public int compareTo(ThucTap o) {
//            return this.idSV.compareTo(o.idSV);
//        }
//        @Override
//        public String toString(){
//            return this.idSV+' '+this.tenSV+' '+this.clas;
//        }
//    }
//    
//    public static void main(String []args) throws FileNotFoundException{
//        ArrayList<SinhVien> dsSV = new ArrayList<>();
//        Scanner sc = new Scanner(new File("src/SINHVIEN.in"));
//        int t = sc.nextInt(); 
//        while(t-->0) dsSV.add(new SinhVien(sc));
//        
//        ArrayList<DoanhNghiep> dsDN = new ArrayList<>();
//        sc = new Scanner(new File("src/DN.in"));
//        t = sc.nextInt(); sc.nextLine();
//        while(t-->0) dsDN.add(new DoanhNghiep(sc));
//        
//        ArrayList<ThucTap> dsTT = new ArrayList<>();
//        sc = new Scanner(new File("src/THUCTAP.in"));
//        t = sc.nextInt();
//        while(t-->0) dsTT.add(new ThucTap(sc,dsSV));
//        Collections.sort(dsTT);
//        t = sc.nextInt();
//        while(t-->0){
//            String idDN = sc.next();
//            int soSVnhan = 1;
//            for(DoanhNghiep tmp : dsDN)
//                if(tmp.idDN.contentEquals(idDN)){
//                    soSVnhan = tmp.soSVnhan;
//                    System.out.printf("DANH SACH THUC TAP TAI %s:\n",tmp.tenDN);
//                    break;
//                }
//            for(ThucTap tmp : dsTT){
//                if(tmp.idDN.contentEquals(idDN)){
//                    soSVnhan--;
//                    System.out.println(tmp);
//                    if(soSVnhan == 0) break;
//                }
//            }
//        }
//    }
//}