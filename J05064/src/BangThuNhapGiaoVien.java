
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BangThuNhapGiaoVien {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        List<GiaoVien> ds = new ArrayList<>();
//        int t = Integer.parseInt(sc.nextLine());
//        long d1 = 0, d2 = 0;
//        while(t-->0){
//            GiaoVien x = new GiaoVien(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()));
//            if(x.getMa().substring(0,2).equals("HT"))
//                d1++;
//            if(x.getMa().substring(0,2).equals("HP"))
//                d2++;
//            if(d1<=1 && d2 <= 2){
//                ds.add(x);
//            }
//        }
//        
//        for(GiaoVien gv : ds){
//            System.out.println(gv);
//        }
//        sc.close();
            Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()); 
        ArrayList<GiaoVien2> ds = new ArrayList<>();
        while(t-->0){
            GiaoVien2 a = new GiaoVien2(sc.nextLine(),sc.nextLine(), Long.parseLong(sc.nextLine()));
            if(a.canAdd)
                ds.add(a);
        }
        for(GiaoVien2 tmp : ds){
            System.out.println(tmp);
        }
    }
    
}

class GiaoVien{
    private String ma, ten;
    private long luongCb;
    private long bacLuong;
    DecimalFormat df = new DecimalFormat("##.##");

    public GiaoVien() {
    }

    public GiaoVien(String ma, String ten, long luongCb) {
        this.ma = ma;
        this.ten = ten;
        this.luongCb = luongCb;
        this.bacLuong = Long.parseLong(ma.substring(2));
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }
    
    public long getPhuCap(){
        if(this.ma.startsWith("HT"))
            return 2000000;
        else if(this.ma.startsWith("HP"))
            return 900000;
        else 
            return 500000;
    }
    
    public long getThuNhap(){
        return luongCb*bacLuong + getPhuCap();
    }
    
    public String toString(){
        return ma+" "+ten+" "+bacLuong+" "+getPhuCap()+" "+getThuNhap();
    }
}

class GiaoVien2{
    private String id,name;
    private long luongCoBan,heSoLuong,phuCap,thuNhap;
    public boolean canAdd = true;
    private static int soHT = 0;
    private static int soHP = 0;
    
    public GiaoVien2(String id, String name,long luongCoBan) {
        this.id = id;
        if(id.startsWith("HT")){
            soHT++;
            if(soHT>1){
                this.canAdd = false;
                return;
            }
        }
        if(id.startsWith("HP")){
            soHP++;
            if(soHP>2){
                this.canAdd = false;
                return;
            }
        }
        this.name = name;   
        this.luongCoBan = luongCoBan;
        this.heSoLuong = Long.parseLong(this.id.substring(2));
        if(this.id.startsWith("HT")) this.phuCap = 2000000;
        else if(this.id.startsWith("HP")) this.phuCap = 900000;
        else this.phuCap = 500000;
        this.thuNhap = this.luongCoBan*this.heSoLuong + this.phuCap;
    }
    
    @Override
    public String toString(){
        return String.format("%s %s %d %d %d",id,name,heSoLuong,phuCap,thuNhap);
    }
}
/*
6
GV01
Nguyen Kim Loan
1420000
HT05
Hoang Thanh Tuan
1780000
GV02
Tran Binh Nguyen
1468000
HP06
Hoang Thanh Tuan
1780000
HP06
Hoang Thanh Teo
1780000
HP06
Hoang Thanh Tu
1780000
*/