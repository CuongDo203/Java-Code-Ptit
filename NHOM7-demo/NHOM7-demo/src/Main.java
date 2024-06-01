
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        String s1="Ha";
//        String s2="Ha";
//        String s3=new String("Ha");
//        System.out.println(s1==s2);//true
//        System.out.println(s1==s3);//false
//      Scanner sc=new Scanner(System.in);
//      boolean gt;
//      gt=sc.nextBoolean();
//      int x;
//      x=sc.nextInt();
//      double y=sc.nextDouble();
//      String ma,ten;
//      //next() - String 
//      ma=sc.next();
//      sc.nextLine();//nahn enter
//      ten=sc.nextLine();
//        System.out.println("cac gia tri:"+gt+","+x+","+y+","+ma+" ho va ten:"+ten);
        
        NhanVien nv = new NhanVien();
        NhanVien nv1=new NhanVien("B21DCCN543");
        NhanVien nv2=new NhanVien("B21DCCN654","To an An", 20000, true, 20);
        System.out.println(nv);
        System.out.println(nv1);
        System.out.println(nv2);
    }
}
