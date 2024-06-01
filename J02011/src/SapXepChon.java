import java.util.Scanner;

public class SapXepChon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for(int i = 0; i < n-1; i++) {
			int minIdx = i;
			System.out.print("Buoc "+(i+1)+": ");
			for(int j = i+1; j < n; j++) {
				if(a[j] < a[minIdx]) {
					minIdx = j;
				}
			}
			int tmp = a[i];
			a[i] = a[minIdx];
			a[minIdx] = tmp;
			for(int x : a) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
