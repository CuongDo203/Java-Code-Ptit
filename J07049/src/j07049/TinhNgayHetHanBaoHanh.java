package j07049;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TinhNgayHetHanBaoHanh {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MUAHANG.in"));
        int t = Integer.parseInt(sc.nextLine());
        List<SanPham> dsSp = new ArrayList<>();
        while(t-->0){
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            double giaBan = Double.parseDouble(sc.nextLine());
            int thoiHan = Integer.parseInt(sc.nextLine());
            dsSp.add(new SanPham(ma, ten, giaBan, thoiHan));
        }
        t = Integer.parseInt(sc.nextLine());
        List<KhachHang> dsKh = new ArrayList<>();
        while(t-->0){
            String ten = sc.nextLine();
            String dchi = sc.nextLine();
            String maSp = sc.nextLine();
            int sl = Integer.parseInt(sc.nextLine());
            String ngayMua = sc.nextLine();
            dsKh.add(new KhachHang(ten, dchi, maSp, sl, ngayMua, dsSp));
        }
        dsKh.sort(new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang o1, KhachHang o2) {
                if(o1.ngayHetBh().equals(o2.ngayHetBh())){
                    return o1.getMaKh().compareTo(o2.getMaKh());
                }
                String t1[] = o1.ngayHetBh().split("\\/");
                String t2[] = o2.ngayHetBh().split("\\/");
                String s1 = t1[2]+t1[1]+t1[0];
                String s2 = t2[2]+t2[1]+t2[0];
                return s1.compareTo(s2);
            }
        });
        for(KhachHang kh : dsKh){
            System.out.println(kh);
        }
        sc.close();
    }
    
}

class SanPham{
    private String ma, ten;
    private double giaBan;
    private int thoiHanBh;

    public SanPham(String ma, String ten, double giaBan, int thoiHanBh) {
        this.ma = ma;
        this.ten = ten;
        this.giaBan = giaBan;
        this.thoiHanBh = thoiHanBh;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public int getThoiHanBh() {
        return thoiHanBh;
    }
    
}

class KhachHang{
    private String maKh, ten, dchi, maSp;
    private int soLuong;
    private String ngayMua;
    private static int STT=1;
    private SanPham sp;

    public KhachHang(String ten, String dchi, String maSp, int soLuong, String ngayMua,
            List<SanPham> dsSp) {
        this.maKh = String.format("KH%02d", STT++);
        this.ten = ten.trim();
        this.dchi = dchi.trim();
        this.maSp = maSp.trim();
        this.soLuong = soLuong;
        this.ngayMua = ngayMua;
        for(SanPham x : dsSp){
            if(x.getMa().equals(maSp)){
                this.sp = x;
                break;
            }
        }
    }
    
    private double getGiaBan(){
        return this.sp.getGiaBan();
    }

    public String getMaKh() {
        return maKh;
    }
    
    public double getTienThanhToan(){
        return getGiaBan()*this.soLuong;
    }
    
    public String ngayHetBh(){
        String s[] = this.ngayMua.split("\\/");
        int d = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int y = Integer.parseInt(s[2]);
        
        int tmp = this.sp.getThoiHanBh()/12;
        int du = this.sp.getThoiHanBh()%12;
        y += tmp;
        m += du;
        if(m>12){
            y++;
            m-=12;
        }
        String ngay = String.format("%02d", d);
        String thang = String.format("%02d", m);
        String nam = String.format("%02d", y);
        return ngay+"/"+thang+"/"+nam;
    }
    
    @Override
    public String toString(){
        return this.maKh+" "+this.ten+" "+dchi+" "+maSp+" "+
                String.format("%.0f", getTienThanhToan())
                +" "+ngayHetBh();
    }
}