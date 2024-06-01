
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class TinhTienPhong {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("KHACHHANG.txt"));
        int t = Integer.parseInt(sc.nextLine());
        List<KhachHang> ds = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while(t-->0){
            String ten = sc.nextLine();
            String soPhong = sc.nextLine();
            Date den = sdf.parse(sc.nextLine());
            Date di = sdf.parse(sc.nextLine());
            double tiendv = Double.parseDouble(sc.nextLine());
            KhachHang kh = new KhachHang(ten, soPhong, den, di, tiendv);
            ds.add(kh);
        }
        ds.sort(new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang o1, KhachHang o2) {
                return Double.compare(o2.getTienPhaiTra(), o1.getTienPhaiTra());
            }
        });
        for(KhachHang kh : ds){
            System.out.println(kh);
        }
        sc.close();
    }
}

class KhachHang{
    private String ma, ten, soPhong;
    private Date ngayNhan, ngayTra;
    private double tienDv;
    private static int STT = 1;
    DecimalFormat df = new DecimalFormat("##.#");

    public KhachHang() {
    }

    public KhachHang(String ten, String soPhong, Date ngayNhan, Date ngayTra, double tienDv) {
        this.ma = "KH"+String.format("%02d", STT++);
        this.ten = chuanHoaTen(ten);
        this.soPhong = soPhong;
        this.ngayNhan = ngayNhan;
        this.ngayTra = ngayTra;
        this.tienDv = tienDv;
    }
    
    public String chuanHoaTen(String s){
        String w[] = s.trim().split("\\s+");
        String res = "";
        for(String x : w){
            res+=Character.toUpperCase(x.charAt(0))+x.substring(1).toLowerCase()+" ";
        }
        return res;
    }
    
    public long getSoNgayO(){
        return (ngayTra.getTime()-ngayNhan.getTime())/(24*60*60*1000)+1;
    }
    
    public double getTienTheoDonGia(){
        if(soPhong.substring(0,1).equals("1")) return 200000*getSoNgayO();
        else if(soPhong.substring(0,1).equals("2")) return 300000*getSoNgayO();
        else return 400000*getSoNgayO();
    }
    
    public double getTienPhaiTra(){
        return getTienTheoDonGia()+tienDv;
    }

    @Override
    public String toString() {
        return ma+" "+ten+" "+soPhong+" "+getSoNgayO()+" "+df.format(getTienPhaiTra());
    }
    
}