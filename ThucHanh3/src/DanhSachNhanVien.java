
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class DanhSachNhanVien {
     public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("nhanvien.dat"));
         List<NhanVien> ds = new ArrayList<>();
        while(sc.hasNextLine()){
            String s[] = sc.nextLine().trim().split("\\/");
            String ma = s[0];
            String ten = s[1];
            boolean gt = Boolean.parseBoolean(s[2]);
            double luong = Double.parseDouble(s[3]);
            ds.add(new NhanVien(ma, ten, gt, luong));
        }
        ds.sort(new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                return o1.getHoTen().compareToIgnoreCase(o2.getHoTen());
            }
        });
        for(NhanVien nv : ds){
            System.out.println(nv);
        }
        sc.close();
    }
}

class NhanVien{
    private String ma, ten;
    private boolean gt;
    private double luong;
    DecimalFormat df = new DecimalFormat("##.#");
    public NhanVien() {
    }

    public NhanVien(String ma, String ten, boolean gt, double luong) {
        this.ma = ma;
        this.ten = ten;
        this.gt = gt;
        this.luong = luong;
    }

    public String getHoTen(){
        String w[] = this.ten.split("\\s+");
        String res = w[w.length-1];
        String tmp = "";
        for(int i = 0; i < w.length-1; i++){
            tmp += w[i];
        }
        return res+tmp;
    }
    
    @Override
    public String toString() {
        return ma+" "+ten+" "+((gt==true)?"nam":"nu")+" "+df.format(luong);
    }
    
}
