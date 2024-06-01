import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cau1 {

	public static void main(String[] args) {
//		SachThamKhao k=new SachThamKhao("toan lop 5","giao duc", true, 50);
//        k.setMa();
//        System.out.println(k);
//        SachGiaoKhoa g=new SachGiaoKhoa("tieng Viet", "dong nai", 4, 1, false, 80);
//        g.setMa();
//        System.out.println(g);
//		QuanLysach q=new QuanLysach();
//        Scanner in = new Scanner(System.in);
//        q.nhapSachThamKhoa(in);
//        q.nhapSachGiaoKhoa(in);
//        q.out();
		QuanLysach q=new QuanLysach();
        List<SachHoc> list=new ArrayList<>();
        SachThamKhao k=new SachThamKhao("toan lop 6","giao duc", false, 45);
        k.setMa();
        list.add(k);
        SachGiaoKhoa g=new SachGiaoKhoa("toan", "dong nai", 5, 1, true, 50);
        g.setMa();
        list.add(g);
        g=new SachGiaoKhoa("tieng viet", "giao duc", 5, 2, false, 60);
        g.setMa();
        list.add(g);
        g=new SachGiaoKhoa("giao duc CD", "giao duc", 6, 1, false, 30);
        g.setMa();
        list.add(g);
        g=new SachGiaoKhoa("Luyen toan", "giao duc", 6, 1, true, 30);
        g.setMa();
        list.add(g);
        g=new SachGiaoKhoa("dia ly", "giao duc", 6, 1, false, 70);
        g.setMa();
        list.add(g);
        g=new SachGiaoKhoa("vat ly", "minh Chau", 9, 1, true, 90);
        g.setMa();
        list.add(g);
        q.setList(list);
        Scanner in=new Scanner(System.in);
        q.xoaSachGiaoKhoa(in.nextLine());
	}

}
