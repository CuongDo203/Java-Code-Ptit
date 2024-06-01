
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class NganHang implements ChucNang{
    private List<GiaoDich> list;

    public NganHang() {
        list=new ArrayList<>();
        GiaoDichVang v=new GiaoDichVang("2/2/2022", 200, 10, "9999");
        v.setMa();
        list.add(v);
        v=new GiaoDichVang("21/9/2023", 120, 8, "24K");
        v.setMa();
        list.add(v);
        GiaoDichTT t=new GiaoDichTT("5/5/2022", 300, 3, 23, "USD");
         t.setMa();
        list.add(t);
    }

    public List<GiaoDich> getList() {
        return list;
    }

    public void setList(List<GiaoDich> list) {
        this.list = list;
    }
    
    @Override
    public void nhapGDVang(Scanner in) {
        GiaoDichVang v=new GiaoDichVang(
                in.nextLine(),
                Double.parseDouble(in.nextLine()),
                Integer.parseInt(in.nextLine()),
                in.nextLine());
        v.setMa();
        list.add(v);
    }

    @Override
    public void nhapGDTT(Scanner in) {
        GiaoDichTT t=new GiaoDichTT();
        t.setNgay(in.nextLine());
        t.setGia(Double.parseDouble(in.nextLine()));
        t.setSoluong(Integer.parseInt(in.nextLine()));
        String loai=in.nextLine();
        t.setLoaiTien(loai);
        double tg;
        if(loai.equalsIgnoreCase("VND")){
            tg=1;
        }else{
            tg=Double.parseDouble(in.nextLine());
        }
        t.setTigia(tg);
        t.setMa();
        list.add(t);
    }

    @Override
    public void out() {
        for(GiaoDich i:list){
            System.out.println(i);
        }
    }

    @Override
    public void xoa(String ma) {
        int t=0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getMa().equalsIgnoreCase(ma)){
                t++;
                System.out.println(list.remove(i));
                break;
            }
        }
//        for(GiaoDich k:list){
//            if(k.getMa().equalsIgnoreCase(ma)){
//                //tim thay
//                t++;
//                list.remove(k);
//                System.out.println("xoa thanh cong!!!");
//                break;
//            }
//        }
        if(t==0){
            System.out.println("thay dau ma xoa");
        }
    }

    @Override
    public void suaVang(String ma, Scanner in) {
        List<GiaoDichVang> lVang=new ArrayList<>();
        //loc vang
        for(GiaoDich k:list){
            if(k instanceof GiaoDichVang){
                lVang.add((GiaoDichVang)k);
            }
        }
        int t=0;
        for (int i = 0; i < lVang.size(); i++) {
            if(lVang.get(i).getMa().equalsIgnoreCase(ma)){
                t++;
                GiaoDichVang v=lVang.get(i);
                System.out.println(v);
                //nhap sua
                v.setNgay(in.nextLine());
                v.setGia(Double.parseDouble(in.nextLine()));
                v.setSoluong(Integer.parseInt(in.nextLine()));
                v.setLoaiVang(in.nextLine());
                
                System.out.println(v);
                System.out.println("sua thanh cong");
            }
        }
        if(t==0){
            System.out.println("Khong tim thay");
        }
        
    }

    @Override
    public void timVangTheoLoai(String loaiVang) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
