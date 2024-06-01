
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class QuanLyKhoXangDau {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        List<DonHang> ds = new ArrayList<>();
        while(t-->0){
            String s[] = sc.nextLine().trim().split("\\s+");
            DonHang tmp = new DonHang(s[0], Long.parseLong(s[1]));
            ds.add(tmp);
        }
        for(DonHang x : ds){
            System.out.println(x);
        }
        sc.close();
    }
    
}

class DonHang{
    private String ma, hangSx;
    private long soLuong, donGia, thue, thanhTien;
    private double phanTramThue;

    public DonHang(String ma, long soLuong) {
        this.ma = ma;
        this.soLuong = soLuong;
        if(this.ma.startsWith("X")){
                this.phanTramThue = 0.03;
                this.donGia = 128000;
            }else if(this.ma.startsWith("D")){
                this.phanTramThue = 0.035;
                this.donGia = 11200;
            }else{
                this.phanTramThue = 0.02;
                this.donGia = 9700;
            }
            if(this.ma.endsWith("TN")){
                this.hangSx = "Trong Nuoc";
                this.phanTramThue = 0;
            }else if(this.ma.endsWith("BP")){
                this.hangSx = "British Petro";
            }else if(this.ma.endsWith("ES")){
                this.hangSx = "Esso";
            }else if(this.ma.endsWith("SH")){
                this.hangSx = "Shell";
            }else if(this.ma.endsWith("CA")){
                this.hangSx = "Castrol";
            }else this.hangSx = "Mobil";
            this.thue = (long) (this.soLuong*this.donGia *this.phanTramThue);
            this.thanhTien = this.soLuong*this.donGia +this.thue;
    }

    @Override
    public String toString() {
        return ma + " " + hangSx+ " " +donGia+" "+thue+" "+thanhTien;
    }
    
}