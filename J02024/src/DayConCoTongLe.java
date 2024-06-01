import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DayConCoTongLe {
	public static int n;
	public static List<Integer> a = new ArrayList<>();
	public static List<List<Integer>> res = new ArrayList<>();
	public static List<Integer> x = new ArrayList<>();
	
	public static void Dq(int i, int sum) {
		if(i == n) {
			return;
		}
		for(int j = i; j < n; j++) {
			x.add(a.get(j));
			sum += a.get(j);
			if(sum%2==1) {
				res.add(new ArrayList<>(x));
			}
			Dq(j+1, sum);
			sum-=a.get(j);
			x.remove(x.size()-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			n = sc.nextInt();
			for(int i = 0; i < n; i++) {
				a.add(sc.nextInt());
			}
			Collections.sort(a, Collections.reverseOrder());
			Dq(0,0);
			res.sort(new Comparator<List<Integer>>() {
				@Override
				public int compare(List<Integer> o1, List<Integer> o2) {
					for(int i = 0; i < o1.size()&&i<o2.size(); i++) {
						if(o1.get(i)!=o2.get(i)) {
							return o1.get(i) - o2.get(i);
						}
					}
					return o1.size() - o2.size();
				}
			
			});
			for(List<Integer> v : res) {
				for(Integer y : v) {
					System.out.print(y + " ");
				}
				System.out.println();
			}
			res.clear();
			x.clear();
			a.clear();
		}
		sc.close();
	}

}
