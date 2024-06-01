
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;


public class LietKeVaDem {

    public static boolean check(String s){
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i)>s.charAt(i+1)){
                return false;
            }
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
        for(String x : ds){
            if(check(x)){
                if(mp.containsKey(x)){
                    mp.put(x, mp.get(x)+1);
                }
                else{
                    mp.put(x, 1);
                }
            }
        }
        Map<String, Integer> mp2 = new HashMap<>();
        for(int i = 0; i < ds.size(); i++){
            if(check(ds.get(i)) && !mp2.containsKey(ds.get(i))){
                mp2.put(ds.get(i), i);
            }
        }
        List<Map.Entry<String, Integer>> res = new ArrayList<>(mp.entrySet());
        res.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(Objects.equals(o1.getValue(), o2.getValue())){
                    return mp2.get(o1.getKey())-mp2.get(o2.getKey());
                }
                return o2.getValue()-o1.getValue();
            }
        });
        for (Map.Entry<String, Integer> re : res) {
            System.out.println(re.getKey()+" "+re.getValue());
        }
        sc.close();
    }
    
}
