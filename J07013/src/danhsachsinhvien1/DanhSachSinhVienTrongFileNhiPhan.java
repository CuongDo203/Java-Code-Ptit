package danhsachsinhvien1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class DanhSachSinhVienTrongFileNhiPhan {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SV.in"));
        ArrayList<SinhVien> ds = (ArrayList<SinhVien>) ois.readObject();
        for(SinhVien x : ds){
            System.out.println(x);
        }
    }
    
}
