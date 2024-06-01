
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class QuanLyBanHang_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<KhachHang> dsKh = new ArrayList<>();
        while(n-->0){
            dsKh.add(new KhachHang(sc.nextLine(), sc.nextLine(), sc.nextLine(), 
                    sc.nextLine()));
        }
        int m = Integer.parseInt(sc.nextLine());
        List<MatHang> dsMh = new ArrayList<>();
        while(m-->0){
            dsMh.add(new MatHang(sc.nextLine(), sc.nextLine(),
                    Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine())));
        }
        int q = Integer.parseInt(sc.nextLine());
        List<HoaDon> ds = new ArrayList<>();
        while(q-->0){
            String maKh = sc.next();
            String maMh = sc.next();
            int sl = Integer.parseInt(sc.nextLine().trim());
            HoaDon hd = new HoaDon(sl);
            for(KhachHang x : dsKh){
                if(x.getMa().equals(maKh)){
                    hd.setKh(x);
                    break;
                }
            }
            for(MatHang x : dsMh){
                if(x.getMa().equals(maMh)){
                    hd.setMh(x);
                    break;
                }
            }
            ds.add(hd);
        }
        ds.sort(new Comparator<HoaDon>() {
            @Override
            public int compare(HoaDon o1, HoaDon o2) {
                return Long.compare(o2.getLoiNhuan(), o1.getLoiNhuan());
            }
        });
        ds.forEach(mh -> System.out.println(mh));
        sc.close();
    }
    
}

class KhachHang{
    private String ma, ten, gt, ngaySinh, dchi;
    private static int STT1=1;

    public KhachHang(String ten, String gt, String ngaySinh, String dchi) {
        this.ma = String.format("KH%03d", STT1++);
        this.ten = ten;
        this.gt = gt;
        this.ngaySinh = ngaySinh;
        this.dchi = dchi;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDchi() {
        return dchi;
    }

    public void setDchi(String dchi) {
        this.dchi = dchi;
    }
    
}

class MatHang{
    private String ma, ten, donVi;
    private int giaMua, giaBan;
    private static int STT2 = 1;

    public MatHang(String ten, String donVi, int giaMua, int giaBan) {
        this.ma = String.format("MH%03d", STT2++);
        this.ten = ten;
        this.donVi = donVi;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public int getGiaMua() {
        return giaMua;
    }

    public void setGiaMua(int giaMua) {
        this.giaMua = giaMua;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }
    
}

class HoaDon{
    private String ma;
    private KhachHang kh;
    private MatHang mh;
    private int soLuong;
    private static int STT3=1;

    public HoaDon(int soLuong) {
        this.ma = String.format("HD%03d", STT3++);
        this.soLuong = soLuong;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public MatHang getMh() {
        return mh;
    }

    public void setMh(MatHang mh) {
        this.mh = mh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public long getThanhTien(){
        return this.soLuong*this.mh.getGiaBan();
    }
    
    public long getLoiNhuan(){
        return getThanhTien()-(this.soLuong*mh.getGiaMua());
    }
    
    @Override
    public String toString(){
        return String.format("%s %s %s %s %d %d %d", this.ma,
                kh.getTen(), kh.getDchi(), mh.getTen(),getSoLuong(),
                 getThanhTien(), getLoiNhuan());
    }
}