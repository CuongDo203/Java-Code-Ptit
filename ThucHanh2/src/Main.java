import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Bao b=new Bao("Hoa hoc tro", "Tien Phong", "02/04/2023", 23000, 100);
        System.out.println(b);
        SachHoc s=new SachHoc("Toan cao cap", "Nhat tue", 120, "Giao duc", 80000, 300);
        System.out.println(s);
	}
}

class TuLieu{
	private String ma, tenNhaXB;
	private double gia;
	private int soLuong;
	private static int STT = 1;
	
	public TuLieu() {
		super();
	}

	public TuLieu(String tenNhaXB, double gia, int soLuong) {
		this.tenNhaXB = tenNhaXB;
		this.gia = gia;
		this.soLuong = soLuong;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public void setMa() {
		this.ma = String.format("%03d", STT++);
	}
	
	public String getTenNhaXB() {
		return tenNhaXB;
	}

	public void setTenNhaXB(String tenNhaXB) {
		this.tenNhaXB = tenNhaXB;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
}

interface ITuLieu{
	public double getGia();
}

class Bao extends TuLieu implements ITuLieu{
	private String ngay, ten;

	public Bao() {
		super();
	}

	public Bao(String ten, String tenNhaXB, String ngay, double gia, int soLuong) {
		super(tenNhaXB, gia, soLuong);
		this.ngay = ngay;
		this.ten = ten;
		super.setMa();
		super.setMa(ten.substring(0,1).toUpperCase()+super.getMa());
	}

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	public String getNam() {
		return this.ngay.substring(6);
	}
	
	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public double getGia() {
		double gia = super.getGia();
		if(super.getSoLuong()>200) {
			gia = super.getGia()-super.getGia()*0.05;
		}
		if(Integer.parseInt(ngay.substring(3,5)) == 1
				|| Integer.parseInt(ngay.substring(3,5)) == 2) {
			gia = gia-gia*0.05;
		}
		return Math.round(gia);
	}
	
	@Override
	public String toString() {
		return super.getMa()+" "+ten+" "+ngay+" "+ super.getTenNhaXB()+" "+(int)getGia();
	}
}

class SachHoc extends TuLieu implements ITuLieu{
	private String ten, tenTG;
	private int soTrang;
	public SachHoc() {
		super();
	}
	public SachHoc(String ten, String tenTG, int soTrang, String tenNhaXB, double gia, int soLuong) {
		super(tenNhaXB, gia, soLuong);
		this.ten = ten;
		this.tenTG = tenTG;
		this.soTrang = soTrang;
		String w[] = ten.trim().split("\\s+");
		super.setMa();
		super.setMa(w[0].toUpperCase()+super.getMa());
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getTenTG() {
		return tenTG;
	}
	public void setTenTG(String tenTG) {
		this.tenTG = tenTG;
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	
	public double getGia() {
		double gia = super.getGia();
		if(soTrang>=0&& soTrang<=300) {
			gia = super.getGia()-super.getGia()*0.05;
		}
		else if(soTrang <= 500) {
			gia = super.getGia()-super.getGia()*0.1;
		}
		else {
			gia= super.getGia()-super.getGia()*0.15;
			if(super.getSoLuong()>500) {
				gia = gia-gia*0.1;
			}
			
		}
		return Math.round(gia);
	}
	
	@Override
	public String toString() {
		return super.getMa()+" "+ten+" "+super.getTenNhaXB()+" "+soTrang+" "+(int)getGia();
	}
}

class QuanLyTuLieu{
	private List<TuLieu> list;

	public QuanLyTuLieu() {
		this.list = new ArrayList<>();
	}

	public List<TuLieu> getList() {
		return list;
	}

	public void setList(List<TuLieu> list) {
		this.list = list;
	}
	
	public void nhapBao(Scanner sc) {
		String ten = sc.nextLine();
		String tenNhaXB = sc.nextLine();
		String ngayRaBao = sc.nextLine();
		double gia = Double.parseDouble(sc.nextLine());
		int soLuong = Integer.parseInt(sc.nextLine());
		Bao b = new Bao(ten, tenNhaXB, ngayRaBao, gia, soLuong);
		this.list.add(b);
	}
	
	public void nhapSachHoc(Scanner sc) {
		String ten = sc.nextLine();
		String tenTG = sc.nextLine();
		int soTrang = Integer.parseInt(sc.nextLine());
		String nhaXB = sc.nextLine();
		double gia = Double.parseDouble(sc.nextLine());
		int soLuong = Integer.parseInt(sc.nextLine());
		SachHoc sh = new SachHoc(ten, tenTG, soTrang, nhaXB, gia, soLuong);
		this.list.add(sh);
	}
	
	public void sapxepBaoTheoNgay(int nam) {
		List<Bao> bao = new ArrayList<>();
		for(TuLieu tl : list) {
			if(tl instanceof Bao) {
				bao.add((Bao) tl);
			}
		}
		List<Bao> res = new ArrayList<>();
		for(Bao b : bao) {
			if(Integer.parseInt(b.getNgay().substring(b.getNgay().lastIndexOf('/')+1))==nam) {
				res.add(b);
			}
		}
		res.sort(new Comparator<Bao>() {

			@Override
			public int compare(Bao o1, Bao o2) {
				int nam1 = Integer.parseInt(o1.getNgay().substring(o1.getNgay().lastIndexOf('/')+1));
				int thang1 = Integer.parseInt(o1.getNgay().substring(3, 5));
				int ngay1 = Integer.parseInt(o1.getNgay().substring(0,2));
				int nam2 = Integer.parseInt(o2.getNgay().substring(o2.getNgay().lastIndexOf('/')+1));
				int thang2 = Integer.parseInt(o2.getNgay().substring(3, 5));
				int ngay2 = Integer.parseInt(o2.getNgay().substring(0,2));
				if(nam1==nam2) {
					if(thang1==thang2) {
						return ngay1-ngay2;
					}
					else {
						return thang1-thang2;
					}
				}
				else {
					return nam1-nam2;
				}
			}
		});
		for(Bao b : res) {
			System.out.println(b);
		}
	}
	
	public void thongkeBao() {
		List<Bao> bao = new ArrayList<>();
		for(TuLieu tl : list) {
			if(tl instanceof Bao) {
				bao.add((Bao) tl);
			}
		}
		Map<String, Integer> mp = new TreeMap<>();
		for(Bao b : bao) {
			if(mp.containsKey(b.getNam())) {
				mp.put(b.getNam(), mp.get(b.getNam())+b.getSoLuong());
			}
			else {
				mp.put(b.getNam(), b.getSoLuong());
			}
		}
		for(String nam : mp.keySet()) {
			System.out.println(nam+":"+mp.get(nam));
		}
	}
	
	public void thongKeBaoTheoNam() {
		List<Bao> bao = new ArrayList<>();
		for(TuLieu tl : list) {
			if(tl instanceof Bao) {
				bao.add((Bao) tl);
			}
		}
		Map<String, Integer> mp = bao.stream().collect(
				Collectors.groupingBy(Bao::getNam, Collectors.summingInt(Bao::getSoLuong)));
		for(String s : mp.keySet()) {
			System.out.println(s+":"+mp.get(s));
		}
	}
	
	public void thongKeSachNhieuTrangNhat() {
		List<SachHoc> sach = new ArrayList<>();
		for(TuLieu tl : list) {
			if(tl instanceof SachHoc) {
				sach.add((SachHoc) tl);
			}
		}
		Optional<SachHoc> maxn = sach.stream().collect(Collectors.maxBy(
				Comparator.comparing(SachHoc::getSoTrang)));
		System.out.println("Sach co so trang nhieu nhat la "+(maxn.isPresent()?maxn.get():"Khong ton tai"));
	}
	
	public void thongKeSachCoSoTrangLonTheoNxb() {
		List<SachHoc> sach = new ArrayList<>();
		for(TuLieu tl : list) {
			if(tl instanceof SachHoc) {
				sach.add((SachHoc) tl);
			}
		}
		Map<String, SachHoc> mp = sach.stream().collect(
				Collectors.groupingBy(SachHoc::getTenNhaXB, Collectors.collectingAndThen(
						Collectors.reducing((SachHoc s1, SachHoc s2)->
						s1.getSoTrang()>s2.getSoTrang()?s1:s2), Optional::get)));
		for(String s : mp.keySet()) {
			System.out.println(s+":"+mp.get(s));
		}
		
	}
	
	public void out() {
		for(TuLieu tl : this.list) {
			System.out.println(tl);
		}
	}
}