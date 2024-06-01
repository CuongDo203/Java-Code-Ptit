
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TinhGioChuanChoTungGiangVien {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<MonHoc> dsMh = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        while(n-->0){
            String ma = sc.next();
            String tenMh = sc.nextLine().trim();
            dsMh.add(new MonHoc(ma, tenMh));
        }
        List<GiangVien> dsGv = new ArrayList<>();
        int m = Integer.parseInt(sc.nextLine());
        while(m-->0){
            String ma = sc.next();
            String ten = sc.nextLine().trim();
            dsGv.add(new GiangVien(ma, ten));
        }
        int q = Integer.parseInt(sc.nextLine());
        List<LopHocPhan> dsLHP = new ArrayList<>();
        while(q-->0){
            dsLHP.add(new LopHocPhan(sc, dsMh, dsGv));
        }
        String maGv = sc.nextLine();
        for(GiangVien gv : dsGv){
            if(gv.getMa().equalsIgnoreCase(maGv)){
                System.out.println(gv);
            }
        }
        sc.close();
    }
    
}

class MonHoc{
     private String ma, ten;

    public MonHoc() {
    }

    public MonHoc(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
   
 }

class GiangVien{
    private String ma, ten;
    private double tongSoGioGiangDay;
    private List<LopHocPhan> dsLHP;

    public GiangVien() {
    }

    public GiangVien(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
        this.tongSoGioGiangDay = 0;
        this.dsLHP = new ArrayList<>();
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getTongSoGioGiangDay() {
        return tongSoGioGiangDay;
    }

    public void setTongSoGioGiangDay(double soGioGiangDay) {
        this.tongSoGioGiangDay = soGioGiangDay;
    }

    public List<LopHocPhan> getDsLHP() {
        return dsLHP;
    }
    
    @Override
    public String toString(){
        String s = "Giang vien: "+this.ten+"\n";
        for(LopHocPhan tmp : dsLHP)
            s += tmp+"\n";
        return  s + "Tong: "+String.format("%.2f", this.tongSoGioGiangDay);
    }

}

class LopHocPhan{
    private String maGV,maMH;
    private double gioDay;
    private MonHoc monHoc;

    public LopHocPhan(Scanner sc, List<MonHoc> dsMH, List<GiangVien> dsGV) {
        this.maGV = sc.next();
        this.maMH = sc.next().trim();
        this.gioDay = Double.parseDouble(sc.nextLine().trim());
        for(MonHoc tmp : dsMH)
            if(tmp.getMa().contentEquals(this.maMH)){
                this.monHoc = tmp;
                break;
            }
        for(GiangVien tmp : dsGV)
            if(tmp.getMa().contentEquals(this.maGV)){
                tmp.setTongSoGioGiangDay(tmp.getTongSoGioGiangDay()+this.gioDay);
                tmp.getDsLHP().add(this);
                break;
            }
    }

    @Override
    public String toString(){
        return this.monHoc.getTen() + ' ' + String.valueOf(this.gioDay);
    }
}