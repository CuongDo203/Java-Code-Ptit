
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class NganHang implements ChucNang{
    private List<GiaoDich> list;

    public NganHang() {
        list=new ArrayList<>();
        GiaoDichVang v=new GiaoDichVang("2/2/2022", 200, 10, "9999");
        v.setMa();
        list.add(v);
        v=new GiaoDichVang("21/9/2023", 120, 8, "24K");
        v.setMa();
        list.add(v);
        GiaoDichTT t=new GiaoDichTT("5/5/2022", 300, 3, 23, "USD");
         t.setMa();
        list.add(t);
        GiaoDichTT t2=new GiaoDichTT("5/5/2022", 300, 30, 1, "VND");
        t2.setMa();
        list.add(t2);
        GiaoDichTT t3=new GiaoDichTT("5/5/2022", 300, 13, 27, "EU");
        t3.setMa();
        list.add(t3);
    }

    public List<GiaoDich> getList() {
        return list;
    }

    public void setList(List<GiaoDich> list) {
        this.list = list;
    }
    
    @Override
    public void nhapGDVang(Scanner in) {
        GiaoDichVang v=new GiaoDichVang(
                in.nextLine(),
                Double.parseDouble(in.nextLine()),
                Integer.parseInt(in.nextLine()),
                in.nextLine());
        v.setMa();
        list.add(v);
    }

    @Override
    public void nhapGDTT(Scanner in) {
        GiaoDichTT t=new GiaoDichTT();
        t.setNgay(in.nextLine());
        t.setGia(Double.parseDouble(in.nextLine()));
        t.setSoluong(Integer.parseInt(in.nextLine()));
        String loai=in.nextLine();
        t.setLoaiTien(loai);
        double tg;
        if(loai.equalsIgnoreCase("VND")){
            tg=1;
        }else{
            tg=Double.parseDouble(in.nextLine());
        }
        t.setTigia(tg);
        t.setMa();
        list.add(t);
    }

    @Override
    public void out() {
        for(GiaoDich i:list){
            System.out.println(i);
        }
    }

    @Override
    public void xoa(String ma) {
        int t=0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getMa().equalsIgnoreCase(ma)){
                t++;
                System.out.println(list.remove(i));
                break;
            }
        }
