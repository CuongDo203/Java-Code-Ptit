import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class J07045 {

	public static void main(String[] args) throws IOException{
		ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
	}

}

class LoaiPhong implements Comparable<LoaiPhong>{
	private String kiHieu, tenLoai;
	private int donGia;
	private float phiPhucVu;
	
	public LoaiPhong(String s){
		String w[] = s.trim().split("\\s+");
		this.kiHieu = w[0];
		this.tenLoai = w[1];
		this.donGia = Integer.parseInt(w[2]);
		this.phiPhucVu = Float.parseFloat(w[3]);
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	@Override
	public String toString() {
		return kiHieu + " " + tenLoai + " " + donGia + " " + phiPhucVu;
	}
	
	@Override
	public int compareTo(LoaiPhong o) {
		return tenLoai.compareTo(o.getTenLoai());
	}
}