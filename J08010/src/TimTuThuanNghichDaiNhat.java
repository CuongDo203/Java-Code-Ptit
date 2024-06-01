
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class TimTuThuanNghichDaiNhat {

    public static boolean isTn(String s){
        int l = 0, r = s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> ds = new ArrayList<>();
        while(sc.hasNext()){
            ds.add(sc.next().trim());
        }
        Map<String, Integer> mp = new HashMap<>();
        int ma = -1000000000;
        int tn = -1000000000;
        for(String x : ds){
            if(mp.containsKey(x)){
                mp.put(x, mp.get(x)+1);
            }
            else{
                mp.put(x, 1);
            }
            if(mp.get(x)>ma){
                ma = mp.get(x);
            }
            if(isTn(x)){
                tn = Math.max(tn, x.length());
            }
        }
        for(String x : ds){
            if(isTn(x) && x.length()==tn && mp.get(x)!=0){
                System.out.println(x+" "+mp.get(x));
                mp.put(x, 0);
            }
        }
        sc.close();
    }
    
}
