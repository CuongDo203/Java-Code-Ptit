import java.util.Scanner;

public class HinhChuNhat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dai = sc.nextInt();
		int rong = sc.nextInt();
		if(dai <= 0 || rong <= 0) {
			System.out.println("0");
		}
		else {
			int cv = (dai+rong)*2;
			int dt = dai*rong;
			System.out.print(cv + " " + dt);
		}
	}

}
