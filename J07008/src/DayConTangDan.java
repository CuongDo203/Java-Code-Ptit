import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DayConTangDan {

	private static int n;
	private static int a[];
	
	public static void nhap() {
		try (Scanner sc = new Scanner(new File("DAYSO.in"))) {
			n = sc.nextInt();
			a = new int[n];
			x = new ArrayList<>();
			res = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static ArrayList<String> res;
	private static List<Integer> x;
	
	public static void Dq(int pos) {
		if(x.size()>=2) {
			String tmp = "";
			for(int i : x) {
				tmp += i + " ";
			}
			tmp = tmp.substring(0, tmp.length()-1);
			res.add(tmp);
		}
		if(pos == n+1) {
			return;
		}
		for (int i = pos; i < n; i++) {
			if(x.isEmpty() || a[i] >= x.get(x.size()-1)) {
				x.add(a[i]);
//				System.out.print(a[i]);
//				System.out.println();
				Dq(i+1);
				x.remove(x.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		nhap();
		Dq(0);
		res.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		for(String x : res) {
			System.out.println(x);
		}
	}

}

