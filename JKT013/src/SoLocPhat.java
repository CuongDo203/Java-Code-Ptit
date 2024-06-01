import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SoLocPhat {

	public static void solve(int n) {
		Queue<String> q = new LinkedList<>();
		Stack<String> st = new Stack<>();
 		q.add("6");
		q.add("8");
		while(true) {
			String f = q.poll();
			if(f.length()>n) {
				break;
			}
			st.add(f);
			q.add(f+"6");
			q.add(f+"8");
		}
		System.out.println(st.size());
		while(!st.empty()) {
			System.out.print(st.peek()+" ");
			st.pop();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			solve(n);
			System.out.println();
		}
		sc.close();
	}

}
