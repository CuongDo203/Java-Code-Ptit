
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class LichGiangDayTheoGiangVien {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int t = Integer.parseInt(sc.nextLine());
        List<MonHoc> dsMh = new ArrayList<>();
        while(t-->0){
            String maMh = sc.nextLine();
            String tenMh = sc.nextLine();
            int soTin = Integer.parseInt(sc.nextLine());
            dsMh.add(new MonHoc(maMh, tenMh, soTin));
        }
        sc = new Scanner(new File("LICHGD.in"));
        t = Integer.parseInt(sc.nextLine());
        List<NhomLopHp> dsHp = new ArrayList<>();
        while(t-->0){
            String maMon = sc.nextLine();
            int thu = Integer.parseInt(sc.nextLine());
            int kip = Integer.parseInt(sc.nextLine());
            String tenGv = sc.nextLine();
            String lop = sc.nextLine();
            NhomLopHp hp = new NhomLopHp(maMon, thu, kip, tenGv, lop, dsMh);
            dsHp.add(hp);
        }
        dsHp.sort(new Comparator<NhomLopHp>() {
            @Override
            public int compare(NhomLopHp o1, NhomLopHp o2) {
                if(o1.getNgayGiangDay()==o2.getNgayGiangDay()){
                    if(o1.getKip()==o2.getKip()){
                        return o1.getTenGv().compareTo(o2.getTenGv());
                    }
                    else{
                        return o1.getKip()-o2.getKip();
                    }
                }
                else{
                    return o1.getNgayGiangDay()-o2.getNgayGiangDay();
                }
            }
        });
        String s =  sc.nextLine();
        System.out.println("LICH GIANG DAY GIANG VIEN "+s+":");
        for(NhomLopHp hp : dsHp){
            if(hp.getTenGv().equalsIgnoreCase(s)){
                System.out.println(hp);
            }
        }
        sc.close();
    }
    
}
 
class MonHoc{
    private String maMon, tenMon;
    private int soTin;

    public MonHoc(String maMon, String tenMon, int soTin) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.soTin = soTin;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getSoTin() {
        return soTin;
    }

    public void setSoTin(int soTin) {
        this.soTin = soTin;
    }

    @Override
    public String toString() {
        return "MonHoc{" + "maMon=" + maMon + ", tenMon=" + tenMon + ", soTin=" + soTin + '}';
    }
    
}

class NhomLopHp {
    private String maNhom, maMon;
    private int ngayGiangDay, kip;
    private String tenGv, phongHoc;
    private static int STT=1;
    private MonHoc monHoc;

    public NhomLopHp(String maMon, int ngayGiangDay, int kip, String tenGv, String phongHoc, List<MonHoc> dsMh) {
        this.maNhom = String.format("HP%03d", STT++);
        this.maMon = maMon;
        this.ngayGiangDay = ngayGiangDay;
        this.kip = kip;
        this.tenGv = tenGv;
        this.phongHoc = phongHoc;
        for(MonHoc tmp : dsMh){
            if(tmp.getMaMon().equals(this.maMon)){
                this.monHoc = tmp;
                break;
            }
        }
    }

    public int getNgayGiangDay() {
        return ngayGiangDay;
    }

    public void setNgayGiangDay(int ngayGiangDay) {
        this.ngayGiangDay = ngayGiangDay;
    }

    public int getKip() {
        return kip;
    }

    public void setKip(int kip) {
        this.kip = kip;
    }

    public String getTenGv() {
        return tenGv;
    }
    
    @Override
    public String toString(){
        return maNhom+" "+monHoc.getTenMon()+" "+ngayGiangDay+" "+kip+" "+phongHoc;
    }
}