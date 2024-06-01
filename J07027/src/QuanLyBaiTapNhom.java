
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class QuanLyBaiTapNhom {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int t = Integer.parseInt(sc.nextLine());
        int k = t;
        List<SinhVien> dsSv = new ArrayList<>();
        while(t-->0){
            String maSv = sc.nextLine();
            String ten = sc.nextLine();
            String sdt = sc.nextLine();
            dsSv.add(new SinhVien(maSv, ten, sdt));
        }
        sc = new Scanner(new File("BAITAP.in"));
        t = Integer.parseInt(sc.nextLine());
        List<BaiTap> dsBt = new ArrayList<>();
        for(int i = 1; i <= t; i++){
            dsBt.add(new BaiTap(i+"", sc.nextLine()));
        }
        sc = new Scanner(new File("NHOM.in"));
        List<Nhom> ds = new ArrayList<>();
        while(k-->0){
            String maSv = sc.next().trim();
            String maNhom = sc.nextLine().trim();
            ds.add(new Nhom(maSv, maNhom, dsSv, dsBt));
        }
        ds.sort(new Comparator<Nhom>() {
            @Override
            public int compare(Nhom o1, Nhom o2) {
                return o1.getMaSv().compareTo(o2.getMaSv());
            }
        });
        for(Nhom x : ds){
            System.out.println(x);
        }
        sc.close();
    }
    
}

class SinhVien{
    private String maSv, ten, sdt;

    public SinhVien(String maSv, String ten, String sdt) {
        this.maSv = maSv;
        this.ten = ten;
        this.sdt = sdt;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
}

class BaiTap{
    String soNhom, tenBt;

    public BaiTap(String soNhom, String tenBt) {
        this.soNhom = soNhom;
        this.tenBt = tenBt;
    }

    public String getTenBt() {
        return tenBt;
    }

    public String getSoNhom() {
        return soNhom;
    }
    
}

class Nhom{
    private String maSv, maNhom;
    private List<SinhVien> sv;
    private BaiTap btap;

    public Nhom(String maSv, String maNhom, List<SinhVien> dsSv, List<BaiTap> dsBt) {
        this.maSv = maSv;
        this.maNhom = maNhom;
        this.sv = new ArrayList<>();
        for(SinhVien sv : dsSv){
            if(sv.getMaSv().equals(maSv)){
                this.sv.add(sv);
                break;
            }
        }
        for(BaiTap x : dsBt){
            if(x.getSoNhom().equals(maNhom)){
                this.btap = x;
                break;
            }
        }
    }

    public String getMaSv() {
        return maSv;
    }

    public String getMaNhom() {
        return maNhom;
    }
    
    public SinhVien getSvByid(String id){
        for(SinhVien x : sv){
            if(x.getMaSv().equals(id)){
                return x;
            }
        }
        return null;
    }
    
    @Override
    public String toString(){
        return this.maSv+" "+this.getSvByid(this.maSv).getTen()+" "
                +this.getSvByid(maSv).getSdt()+" "+maNhom+" "+this.btap.getTenBt();
    }
}