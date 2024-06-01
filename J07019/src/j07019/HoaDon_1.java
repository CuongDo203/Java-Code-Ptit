
package j07019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HoaDon_1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA1.in"));
        int t = Integer.parseInt(sc.nextLine());
        List<SanPham> dsSp = new ArrayList<>();
        while(t-->0){
            String maSp = sc.nextLine();
            String tenSp = sc.nextLine();
            double gia1 = Double.parseDouble(sc.nextLine());
            double gia2 = Double.parseDouble(sc.nextLine());
            dsSp.add(new SanPham(maSp, tenSp, gia1, gia2));
        }
        sc = new Scanner(new File("DATA2.in"));
        t = Integer.parseInt(sc.nextLine());
        List<HoaDon> dsHd = new ArrayList<>();
        while(t-->0){
            String ma = sc.next();
            int soLuong = Integer.parseInt(sc.nextLine().trim());
            dsHd.add(new HoaDon(ma, soLuong, dsSp));
        }
        for(HoaDon x : dsHd){
            System.out.println(x);
        }
        sc.close();
    }
    
}

class SanPham{
    private String maLoai, tenSp;
    private double giaLoai1, giaLoai2;

    public SanPham(String maLoai, String tenSp, double giaLoai1, double giaLoai2) {
        this.maLoai = maLoai;
        this.tenSp = tenSp;
        this.giaLoai1 = giaLoai1;
        this.giaLoai2 = giaLoai2;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
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
    private String maHoaDon;
    private int soLuong;
    private static int STT=1;
    private SanPham sanPham;

    public HoaDon(String maHoaDon, int soLuong, List<SanPham> dsSp) {
        this.maHoaDon =maHoaDon+"-"+String.format("%03d", STT++);
        this.soLuong = soLuong;
        
        String maSp = maHoaDon.substring(0,2);
        for(SanPham sp : dsSp){
            if(sp.getMaLoai().equals(maSp)){
                this.sanPham = sp;
                break;
            }
        }
    }
    
    public double getDonGia(){
        String s = this.maHoaDon.substring(2, 3).trim();
        if(s.equals("1")){
            return this.sanPham.getGiaLoai1();
        }
        else{
            return this.sanPham.getGiaLoai2();
        }
    }
    
    public double getThanhTien(){
        return this.soLuong*this.getDonGia();
    }
    
    public double getGiamGia(){
        if(this.soLuong>=150){
            return getThanhTien()*50/100;
        }
        else if(this.soLuong>=100){
            return getThanhTien()*30/100;
        }
        else if(this.soLuong>=50){
            return getThanhTien()*15/100;
        }
        else{
            return 0;
        }
    }
    
    @Override
    public String toString(){
        return String.format("%s %s %.0f %.0f", this.maHoaDon, this.sanPham.getTenSp(),
                this.getGiamGia(), this.getThanhTien()-getGiamGia());
    }
}