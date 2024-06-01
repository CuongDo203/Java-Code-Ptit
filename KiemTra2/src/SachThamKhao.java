
public class SachThamKhao extends SachHoc implements ISach {
	private boolean loai;

	public SachThamKhao() {
	}

	public SachThamKhao(String ten, String nhaXB, boolean loai, double gia) {
		super(ten, nhaXB, gia);
		this.loai = loai;
	}

	public boolean isLoai() {
		return loai;
	}

	public void setLoai(boolean loai) {
		this.loai = loai;
	}
	
	public double getGia() {
		if(loai==true) {
			return super.getGia() + super.getGia()*0.1;
		}
		else {
			return super.getGia() + super.getGia()*0.15;
		}
	}
	
	public void setMa() {
		super.setMa();
		String s = super.getNhaXB();
		String w[] = s.trim().split("\\s+");
		String res = "";
		for(String x : w) {
			res+=x.charAt(0);
		}
		res=res.toUpperCase();
		setMa(res+super.getMa());
	}

	@Override
	public String toString() {
		return getMa()+" "+getTen()+" "+getNhaXB()+" "+((loai)?"co ban":"nang cao")+" "+(int)getGia();
	}
	
	
}
