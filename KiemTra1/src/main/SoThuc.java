package main;

import java.util.Scanner;

public class SoThuc {
	private double so, epsilon;
	Scanner sc = new Scanner(System.in);
	public SoThuc() {}

	public double getSo() {
		return so;
	}

	public void setSo(double so) {
		this.so = so;
	}
	
	private long giaiThua(int n) {
		long res = 1;
		for(int i = 1; i <= n; i++) {
			res*=i;
		}
		return res;
	}
	
	public void nhap() {
		System.out.println("Nhap x va epsilon: ");
		so  = sc.nextDouble();
		epsilon = sc.nextDouble();
	}
	
//	public double tinhCosx() {
//		double res= 1, sum = 0;
//		double i = 0;
//		while(res<epsilon) {
//			res = calc(n,i);
//			if(i%2==0) {
//				sum += res;
//			}
//			else {
//				sum-=res;
//			}
//		}
//	}
}
