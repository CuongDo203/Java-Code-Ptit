
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class SapXepKetQuaXetTuyen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        List<NguoiThiTuyen> ds = new ArrayList<>();
        while(t-->0){
            ds.add(new NguoiThiTuyen(sc.nextLine(), sc.nextLine(), 
                    Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
        }
        ds.sort(new Comparator<NguoiThiTuyen>() {
            @Override
            public int compare(NguoiThiTuyen o1, NguoiThiTuyen o2) {
                if(o1.getDiemTb()==o2.getDiemTb()) 
                    return o1.getMa().compareTo(o2.getMa());
                return Double.compare(o2.getDiemTb(), o1.getDiemTb());
            }
        });
        for(NguoiThiTuyen x : ds){
            System.out.println(x);
        }
        sc.close();
    }
    
}

class NguoiThiTuyen{
    private String ma, ten, ngaySinh;
    private double d1, d2;
    private static int STT=1;
    DecimalFormat df = new DecimalFormat("##.#");
    
    public NguoiThiTuyen() {
    }

    public String getMa() {
        return ma;
    }

    public NguoiThiTuyen(String ten, String ngaySinh, double d1, double d2) {
        this.ma = "PH"+String.format("%02d", STT++);
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.d1 = d1;
        this.d2 = d2;
    }
    
    public int getTuoi(){
        String ns = this.ngaySinh.substring(this.ngaySinh.lastIndexOf("/")+1);
        return 2021 - Integer.parseInt(ns);
    }
    
    public double getDiemThuong(){
        if(d1>=8&&d2>=8) return 1;
        else if(d1>=7.5&&d2>=7.5) return 0.5;
        else return 0;
    }
    
    public double getDiemTb(){
        double tb = (d1+d2)/2 + getDiemThuong();
        return (tb>=10) ? 10 : Math.round(tb);
    }
    
    public String getXepLoai(){
        if(getDiemTb()<5) return "Truot";
        else if(getDiemTb()<=6) return "Trung binh";
        else if(getDiemTb()<=7) return "Kha";
        else if(getDiemTb()<=8) return "Gioi";
        else return "Xuat sac";
    }

    @Override
    public String toString() {
        return ma+" "+ten+" "+getTuoi()+" "+df.format(getDiemTb())+" "+getXepLoai();
    }
    
}