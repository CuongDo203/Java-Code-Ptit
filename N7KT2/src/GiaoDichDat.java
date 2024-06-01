
public class GiaoDichDat extends GiaoDich implements IGiaoDich {
	
	private int loaiDat, heSo;
	
	public GiaoDichDat(String ngay,double gia, int soLuong, int loaiDat) {
		super(ngay, gia, soLuong);
		this.loaiDat = loaiDat;
		if(loaiDat == 1) {
			this.heSo = 200;
		}
		else if(loaiDat == 2) {
			this.heSo = 400;
		}
		else {
			this.heSo = 800;
		}
	}

	public void setMa() {
		super.setMa();
		setMa("D-"+super.getMa());
	}

	@Override
	public double getThanhTien() {
		return super.getGia()*super.getSoluong()*this.heSo;
	}

	@Override
	public String toString() {
		return getMa() +" "+getNgay()+" "+getSoluong()+" "+getThanhTien();
	}

}
