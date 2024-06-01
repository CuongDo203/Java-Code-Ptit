
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class SapXepHoaDonBanQuanAo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        List<SanPham> dsSp = new ArrayList<>();
        while(t-->0){
            String ma = sc.nextLine();
            String ten =sc.nextLine();
            double giaLoai1 = Double.parseDouble(sc.nextLine());
            double giaLoai2 = Double.parseDouble(sc.nextLine());
            dsSp.add(new SanPham(ma, ten, giaLoai1, giaLoai2));
        }
        int m = Integer.parseInt(sc.nextLine());
        List<HoaDon> ds = new ArrayList<>();
        while(m-->0){
            ds.add(new HoaDon(sc.next(), sc.nextInt()));
        }
        for(HoaDon hd : ds){
            for(SanPham sp : dsSp){
                if(hd.getMa().startsWith(sp.getMa())){
                    hd.setSp(sp);
                    break;
                }
            }
        }
        ds.sort(new Comparator<HoaDon>() {
            @Override
            public int compare(HoaDon o1, HoaDon o2) {
                return Double.compare(o2.getTienPhaiTra(), o1.getTienPhaiTra());
            }
        });
        for(HoaDon hd : ds){
            System.out.println(hd);
        }
        sc.close();
    }
    
}

class SanPham{
    private String ma, ten;
    private double giaLoai1, giaLoai2;

    public SanPham() {
    }

    public SanPham(String ma, String ten, double giaLoai1, double giaLoai2) {
        this.ma = ma;
        this.ten = ten;
        this.giaLoai1 = giaLoai1;
        this.giaLoai2 = giaLoai2;
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

    public double getGiaLoai1() {
        return giaLoai1;
    }

    public void setGiaLoai1(double giaLoai1) {
        this.giaLoai1 = giaLoai1;
    }

    public double getGiaLoai2() {
        return giaLoai2;
    }

    public void setGiaLoai2(double giaLoai2) {
        this.giaLoai2 = giaLoai2;
    }
    
}

class HoaDon{
    private String ma;
    private int soLuong;
    private SanPham sp;
    private static int STT = 1;

    public HoaDon(String ma, int soLuong) {
        this.ma = ma+"-"+String.format("%03d", STT++);
        this.soLuong = soLuong;
    }
    
    public void setSp(SanPham sp){
        this.sp = sp;
    }

    public String getMa() {
        return ma;
    }

    public int getSoLuong() {
        return soLuong;
    }
    
    public double getDonGia(){
        if(Character.valueOf(this.ma.charAt(2)).toString().equals("1")){
            return this.sp.getGiaLoai1();
        }
        else{
            return this.sp.getGiaLoai2();
        }
    }
    
    public double getThanhTien(){
        return this.soLuong*getDonGia();
    }
    
    public double getGiamGia(){
        if(this.soLuong>=150) return 0.5*getThanhTien();
        else if(this.soLuong>=100) return 0.3*getThanhTien();
        else if(this.soLuong>=50) return 0.15*getThanhTien();
        else return 0;
    }
    public double getTienPhaiTra(){
        return getThanhTien()-getGiamGia();
    }
    
    public String toString(){
        return String.format("%s %s %.0f %.0f", ma, sp.getTen(), getGiamGia(), getTienPhaiTra());
    }
}