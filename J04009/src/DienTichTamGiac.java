import java.util.Scanner;

public class DienTichTamGiac {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			Point p1 = new Point(sc.nextDouble(), sc.nextDouble());
			Point p2 = new Point(sc.nextDouble(), sc.nextDouble());
			Point p3 = new Point(sc.nextDouble(), sc.nextDouble());
			Triangle tg = new Triangle(p1, p2, p3);
			if(tg.isTriangle()) {
				System.out.printf("%.2f\n", tg.area());
			}
			else {
				System.out.println("INVALID");
			}
		}
		sc.close();
	}

}

class Triangle{
	public double canh1, canh2, canh3;
	Triangle(Point a, Point b, Point c) {
		this.canh1 = a.distance(b);
		this.canh2 = b.distance(c);
		this.canh3 = c.distance(a);
	}
	public boolean isTriangle() {
		if(this.canh1+this.canh2>this.canh3 && this.canh1+this.canh3>this.canh2 && this.canh2+this.canh3>this.canh1) {
			return true;
		}
		else {
			return false;
		}
	}
	public double area() {
		double a = this.canh1;
		double b = this.canh2;
		double c = this.canh3;
		return Math.sqrt((a+b+c)*(a+b-c)*(a-b+c)*(-a+b+c))/4;
	}
}

class Point{
	private double x, y;

	Point() {
	}

	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}

	double getX() {
		return this.x;
	}

	double getY() {
		return this.y;
	}

	double distance(Point p) {
		return Math.sqrt(Math.pow(this.x-p.x,2)+Math.pow(this.y-p.y,2));
	}
	
	double distance(Point a, Point b) {
		return Math.sqrt(Math.pow(a.x-b.x,2)+Math.pow(a.y-b.y, 2));
	}
	
	@Override
	public String toString() {
		return "Point(x,y): ("+this.x+','+this.y+')'; 
	}
}
