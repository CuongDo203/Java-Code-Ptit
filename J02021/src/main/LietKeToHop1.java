package main;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class LietKeToHop1 {
	
	public static Vector<Integer> v = new Vector<Integer>();
	public static ArrayList<Vector<Integer>> a = new ArrayList<>();
	
	public static void Dq(int n, int k, int start) {
		if(v.size() == k) {
			for(int x : v) {
				System.out.print(x);
			}
			System.out.print(" ");
			a.add(v);
			return;
		}
		for(int i = start; i <= n; i++) {
			v.add(i);
			Dq(n, k, i+1);
			v.remove(v.size()-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, k;
		n = sc.nextInt();
		k = sc.nextInt();
		Dq(n,k, 1);
		System.out.println();
		System.out.println("Tong cong co "+ a.size() +" to hop");
		sc.close();
	}

}
