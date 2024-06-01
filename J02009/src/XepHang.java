import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class XepHang {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Checkin> ds = new ArrayList<>();
		while(n-->0) {
			int t = sc.nextInt();
			int d = sc.nextInt();
			ds.add(new Checkin(t, d));
		}
		ds.sort(new Comparator<Checkin>() {
			@Override
			public int compare(Checkin o1, Checkin o2) {
				return o1.getTdDen() - o2.getTdDen();
			}
		});
		long ans = 0;
		for(int i = 0; i < ds.size(); i++) {
			if(i==0) {
				ans += ds.get(i).getTdDen() + ds.get(i).getTgCheckin();
			}
			else {
				int tmp = ds.get(i).getTdDen();
				if(tmp>=ans) {
					ans = tmp + ds.get(i).getTgCheckin();
				}
				else {
					ans += ds.get(i).getTgCheckin();
				}
			}
		}
		System.out.println(ans);
		sc.close();
	}

}

class Checkin{
	private int tdDen, tgCheckin;

	public Checkin(int tdDen, int tgCheckin) {
		this.tdDen = tdDen;
		this.tgCheckin = tgCheckin;
	}

	public int getTdDen() {
		return tdDen;
	}

	public void setTdDen(int tdDen) {
		this.tdDen = tdDen;
	}

	public int getTgCheckin() {
		return tgCheckin;
	}

	public void setTgCheckin(int tgCheckin) {
		this.tgCheckin = tgCheckin;
	}
	
}