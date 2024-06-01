
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ChuanHoaDanhSachSinhVien {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int t = Integer.parseInt(sc.nextLine());
        List<SinhVien> ds = new ArrayList<>();
        while(t-->0){
            ds.add(new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), 
                    Double.parseDouble(sc.nextLine())));
        }
        for(SinhVien sv : ds){
            System.out.println(sv);
        }
        sc.close();
    }
    
}

class SinhVien{
    private String ma, ten, ngaySinh, lop;
    private double gpa;
    private static int STT=1;
    DecimalFormat df = new DecimalFormat("##.00");

    public SinhVien() {
    }

    public SinhVien(String ten, String lop, String ngaySinh,double gpa) {
        this.ma = "B20DCCN"+String.format("%03d", STT++);
        this.ten = chuanHoaTen(ten);
        this.ngaySinh = chuanHoaNs(ngaySinh);
        this.lop = lop;
        this.gpa = gpa;
    }
    
    private String chuanHoaTen(String s){
        String w[] = s.trim().split("\\s+");
        String res= "";
        for(String x : w){
            res += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        }
        return res;
    }
    
    private String chuanHoaNs(String s){
        if(s.substring(1,2).equals("/")){
            s = "0"+s;
        }
        if(s.charAt(4)=='/'){
            s = s.substring(0,3)+"0"+s.substring(3);
        }
        return s;
    }

    @Override
    public String toString() {
        return ma+" "+ten+" "+lop+" "+ngaySinh+" "+df.format(gpa);
    }
    
}