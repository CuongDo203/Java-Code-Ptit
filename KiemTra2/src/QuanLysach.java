import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class QuanLysach {
	List<SachHoc> list;

	
	
	public QuanLysach() {
		this.list = new ArrayList<>();
	}

	public QuanLysach(List<SachHoc> list) {
		this.list = new ArrayList<>();
		this.list = list;
	}

	public List<SachHoc> getList() {
		return list;
	}

	public void setList(List<SachHoc> list) {
		this.list = list;
	}
	
	public void nhapSachThamKhoa(Scanner in) {
		String ten = in.nextLine();
		String nhaXB = in.nextLine();
		boolean loai = Boolean.parseBoolean(in.nextLine());
		double gia = Double.parseDouble(in.nextLine());
		SachThamKhao stk = new SachThamKhao(ten, nhaXB, loai, gia);
		stk.setMa();
		this.list.add(stk);
	}
	
	public void nhapSachGiaoKhoa(Scanner in) {
		String ten = in.nextLine();
		String nhaXB = in.nextLine();
		int lop = Integer.parseInt(in.nextLine());
		int tap = Integer.parseInt(in.nextLine());
		boolean baitap = Boolean.parseBoolean(in.nextLine());
		double gia = Double.parseDouble(in.nextLine());
		SachGiaoKhoa sgk = new SachGiaoKhoa(ten, nhaXB, lop, tap, baitap, gia);
		sgk.setMa();
		this.list.add(sgk);
	}
	
	public void out() {
		for(SachHoc sh : this.list) {
			System.out.println(sh);
		}
	}
	
	public void xoaSachGiaoKhoa(String nhaXB) {
		List<SachGiaoKhoa> ds = new ArrayList<>();
		for(SachHoc sh : this.list) {
			if(sh instanceof SachGiaoKhoa) {
				ds.add((SachGiaoKhoa) sh);
			}
		}
//		for(SachGiaoKhoa sgk : ds) {
//			if(!sgk.getNhaXB().equalsIgnoreCase(nhaXB)) {
//				System.out.println(sgk);
//			}
//		}
		for(int i = 0; i < ds.size(); i++) {
			if(ds.get(i).getNhaXB().equalsIgnoreCase(nhaXB)) {
				ds.remove(i);
				i--;
			}
		}
		for(SachGiaoKhoa sgk : ds) {
			System.out.println(sgk);
		}
	}
	
	public void demNhaXB(boolean baitap) {
		List<SachGiaoKhoa> ds = new ArrayList<>();
		for(SachHoc sh : this.list) {
			if(sh instanceof SachGiaoKhoa) {
				ds.add((SachGiaoKhoa) sh);
			}
		}
//		Map<String, Integer> mp = new HashMap<>();
//		for(SachGiaoKhoa sgk : ds) {
//			if(sgk.isBaitap()==baitap) {
//				if(mp.containsKey(sgk.getNhaXB())) {
//					mp.put(sgk.getNhaXB(), mp.get(sgk.getNhaXB())+1);
//				}
//				else {
//					mp.put(sgk.getNhaXB(), 1);
//				}
//			}
//		}
//		for(String x : mp.keySet()) {
//			System.out.println(x+":"+mp.get(x));
//		}
		Map<String, Long> cnt = ds.stream().collect(
				Collectors.groupingBy(SachGiaoKhoa::getNhaXB, Collectors.counting()));
		Iterator i = cnt.keySet().iterator();
		while(i.hasNext()) {
			Object key = i.next();
			System.out.println(key+":"+cnt.get(key));
		}
	}

}
