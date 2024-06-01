
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BangTinhGioChuan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<MonHoc> dsMh = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        while(n-->0){
            String ma = sc.next();
            String tenMh = sc.nextLine().trim();
            dsMh.add(new MonHoc(ma, tenMh));
        }
        List<GiangVien> dsGv = new ArrayList<>();
        int m = Integer.parseInt(sc.nextLine());
        while(m-->0){
            String ma = sc.next();
            String ten = sc.nextLine().trim();
            dsGv.add(new GiangVien(ma, ten));
        }
        int q = Integer.parseInt(sc.nextLine());
        while(q-->0){
            String maGv = sc.next();
            String maMh = sc.next();
            double soGio = Double.parseDouble(sc.nextLine().trim());
            for(GiangVien x : dsGv){
                if(x.getMa().equals(maGv)){
                    x.setSoGioGiangDay(x.getSoGioGiangDay()+soGio);
                    break;
                }
            }
        }
        for(GiangVien x : dsGv){
            System.out.println(x);
        }
    }
    
}

class MonHoc{
     private String ma, ten;

    public MonHoc() {
    }

    public MonHoc(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
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
 }

class GiangVien{
    private String ma, ten;
    private double soGioGiangDay;

    public GiangVien() {
    }

    public GiangVien(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
        this.soGioGiangDay = 0;
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

    public double getSoGioGiangDay() {
        return soGioGiangDay;
    }

    public void setSoGioGiangDay(double soGioGiangDay) {
        this.soGioGiangDay = soGioGiangDay;
    }
   
    @Override
    public String toString(){
        return String.format("%s %.2f", ten, soGioGiangDay);
    }
}