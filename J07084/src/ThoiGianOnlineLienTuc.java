import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ThoiGianOnlineLienTuc {

	public static void main(String[] args) throws ParseException, FileNotFoundException {
		Scanner sc = new Scanner(new File("ONLINE.in"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		int n = Integer.parseInt(sc.nextLine());
		List<SinhVien> ds = new ArrayList<>();
		while(n-->0) {
			String ten = sc.nextLine();
			Date tgbd = sdf.parse(sc.nextLine());
			Date tgkt = sdf.parse(sc.nextLine());
			ds.add(new SinhVien(ten, tgbd, tgkt));
		}
		Collections.sort(ds);
		for(SinhVien sv : ds) {
			System.out.println(sv);
		}
		sc.close();
	}

}

class SinhVien implements Comparable<SinhVien>{
	private String name;
	private Date thoiGianBd, thoiGianKt;
	
	public SinhVien(String name, Date thoiGianBd, Date thoiGianKt) {
		this.name = name;
		this.thoiGianBd = thoiGianBd;
		this.thoiGianKt = thoiGianKt;
	}

	public long getThoiGianOnline() {
		return (thoiGianKt.getTime() - thoiGianBd.getTime())/(1000*60);
	}

	@Override
	public int compareTo(SinhVien o) {
		if(getThoiGianOnline() == o.getThoiGianOnline()){
			return name.compareTo(o.name);
		}
		else {
			return (int) (o.getThoiGianOnline() - getThoiGianOnline());
		}
	}

	@Override
	public String toString() {
		return name + " " + getThoiGianOnline();
	}
	
	
}