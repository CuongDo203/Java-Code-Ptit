/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class GiaoDichTT extends GiaoDich implements IGiaoDich{
    
    private double tigia;
    private String loaiTien;

    public GiaoDichTT() {
    }

    public GiaoDichTT( String ngay, double gia, int soluong,
            double tigia, String loaiTien) {
        super(ngay, gia, soluong);
        this.tigia = tigia;
        this.loaiTien = loaiTien;
    }

    public double getTigia() {
        return tigia;
    }

    public void setTigia(double tigia) {
        this.tigia = tigia;
    }

    public String getLoaiTien() {
        return loaiTien.toUpperCase();
    }

    public void setLoaiTien(String loaiTien) {
        this.loaiTien = loaiTien;
    }
    public void setMa(){
        super.setMa();
        setMa("TT-"+super.getMa());
    }
    
    @Override
    public double getThanhTien() {
        if(getLoaiTien().equalsIgnoreCase("VND")){
            return (super.getGia()*super.getSoluong());
        }else{
            return (super.getGia()*super.getSoluong()*getTigia());
        }
    }
    public String toString(){
        return getMa()+" "+getNgay()+" "+getGia()+" "+
                getSoluong()+" "+getLoaiTien()+" "+getTigia()+" "+getThanhTien();
    }
    
}
