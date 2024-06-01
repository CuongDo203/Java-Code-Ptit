import java.util.Scanner;
import java.util.Vector;

public class ThuGonDaySo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Vector<Integer> v = new Vector<>();
		for(int i = 0; i < n; i++) {
			v.add(sc.nextInt());
		}
		int i = 1;
		while(i < v.size()) {
			if((v.get(i-1) + v.get(i)) % 2 == 0) {
				v.remove(i);
				v.remove(i-1);
				if(i>1) i-=1;
			}
			else {
				i += 1;
			}
		}
		System.out.println(v.size());
		sc.close();
	}

}
