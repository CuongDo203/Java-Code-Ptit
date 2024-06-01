import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DauTuChungKhoan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			int b[] = new int[n];
			Arrays.fill(b, 1);
			Stack<Integer> st = new Stack<>();
			for(int i = 0; i < n; i++) {
				if(st.empty() || a[i] < a[st.peek()]) {
					st.push(i);
				}
				else {
					while(!st.empty() && a[i] >= a[st.peek()]) {
						st.pop();
					}
					if(st.empty()) {
						b[i] = i+1;
					}
					else {
						b[i] = i-st.peek();
					}
					st.push(i);
				}
			}
			for(int i = 0; i < n; i++) {
				System.out.print(b[i] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
