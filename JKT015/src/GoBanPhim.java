import java.util.Scanner;
import java.util.Stack;

public class GoBanPhim {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '-') {
				if(sb.length()!=0) {
					sb.deleteCharAt(sb.length()-1);
				}
			}
			else if(s.charAt(i) == '>') {
				if(!st.empty()) {
					sb.append(st.peek());
					st.pop();
				}
			}
			else if(s.charAt(i) == '<') {
				if(sb.length()!=0) {
					st.push(sb.charAt(sb.length()-1));
					sb.deleteCharAt(sb.length()-1);
				}
			}
			else {
				sb.append(s.charAt(i));
			}
		}
		while(!st.empty()) {
			sb.append(st.peek());
			st.pop();
		}
		System.out.println(sb);
		sc.close();
	}

}
