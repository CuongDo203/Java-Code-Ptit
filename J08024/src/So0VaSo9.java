import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class So0VaSo9 {

	public static long[] init() {
		long a[] = new long[101]; 
		long vs[] = new long[101];
		Queue<Long> q = new LinkedList<>();
		q.add(9l);
		int cnt = 0;
		while(cnt < 100) {
			long v = q.poll();
			for(int i = 1; i <= 100; i++) {
				if(vs[i]==0 && v%i==0) {
					a[i] = v;
					vs[i] = 1;
					cnt++;
				}
			}
			q.add(v*10);
			q.add(v*10+9);
		}
		return a;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a[] = init();
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			System.out.println(a[n]);
		}
		sc.close();
	}

}
