
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;


public class NguyenToVaThuanNghich {

    private static boolean isTn(int n){
        String s = n+"";
        int l = 0, r = s.length()-1;
        while(l < r){
            if(s.charAt(l)!=s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
    
    private static boolean isNt(int n){
        for(int i = 2; i*i <= n; i++){
            if(n%i==0)
                return false;
        }
        return n>1;
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        List<Integer> a = (List<Integer>) ois1.readObject();
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        List<Integer> b = (List<Integer>) ois2.readObject();
        int c1[] = new int[10005];
        for(Integer x : a){
            if(isTn(x) && isNt(x)){
                c1[x]++;
            }
        }
        int c2[] = new int[10005];
        for(Integer x : b){
            if(c1[x]!=0 && isTn(x) && isNt(x)){
                c2[x]++;
            }
        }
        for(int i = 0; i < 10005; i++){
            if(c2[i]!=0){
                System.out.println(i+" "+c1[i]+" "+c2[i]);
            }
        }
    }
    
}
