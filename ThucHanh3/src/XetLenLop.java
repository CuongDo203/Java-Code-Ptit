
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class XetLenLop {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/diemthi.dat"));
        int t = Integer.parseInt(sc.nextLine());
        List<HocSinh> ds = new ArrayList<>();
        while(t-->0){
            String ten = sc.nextLine();
            String d[] = sc.nextLine().trim().split("\\s+");
            String cv = sc.nextLine();
            HocSinh hs = new HocSinh(ten, Double.parseDouble(d[0]), Double.parseDouble(d[1]), Double.parseDouble(d[2]), cv);
            ds.add(hs);
        }
        for(HocSinh hs : ds){
            System.out.println(hs);
        }
        sc.close();
    }
}

class HocSinh{
    private String ma, ten;
    private double dtoan, dvan, danh;
    private String chucvu;
    private static int STT = 1;
    DecimalFormat df = new DecimalFormat("##.#");

    public HocSinh() {
    }

    public HocSinh(String ten, double dtoan, double dvan, double danh, String chucvu) {
        this.ma = "HS"+String.format("%03d", STT++);
        this.ten = chuanHoaTen(ten);
        this.dtoan = dtoan;
        this.dvan = dvan;
        this.danh = danh;
        this.chucvu = chucvu;
    }
    
    public double getGpa(){
        return (dtoan+dvan+danh)/3 + getUuTien();
    }
    
    public String chuanHoaTen(String s){
        String w[] = s.trim().split("\\s+");
        String res = "";
        for(String x : w){
            res+=Character.toUpperCase(x.charAt(0))+x.substring(1).toLowerCase()+" ";
        }
        res = res.substring(0, res.length()-1);
        return res;
    }
    
    public double getUuTien(){
        if(chucvu.equals("LT")){
            return 0.4;
        }
        else if(chucvu.equals("LP")||chucvu.equals("BT")){
            return 0.2;
        }
        else{
            return 0;
        }
    }
    
    public String getXepLoai(){
           String xl = "Gioi";
           if(getGpa()<5||dtoan*dvan*danh==0) xl = "HOC LAI";
           else if(getGpa()<6.5||dtoan<5||danh<5||dvan<5) xl = "Trung binh";
           else if(getGpa()<8) xl = "Kha";
           return xl;
    }

    @Override
    public String toString() {
        return ma+" "+ten+" "+String.format("%.1f", getGpa())+" "+getXepLoai();
    }
    
}