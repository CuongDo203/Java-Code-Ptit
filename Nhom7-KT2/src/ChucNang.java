
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public interface ChucNang {
    public void nhapGDVang(Scanner in);
    public void nhapGDTT(Scanner in);
    public void out();
    
    public void xoa(String ma);
    public void suaVang(String ma,Scanner in);
    public void timVangTheoLoai(String loaiVang);
}
