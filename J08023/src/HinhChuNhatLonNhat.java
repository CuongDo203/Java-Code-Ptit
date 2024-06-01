
import java.util.Scanner;
import java.util.Stack;


public class HinhChuNhatLonNhat {

    public static long solve(int a[], int n){
        long res = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            if(st.isEmpty() || a[i] >= a[st.peek()]){
                st.add(i);
            }
            else{
                while(!st.isEmpty() && a[i] < a[st.peek()]){
                    int v = st.peek();
                    st.pop();
                    long tmp = 0;
                    if(st.empty()){
                        tmp = (long)(i*a[v]);
                    }
                    else{
                        tmp = (long)(i -st.peek()-1)*a[v];
                    }
                    res = Math.max(res, tmp);
                }
                st.add(i);
            }
        }
        while(!st.empty()){
            int v = st.peek();
            st.pop();
            long tmp = 0;
            if(st.empty()){
                tmp = (long)(n*a[v]);
            }
            else{
                tmp = (long)(n -st.peek()-1)*a[v];
            }
            res = Math.max(res, tmp);
        }
        return res;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            System.out.println(solve(a, n));
        }
        sc.close();
    }
    
}
