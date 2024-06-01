import java.util.Scanner;

public class ChuSo4VaChuSo7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int cnt4=0, cnt7 = 0;
		for(int i = 0; i < n.length(); i++) {
			if(n.charAt(i)=='4') cnt4++;
			if(n.charAt(i)=='7') cnt7++;
		}
		if(cnt4+cnt7==4 || cnt4+cnt7==7) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		sc.close();
	}

}
