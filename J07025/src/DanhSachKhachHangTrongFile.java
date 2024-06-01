
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class DanhSachKhachHangTrongFile {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        List<KhachHang> ds = new ArrayList<>();
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            ds.add(new KhachHang(sc.nextLine(), 
                    sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        ds.sort(new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang o1, KhachHang o2) {
                return o1.compare().compareTo(o2.compare());
            }
        });
        for(KhachHang kh : ds){
            System.out.println(kh);
        }
        sc.close();
    }
    
}

class KhachHang{
    private String ma, ten, gioiTinh, ngaySinh, diaChi;
    private static int STT = 1;
    
    public KhachHang() {
    }

    public KhachHang(String ten, String gioiTinh, String ngaySinh, String diaChi) {
        this.ma = String.format("KH%03d", STT++);
        this.ten = chuanHoaTen(ten);
        this.gioiTinh = gioiTinh;
        this.ngaySinh = chuanHoaNgaySinh(ngaySinh);
        this.diaChi = diaChi;
    }
    
    private String chuanHoaTen(String s){
        String w[] = s.trim().split("\\s+");
        String res = "";
        for(String x : w){
            res += Character.toUpperCase(x.charAt(0))+x.substring(1).toLowerCase()+" ";
        }
        res = res.trim();
        return res;
    }
    
    public String compare(){
        String w[] = this.ngaySinh.split("\\/");
        String res = "";
        for(int i = w.length-1; i >=0; i--){
            res += w[i];
        }
        return res;
    }
    
    private String chuanHoaNgaySinh(String s){
        if(s.charAt(1)=='/'){
            s = "0" + s;
        }
        if(s.charAt(4)=='/'){
            s = s.substring(0,3)+"0"+s.substring(3);
        }
        return s;
    }
    
    public String toString(){
        return ma+" "+ten+" "+gioiTinh+" "+diaChi+" "+ngaySinh;
    }
}