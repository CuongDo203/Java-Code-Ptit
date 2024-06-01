import java.util.Scanner;

public class DienTichHinhTronNgoaiTiepTamGiac {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			Point p1 = new Point(sc.nextDouble(),sc.nextDouble());
            Point p2 = new Point(sc.nextDouble(),sc.nextDouble());
            Point p3 = new Point(sc.nextDouble(),sc.nextDouble());
            Triangle tg = new Triangle(p1,p2,p3);
            if(tg.isTriangle()) {
            	System.out.printf("%.3f\n", tg.circleArea());
            }
            else {
            	System.out.println("INVALID");
            }
		}
		sc.close();
	}

}

class Point{
	private double x, y;

	public Point() {
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double distance(Point p) {
		return Math.sqrt(Math.pow(this.x-p.x,2)+Math.pow(this.y-p.y,2));
	}
	
	public double distance(Point a, Point b) {
		return Math.sqrt(Math.pow(a.x-b.x,2)+Math.pow(a.y-b.y, 2));
	}
	
	@Override
	public String toString() {
		return x + " " + y;
	}
}

class Triangle {
	private double canh1, canh2, canh3;
	public Triangle(Point a, Point b, Point c) {
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
	
	public double circleArea() {
		double S = this.area();
		double a = this.canh1;
		double b = this.canh2;
		double c = this.canh3;
		double R = a*b*c/(4*S);
		return Math.PI*Math.pow(R,2);
	}
}