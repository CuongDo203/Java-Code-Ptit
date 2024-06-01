
import java.util.Scanner;
import java.util.Stack;


public class GoBanPhim {

    public static void solve(String s){
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){
                case '<':
                    if(res.length()>0){
                        st.add(res.charAt(res.length()-1));
                        res = res.deleteCharAt(res.length()-1);
                    }
                    break;
                case '>':
                    if(!st.isEmpty()){
                        res.append(st.pop());
                    }
                    break;
                case '-':
                    if(res.length()>0){
                        res = res.deleteCharAt(res.length()-1);
                    }
                    break;
                default:
                    res.append(s.charAt(i));
                    break;
            }
        }
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        System.out.println(res.toString());
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        solve(s);
        sc.close();
    }
    
}
