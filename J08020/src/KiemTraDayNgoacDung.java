import java.util.Scanner;
import java.util.Stack;

public class KiemTraDayNgoacDung {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			String s = sc.next();
			Stack<Character> st = new Stack<>();
			for(int i = 0; i < s.length(); i++) {
				if(st.empty() || s.charAt(i) == '[' || s.charAt(i)=='(' || s.charAt(i)=='{') {
					st.push(s.charAt(i));
				}
				else {
					if(s.charAt(i)==')') {
						if(!st.empty() && st.peek() == '(') {
							st.pop();
						}
					}
					else if(s.charAt(i) == ']') {
						if(!st.empty() && st.peek() == '[') {
							st.pop();
						}
					}
					else {
						if(!st.empty() && st.peek() == '{') {
							st.pop();
						}
					}
				}
			}
			if(st.empty()) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			st.clear();
		}
		sc.close();
	}

}