//        for(GiaoDich k:list){
//            if(k.getMa().equalsIgnoreCase(ma)){
//                //tim thay
//                t++;
//                list.remove(k);
//                System.out.println("xoa thanh cong!!!");
//                break;
//            }
//        }
        if(t==0){
            System.out.println("thay dau ma xoa");
        }
    }

    @Override
    public void suaVang(String ma, Scanner in) {
        List<GiaoDichVang> lVang=new ArrayList<>();
        //loc vang
        for(GiaoDich k:list){
            if(k instanceof GiaoDichVang){
                lVang.add((GiaoDichVang)k);
            }
        }
        int t=0;
        for (int i = 0; i < lVang.size(); i++) {
            if(lVang.get(i).getMa().equalsIgnoreCase(ma)){
                t++;
                GiaoDichVang v=lVang.get(i);
                System.out.println(v);
                //nhap sua
                v.setNgay(in.nextLine());
                v.setGia(Double.parseDouble(in.nextLine()));
                v.setSoluong(Integer.parseInt(in.nextLine()));
                v.setLoaiVang(in.nextLine());
                
                System.out.println(v);
                System.out.println("sua thanh cong");
            }
        }
        if(t==0){
            System.out.println("Khong tim thay");
        }
        
    }

    @Override
    public void timVangTheoLoai(String loaiVang) {
    	List<GiaoDichVang> dsv = new ArrayList<>();
		for(GiaoDich gd : list) {
			if(gd instanceof GiaoDichVang) {
				dsv.add((GiaoDichVang) gd);
			}
		}
		for(GiaoDichVang gdv : dsv) {
			if(gdv.getLoaiVang().equals(loaiVang)) {
				System.out.println(gdv);
			}
		}
    }

	@Override
	public void sapxepGDVangTheoGia() {
		List<GiaoDichVang> dsv = new ArrayList<>();
		for(GiaoDich gd : list) {
			if(gd instanceof GiaoDichVang) {
				dsv.add((GiaoDichVang) gd);
			}
		}
		dsv.sort(new Comparator<GiaoDichVang>() {

			@Override
			public int compare(GiaoDichVang o1, GiaoDichVang o2) {
				if(o1.getThanhTien() < o2.getThanhTien()) {
					return -1;
				}
				return 1;
			}
		});
	}

	@Override
	public void timVangTheoThanhTien(double tu, double den) {
		List<GiaoDichVang> dsv = new ArrayList<>();
		for(GiaoDich gd : list) {
			if(gd instanceof GiaoDichVang) {
				dsv.add((GiaoDichVang) gd);
			}
		}
		System.out.println("Thanh tien vang tu "+tu+" den "+den+"la: ");
		for(GiaoDichVang gdv : dsv) {
			if(gdv.getThanhTien()>=tu && gdv.getThanhTien()<=den) {
				System.out.println(gdv);
			}
		}
	}

	@Override
	public int demGDTTTheoLoaiTien(String loai) {
		int cnt = 0;
		List<GiaoDichTT> dstt = new ArrayList<>();
		for(GiaoDich gd : list) {
			if(gd instanceof GiaoDichTT) {
				dstt.add((GiaoDichTT) gd);
			}
		}
		for(GiaoDichTT gdtt : dstt) {
			if(gdtt.getLoaiTien().equals(loai)) {
				cnt++;
			}
		}
		return cnt;
	}

	@Override
	public double tongTienGDTheoNam(int nam) {
		double sum = 0;
		List<GiaoDichVang> dsv = new ArrayList<>();
		for(GiaoDich gd : list) {
			if(gd instanceof GiaoDichVang) {
				dsv.add((GiaoDichVang) gd);
			}
		}
		List<GiaoDichTT> dstt = new ArrayList<>();
		for(GiaoDich gd : list) {
			if(gd instanceof GiaoDichTT) {
				dstt.add((GiaoDichTT) gd);
			}
		}
		for(GiaoDichVang gdv : dsv) {
			int idx = gdv.getNgay().lastIndexOf('/');
			int n = Integer.parseInt(gdv.getNgay().substring(idx+1));
			if(n == nam) {
				sum += gdv.getThanhTien();
			}
		}
		for(GiaoDichTT gdtt : dstt) {
			int idx = gdtt.getNgay().lastIndexOf('/');
			int n = Integer.parseInt(gdtt.getNgay().substring(idx+1));
			if(n == nam) {
				sum += gdtt.getThanhTien();
			}
		}
		return sum;
	}

	@Override
	public void sapXepTheoMa() {
		Collections.sort(list, new Comparator<GiaoDich>() {

			@Override
			public int compare(GiaoDich o1, GiaoDich o2) {
				return o1.getMa().compareTo(o2.getMa());
			}
		});
	}

	@Override
	public void sapXepTheoSoLuong() { //giam dan theo so luong
		list.sort(new Comparator<GiaoDich>() {

			@Override
			public int compare(GiaoDich o1, GiaoDich o2) {
				//return o2.getSoluong()-o1.getSoluong();
				return Integer.compare(o2.getSoluong(), o1.getSoluong());
			}
		});
	}

	@Override
	public void sapXepVangTheoThanhTien() {
		//lay vang ra
		List<GiaoDichVang> dsv = new ArrayList<>();
		for(GiaoDich gd : list) {
			if(gd instanceof GiaoDichVang) {
				dsv.add((GiaoDichVang) gd);
			}
		}
		dsv.sort(new Comparator<GiaoDichVang>() {

			@Override
			public int compare(GiaoDichVang o1, GiaoDichVang o2) {
				return Double.compare(o1.getThanhTien(), o2.getThanhTien());
			}
		});
		for(GiaoDichVang gdv : dsv) {
			System.out.println(gdv);
		}
	}

	@Override
	public void sapXepTTTheoGia() { //tang dan
		List<GiaoDichTT> dstt = new ArrayList<>();
		for(GiaoDich gd : list) {
			if(gd instanceof GiaoDichTT) {
				dstt.add((GiaoDichTT) gd);
			}
		}
		dstt.sort(new Comparator<GiaoDichTT>() {

			@Override
			public int compare(GiaoDichTT o1, GiaoDichTT o2) {
				return Double.compare(o1.getGia(), o2.getGia());
			}
		});
		for(GiaoDichTT gdtt : dstt) {
			System.out.println(gdtt);
		}
	}
    
	public void sapXepTTTheoNgay() {  //giam dan
		List<GiaoDichTT> dstt = new ArrayList<>();
		for(GiaoDich gd : list) {
			if(gd instanceof GiaoDichTT) {
				dstt.add((GiaoDichTT) gd);
			}
		}
		dstt.sort(new Comparator<GiaoDichTT>() {

			@Override
			public int compare(GiaoDichTT o1, GiaoDichTT o2) {
				
				return 0;
			}
		});
	}

	@Override
	public void nhapGDD(Scanner in) {
		String ngayGd = in.nextLine();
		double donGia = Double.parseDouble(in.nextLine());
		int soLuong = Integer.parseInt(in.nextLine());
		int loaiDat = Integer.parseInt(in.nextLine());
		GiaoDichDat gdd = new GiaoDichDat(ngayGd, donGia, soLuong, loaiDat);
		gdd.setMa();
		list.add(gdd);
	}
}
