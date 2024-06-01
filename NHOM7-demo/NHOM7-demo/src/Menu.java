/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//nhap vao tu ban phim co dinh dang
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
       NhanVien nv=new NhanVien();
        while (true) {
            System.out.print("""
                    1. Nhập vao 1 nhan vien
                    2. viet ra em ay
                    3. lay ra nam sinh
                    4. dat lai tuoi
                    5. lay ra luong
                    6. dat lai gioi tinh
                    7. Lay ra tinh trang 
                    0. Thoat        
                             """);
            System.out.print("lua chon (0->7): ");
            int chon;
            Scanner sc=new Scanner(System.in);
            chon=sc.nextInt();
            switch (chon) {
                case 0->{
                    System.out.println("Bye!!");
                    System.exit(0);
                }
                case 1->{
                    nv.input();
                }
                case 2->{
                    System.out.println(nv);
                }
                case 3->{
                    System.out.println(nv.getNamSinh());
                }
                case 4->{
                    System.out.print("Nhap tuoi moi:");
                    int t=sc.nextInt();
                    nv.setTuoi(t);
                }
                case 5->{
                    System.out.println(nv);
                }
                case 6->{
                    System.out.println(nv);
                }
                case 7->{
                    System.out.println(nv);
                }
                default-> System.out.println("cho chon 0->7");
            }
        }
    }
}
