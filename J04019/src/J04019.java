import java.text.DecimalFormat;
import java.util.Scanner;

public class J04019 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
    }
}

class Point{
	private double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public static Point nextPoint(Scanner sc) {
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		return new Point(x, y);
	}
	
	public double distance(Point p) {
		return Math.sqrt(Math.pow(this.x-p.x, 2)+Math.pow(this.y-p.y, 2));
	}
}

class Triangle{
	DecimalFormat df = new DecimalFormat("#.###");
	private double c1, c2, c3, perimeter;
	
	public Triangle(Point a, Point b, Point c) {
		this.c1 = a.distance(b);
		this.c2 = b.distance(c);
		this.c3 = c.distance(a);
		this.perimeter = c1+c2+c3;
	}
	
	public boolean valid() {
		return c1+c2>c3 && c2+c3>c1 && c1+c3>c2;
	}

	public String getPerimeter() {
		return df.format(this.perimeter);
	}
}