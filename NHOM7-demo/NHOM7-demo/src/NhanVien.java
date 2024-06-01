
import java.util.Calendar;
import java.util.Scanner;

public class NhanVien {
    //thuoc tinh
    private  String ma;
    private String hoten;
    private double luong;
    private boolean gtinh;
    private int tuoi;
    private boolean ttrang;

    public NhanVien() {
    }

    public NhanVien(String ma, String hoten, double luong, 
            boolean gtinh, int tuoi) {
        this.ma = ma;
        this.hoten = hoten;
        this.luong = luong;
        this.gtinh = gtinh;
        this.tuoi = tuoi;
        if(gtinh && tuoi>62){
            ttrang=false;
        }else if(gtinh && tuoi<=62){
            ttrang=true;
        }else if(!gtinh && tuoi<=60){
            ttrang=true;
        }else{
            ttrang=false;
        }
    }

    public NhanVien(String ma) {
        this.ma = ma;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public boolean isGtinh() {
        return gtinh;
    }

    public void setGtinh(boolean gtinh) {
        this.gtinh = gtinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    
    //contructors
    //defauft contructor
//    public NhanVien(){
//        
//    }
//    public NhanVien(String ma){
//        this.ma=ma;
//    }
//    public NhanVien(String ma,String hoten,double luong,
//            boolean gtinh,int tuoi){
//        this.hoten=hoten;
//        
//        
//        if(gtinh && tuoi>62){
//            ttrang=false;
//        }else if(gtinh && tuoi<=62){
//            ttrang=true;
//        }else if(!gtinh && tuoi<=60){
//            ttrang=true;
//        }else{
//            ttrang=false;
//        }
//    }
//    //ma 
//    public void setMa(String ma){
//        this.ma=ma;
//    }
//    public String getMa(){
//        return ma;
//    }
//    public void setTtrang(boolean ttrang){
//        this.ttrang=ttrang;
//    }
//    //tuoi
//    public int getTuoi(){
//        return tuoi;
//    }
    //nam sinh
    public int getNamSinh(){
        //hom nay
        Calendar c=Calendar.getInstance();
        int y=c.get(Calendar.YEAR);
        return (y-tuoi);
    }
    public boolean isTtrang(){
        boolean ttrang=false;
        if(gtinh && tuoi>62){
            ttrang=false;
        }else if(gtinh && tuoi<=62){
            ttrang=true;
        }else if(!gtinh && tuoi<=60){
            ttrang=true;
        }else{
            ttrang=false;
        }
        return ttrang;
    }
    
    @Override
    public String toString(){
        return ma+"\t"+hoten+"\t"+(gtinh?"Nam":"Nu")+"\t"+tuoi+(isTtrang()?"lam viec":"nghi");
    }
    public void input(){
        Scanner sc=new Scanner(System.in);
        //nhap ma,hoten,luong gtinh tuoi
        System.out.print("ma:");
        ma=sc.nextLine();
        
    }
    
}
