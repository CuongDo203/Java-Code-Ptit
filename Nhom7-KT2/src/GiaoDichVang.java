/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class GiaoDichVang extends GiaoDich implements IGiaoDich{
    private String loaiVang;

    public GiaoDichVang() {
    }

    public GiaoDichVang(String ngay, double gia, int soluong,String loaiVang) {
        super(ngay, gia, soluong);
        this.loaiVang = loaiVang;
    }

    public String getLoaiVang() {
        return loaiVang;
    }

    public void setLoaiVang(String loaiVang) {
        this.loaiVang = loaiVang;
    }
    public void setMa(){
        super.setMa();
        setMa("V-"+super.getMa());
    }
    @Override
    public double getThanhTien() {
        return (super.getGia()*super.getSoluong());
    }
    public String toString(){
        //V-001	2/3/2023	100.0	10	9999	1000.0
        return getMa()+" "+getNgay()+" "+getGia()+" "+
                getSoluong()+" "+getLoaiVang()+" "+getThanhTien();
    }
    
}
