
import java.util.Scanner;
import java.util.Stack;


public class HinhChuNhatDonSac {
    
    public static long solve(int a[], int n){
        Stack<Integer> st = new Stack<>();
        int l[] = new int[n];
        int r[] = new int[n];
        long res = 0;
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && a[st.peek()]>= a[i]){
                st.pop();
            }
            if(st.isEmpty()){
                l[i] = 0;
            }
            else{
                l[i] = st.peek()+1;
            }
            st.add(i);
        }
        while(!st.isEmpty()){
            st.pop();
        }
        for(int i = n-1; i>=0; i--){
            while (!st.empty() && a[st.peek()] >= a[i]) {
                st.pop();
            }   
            if(st.empty()){
                r[i] = n-1;
            }
            else{
                r[i] = st.peek()-1;
            }
            st.add(i);
        }
        for(int i = 0; i < n; i++){
            res = Math.max(res, (long)a[i]*(r[i]-l[i]+1));
        }
        return res;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            b[i] = m - a[i];
        }
        System.out.println(Math.max(solve(a, n), solve(b, n)));
        sc.close();
    }  
}
