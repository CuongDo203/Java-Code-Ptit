
public class SachGiaoKhoa extends SachHoc implements ISach {
	private int lop, tap;
	private boolean baitap;
	public SachGiaoKhoa() {
		super();
	}
	public SachGiaoKhoa(String ten, String nhaXB, int lop, int tap, boolean baitap, double gia) {
		super(ten, nhaXB, gia);
		this.lop = lop;
		this.tap = tap;
		this.baitap = baitap;
	}
	public int getLop() {
		return lop;
	}
	public void setLop(int lop) {
		this.lop = lop;
	}
	public int getTap() {
		return tap;
	}
	public void setTap(int tap) {
		this.tap = tap;
	}
	public boolean isBaitap() {
		return baitap;
	}
	public void setBaitap(boolean baitap) {
		this.baitap = baitap;
	}
	
	public double getGia() {
		double gia=super.getGia();
		if(this.getLop()>=1 && this.getLop()<=5) {
			gia =  Math.round(super.getGia()-super.getGia()*0.1) ;
		}
		else {
			if(this.getLop()>=6&&this.getLop()<=10)
				gia = Math.round(super.getGia() - super.getGia()*0.05);
		}
		if(baitap) {
			gia += (gia*0.05);
		}
		return gia;
	}
	
	public void setMa() {
		super.setMa();
		setMa("SGK"+lop+tap+super.getMa());
	}
	@Override
	public String toString() {
		return getMa() + " "+getTen()+" "+getNhaXB()+" "+lop+" "+tap+" "+((baitap)?"bai tap":"ly thuyet")+" "+(int)getGia();
	}
	
	
}
