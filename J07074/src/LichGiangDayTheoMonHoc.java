
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class LichGiangDayTheoMonHoc {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/MONHOC.in"));
        int t = Integer.parseInt(sc.nextLine());
        List<MonHoc> dsMh = new ArrayList<>();
        while(t-->0){
            dsMh.add(new MonHoc(sc.nextLine(), sc.nextLine(), 
            Integer.parseInt(sc.nextLine())));
        }
        sc.close();
        sc = new Scanner(new File("src/LICHGD.in"));
        t = Integer.parseInt(sc.nextLine());
        List<NhomHocPhan> dsHp = new ArrayList<>();
        while(t-->0){
            String maMon = sc.nextLine();
            int thu = Integer.parseInt(sc.nextLine());
            int kip = Integer.parseInt(sc.nextLine());
            String tengv = sc.nextLine();
            String phong = sc.nextLine();
            dsHp.add(new NhomHocPhan(maMon, thu, kip, tengv, phong));
        }
        String s = sc.nextLine();
        dsHp.sort(new Comparator<NhomHocPhan>() {
            @Override
            public int compare(NhomHocPhan o1, NhomHocPhan o2) {
                if(o1.getNgayGiangDay()==o2.getNgayGiangDay()){
                    if(o1.getKipHoc()==o2.getKipHoc())
                        return o1.getTenGv().compareTo(o2.getTenGv());
                    else
                        return o1.getKipHoc()-o2.getKipHoc();
                }
                else{
                    return o1.getNgayGiangDay()-o2.getNgayGiangDay();
                }
            }
        });
        String mon = "";
        for(MonHoc mh : dsMh){
            if(mh.getMaMh().equals(s)){
                mon = mh.getTenMh();
                break;
            }
        }
        System.out.println("LICH GIANG DAY MON "+ mon+":");
        for(NhomHocPhan x : dsHp){
            if(x.getMaMon().equals(s)){
                System.out.println(x);
            }
        }
        sc.close();
    }
   
}

class MonHoc{
    private String maMh, tenMh;
    private int soTin;

    public MonHoc() {
    }

    public MonHoc(String maMh, String tenMh, int soTin) {
        this.maMh = maMh;
        this.tenMh = tenMh;
        this.soTin = soTin;
    }

    public String getTenMh() {
        return tenMh;
    }

    public String getMaMh() {
        return maMh;
    }
    
}

class NhomHocPhan{
    private String maNhom, maMon;
    private int ngayGiangDay, kipHoc;
    private String tenGv, phong;
    private static int STT=1;

    public NhomHocPhan() {
    }

    public NhomHocPhan(String maMon, int ngayGiangDay, int kipHoc, String tenGv, String phong) {
        this.maNhom = String.format("HP%03d", STT++);
        this.maMon = maMon;
        this.ngayGiangDay = ngayGiangDay;
        this.kipHoc = kipHoc;
        this.tenGv = tenGv;
        this.phong = phong;
    }

    public int getKipHoc() {
        return kipHoc;
    }

    public String cmp(){
        String s[] = this.tenGv.trim().split("\\s+");
        String res = s[s.length-1];
        for (int i = 0; i < s.length-1; i++){
            res += s[i];
        }
        return res;
    }
    
    public int getNgayGiangDay() {
        return ngayGiangDay;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setNgayGiangDay(int ngayGiangDay) {
        this.ngayGiangDay = ngayGiangDay;
    }

    public String getTenGv() {
        return tenGv;
    }

    public void setTenGv(String tenGv) {
        this.tenGv = tenGv;
    }
    
    public String toString(){
        return maNhom+" "+ngayGiangDay+" "+kipHoc+" "+tenGv+" "+phong;
    }
}