import java.util.Scanner;

public class HinhVuong {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int x3 = sc.nextInt();
		int y3 = sc.nextInt();
		int x4 = sc.nextInt();
		int y4 = sc.nextInt();
		int c1 = Math.max(Math.max(x1, x2), Math.max(x3, x4)) - Math.min(Math.min(x1, x2), Math.min(x3, x4));
		int c2 = Math.max(Math.max(y1, y2), Math.max(y3, y4)) - Math.min(Math.min(y1, y2), Math.min(y3, y4));
		System.out.println(Math.max(c1, c2)* Math.max(c1, c2));
		sc.close();
	}

}
