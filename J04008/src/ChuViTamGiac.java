import java.util.Scanner;

class Point{
	private double x, y;

	public Point() {
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(Point o) {
		this.x = o.x;
		this.y = o.y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public double distance(Point o) {
		return Math.sqrt(Math.pow(this.x - o.x, 2) + Math.pow(this.y - o.y, 2));
	}
	
	public double distance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}

	@Override
	public String toString() {
		return x + " " + y;
	}
	
	
}

public class ChuViTamGiac {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			Point p[] = new Point[3];
			for(int i = 0; i < 3; i++) {
				double x = sc.nextDouble();
				double y = sc.nextDouble();
				p[i] = new Point(x, y);
			}
			double a = p[0].distance(p[1]);
			double b = p[1].distance(p[2]);
			double c = p[0].distance(p[2]);
			if(a+b > c && b+c > a && a+c>b) {
				System.out.printf("%.3f\n", a+b+c);
			}
			else {
				System.out.println("INVALID");
			}
		}
		sc.close();
	}

}
