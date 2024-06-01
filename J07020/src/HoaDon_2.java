
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class HoaDon_2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("KH.in"));
        int t = Integer.parseInt(sc.nextLine());
        List<KhachHang> dsKh = new ArrayList<>();
        while(t-->0){
            String ten = sc.nextLine();
            String gt = sc.nextLine();
            String ns = sc.nextLine();
            String dchi = sc.nextLine();
            dsKh.add(new KhachHang(ten, gt, ns, dchi));
        }
        List<MatHang> dsMh = new ArrayList<>();
        sc = new Scanner(new File("MH.in"));
        t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String tenmh = sc.nextLine();
            String dvi = sc.nextLine();
            double mua = Double.parseDouble(sc.nextLine());
            double ban = Double.parseDouble(sc.nextLine());
            dsMh.add(new MatHang(tenmh, dvi, mua, ban));
        }
        List<HoaDon> dsHd = new ArrayList<>();
        sc = new Scanner(new File("HD.in"));
        t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String maKh = sc.next();
            String maMh = sc.next();
            int soLuong = Integer.parseInt(sc.nextLine().trim());
            dsHd.add(new HoaDon(maKh, maMh, soLuong, dsKh, dsMh));
        }
        for(HoaDon x : dsHd){
            System.out.println(x);
        }
        sc.close();
    }
    
}

class KhachHang{
    private String maKh, tenKh, gioiTinh, ns, dchi;
    private static int STT1 = 1;

    public KhachHang(String tenKh, String gioiTinh, String ns, String dchi) {
        this.maKh = String.format("KH%03d", STT1++);
        this.tenKh = tenKh;
        this.gioiTinh = gioiTinh;
        this.ns = ns;
        this.dchi = dchi;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }

    public String getDchi() {
        return dchi;
    }

    public void setDchi(String dchi) {
        this.dchi = dchi;
    }
    
}

class MatHang{
    private String maMh, tenMh, donVi;
    private double giaMua, giaBan;
    private static int STT2=1;

    public MatHang(String tenMh, String donVi, double giaMua, double giaBan) {
        this.maMh = String.format("MH%03d", STT2++);
        this.tenMh = tenMh;
        this.donVi = donVi;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public String getMaMh() {
        return maMh;
    }

    public void setMaMh(String maMh) {
        this.maMh = maMh;
    }

    public String getTenMh() {
        return tenMh;
    }

    public void setTenMh(String tenMh) {
        this.tenMh = tenMh;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public double getGiaMua() {
        return giaMua;
    }

    public void setGiaMua(double giaMua) {
        this.giaMua = giaMua;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
    
}

class HoaDon{
    private String maHd;
    private KhachHang kh;
    private MatHang mh;
    private int soLuong;
    private static int STT3=1;

    public HoaDon(String maKh,String maMh, 
            int soLuong, List<KhachHang> dsKh, List<MatHang> dsMh) {
        this.maHd = String.format("HD%03d", STT3++);
        for(KhachHang x : dsKh){
            if(x.getMaKh().equals(maKh)){
                this.kh = x;
                break;
            }
        }
        for(MatHang x : dsMh){
            if(x.getMaMh().equals(maMh)){
                this.mh = x;
                break;
            }
        }
        this.soLuong = soLuong;
    }
    
    public double getThanhTien(){
        return this.mh.getGiaBan()*this.soLuong;
    }
    
    @Override
    public String toString(){
        return this.maHd+" "+this.kh.getTenKh()+" "+ this.kh.getDchi()+" "+this.mh.getTenMh()
                +" "+this.mh.getDonVi()+" "+String.format("%.0f",this.mh.getGiaMua())+" "
                +String.format("%.0f", this.mh.getGiaBan())+" "+this.soLuong+" "+
                String.format("%.0f",this.getThanhTien());
    }
}