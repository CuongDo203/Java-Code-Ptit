import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TapTuChungCuaHaiXau {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while(t-->0) {
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();
			s1 = s1.toLowerCase();
			s2 = s2.toLowerCase();
			String w1[] = s1.trim().split("\\s+");
			String w2[] = s2.trim().split("\\s+");
			Set<String> se = new HashSet<>();
			for(int i = 0; i < w1.length; i++) {
				for(int j = 0; j < w2.length; j++) {
					if(w1[i].equals(w2[j])) {
						se.add(w1[i]);
					}
				}
			}
			List<String> lst = new ArrayList<>(se);
			Collections.sort(lst);
			if(lst.size()==0) {
				System.out.println("NO");
			}
			else {
				for(String x : lst) {
					System.out.print(x+" ");
				}
				System.out.println();
			}
		}
		sc.close();
	}

}
