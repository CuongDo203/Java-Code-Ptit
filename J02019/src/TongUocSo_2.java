
import java.util.Scanner;


public class TongUocSo_2 {

    static int N = 1000000;
    static int p[] = new int[N+2];
    
    public static int pow(int a, int b){
        if(b==0) return 1;
        if(b==1) return a;
        int x = pow(a,b/2);
        if(b%2==1)
            return x*x*a;
        else
            return x*x;
    }
    
    public static void gen(){
        for(int i = 2; i <= (int)Math.sqrt(N); ++i){
            if(p[i]==0){
                p[i] = i;
                for(int j=i*i; j <= N; j+=i){
                    if(p[j]==0){
                        p[j] = i;
                    }
                }
            }
        }
//        for(int i = 0; i <= 1000; i++){
//            System.out.println(p[i]);
//        }
        for(int i = 2; i <= N; ++i){
            if(p[i]==0){
                p[i] = i+1;
            }
            else{
                int n = i, x = 0;
                while(n%p[i]==0){
                    n/=p[i];
                    x++;
                }
                if(n==1) p[i] = (pow(p[i], x+1)-1)/(p[i]-1);
                else{
                    p[i] = p[pow(p[i], x)]*p[n];
                }
            }
        }
    }
    
    public static void main(String[] args) {
        gen();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int cnt = 0;
        for(int i = a; i <= b; i++){
            if(p[i]-i>i)
                cnt++;
        }
        System.out.println(cnt);
        sc.close();
    }
    
}
