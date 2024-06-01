import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DayConCoKPhanTuTangDan {

	static int n, k;
	static List<Integer> x = new ArrayList<>();
	static List<String> res = new ArrayList<>();
	
	public static void Dq(int pos, int cnt, int a[]) {
		if(x.size()==k) {
			String tmp = "";
			for(int i = 0; i < k; i++) {
				tmp += (x.get(i) + " ");
			}
			res.add(tmp);
			return;
		}
		if(pos == n) {
			return;
		}
		for(int j = pos; j < n; j++) {
			x.add(a[j]);
			Dq(j+1, cnt+1, a);
			x.remove(x.size()-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			n = sc.nextInt();
			k = sc.nextInt();
			int a[] = new int[20];
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			Arrays.sort(a, 0, n);
			Dq(0,0, a);
			for(String s : res) {
				System.out.println(s);
			}
			x.clear();
			res.clear();
		}
		sc.close();
	}

}
