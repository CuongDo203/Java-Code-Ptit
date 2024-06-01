import java.util.Scanner;

public class ChiaHetCho11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			String s = sc.next();
			int sum1 = 0, sum2 = 0;
			for(int i = 0; i < s.length(); i+=2) {
				sum1 += (s.charAt(i)-'0');
			}
			for(int i = 1; i < s.length(); i+=2) {
				sum2 += (s.charAt(i)-'0');
			}
			System.out.println((sum1-sum2)%11==0 ? 1 : 0);
		}
		sc.close();
	}

}
