import java.text.DecimalFormat;
import java.util.Scanner;

public class BaiToanTuyenSinh {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ma = sc.nextLine();
		String ten =sc.nextLine();
		float toan = Float.parseFloat(sc.nextLine());
		float ly = Float.parseFloat(sc.nextLine());
		float hoa = Float.parseFloat(sc.nextLine());
		ThiSinh ts = new ThiSinh(ma, ten, toan, ly, hoa);
		System.out.println(ts);
		sc.close();
	}

}

class ThiSinh{
	private String ma, ten;
	private float dToan, dLy, dHoa;
	
	DecimalFormat df = new DecimalFormat("#.#");
	
	public ThiSinh(String ma, String ten, float dToan, float dLy, float dHoa) {
		this.ma = ma;
		this.ten = ten;
		this.dToan = dToan;
		this.dLy = dLy;
		this.dHoa = dHoa;
	}
	
	public float tinhDiemUuTien() {
		String kv = this.ma.substring(0,3);
		if(kv.equals("KV1")) {
			return 0.5f;
		}
		else if(kv.equals("KV2")) {
			return 1.0f;
		}
		else {
			return 2.5f;
		}
	}
	
	public float tinhTongDiem() {
		return dToan*2+dLy+dHoa;
	}

	@Override
	public String toString() {
		return ma + " " + ten + " " + df.format(tinhDiemUuTien())+" "+df.format(tinhTongDiem())
		+" "+(tinhTongDiem()+tinhDiemUuTien()>=24?"TRUNG TUYEN":"TRUOT");
	}
	
}
