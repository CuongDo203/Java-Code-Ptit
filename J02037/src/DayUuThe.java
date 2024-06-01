import java.util.Scanner;

public class DayUuThe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while(t-->0) {
			int odd = 0, even = 0;
			String w[] = sc.nextLine().trim().split("\\s+");
			for(String x : w) {
				int n = Integer.parseInt(x);
				if(n%2==1) {
					odd++;
				}
				else {
					even++;
				}
			}
			boolean ok = false;
			if((odd+even)%2==0) {
				if(even>odd) {
					ok = true;
				}
			}
			else {
				if(odd>even) {
					ok = true;
				}
			}
			if(ok) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		sc.close();
	}

}
