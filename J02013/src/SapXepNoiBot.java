import java.util.Scanner;

public class SapXepNoiBot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for(int i = 0; i < n-1; i++) {
			boolean ok = false;
			for(int j = 0; j < n-i-1; j++) {
				if(a[j] > a[j+1]) {
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
					ok = true;
				}
			}
			if(!ok) {
				break;
			}
			System.out.print("Buoc "+(i+1)+": ");
			for(int x : a) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
