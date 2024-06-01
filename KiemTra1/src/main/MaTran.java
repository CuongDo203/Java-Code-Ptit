package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaTran {
	int a[][];
	
	public MaTran(int r, int c) {
		a = new int[r][c];
	}
	
	public int getHang() {
		return this.a.length;
	}
	
	public int getCot() {
		return this.a[0].length;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap va mot ma tran co "+ getHang()+" va "+getCot());
		for(int i = 0; i < getHang(); i++) {
			for(int j = 0; j < getCot(); j++) {
				a[i][j] = sc.nextInt();
			}
		}
	}
	
	public void vietRaMaTranChuyenVi() {
		for(int i = 0; i < getCot(); i++) {
			for(int j = 0; j < getHang(); j++) {
				System.out.print(a[j][i] + " ");
			}
			System.out.println();
		}
	}
	
	private boolean isPrime(int n) {
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n%i==0) {
				return false;
			}
		}
		return n>1;
	}
	
	public void duaRaCacHangChiCoCacSoNguyenTo() {
		List<Integer> lst = new ArrayList<>();
		for(int i = 0; i < getHang(); i++) {
			int cnt = 0;
			for(int j = 0; j < getCot(); j++) {
				if(isPrime(a[i][j])) {
					cnt++;
				}
			}
			if(cnt==getCot()) {
				lst.add(i);
			}
		}
		if(lst.size()==0) {
			System.out.println("Khong co hang nao chi chua cac so nguyen to!");
		}
		else {
			System.out.println("Cac hang chi co cac so nguyen to la: ");
		}
	}
}
