import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Time{
	int hour, minute, second;

	public Time(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	@Override
	public String toString() {
		return hour + " " + minute + " " + second;
	} 
	
}

public class SapXepThoiGian {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		List<Time> time = new ArrayList<Time>();
		while(t-- > 0) {
			int h = sc.nextInt();
			int m = sc.nextInt();
			int s = sc.nextInt();
			Time g = new Time(h, m, s);
			time.add(g);
		}
		time.sort(new Comparator<Time>() {
			@Override
			public int compare(Time o1, Time o2) {
				int t1 = o1.getHour() * 3600 + o1.getMinute()*60 + o1.getSecond();
				int t2 = o2.getHour() * 3600 + o2.getMinute()*60 + o2.getSecond();
				return t1 - t2;
			}
		});
		for(Time x : time) {
			System.out.println(x);
		}
		sc.close();
	}

}
