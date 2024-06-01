
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;


public class ThongKeTuKhacNhuTrongFileVanBan {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("VANBAN.in"));
        int t = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        while(t-->0){
            sb.append(sc.nextLine().toLowerCase()).append(" ");
        }
        String s = sb.toString();
        String w[] = s.split("\\W\\s*");
        Map<String, Integer> mp = new HashMap<>();
        for(String x : w){
            if(!x.equals("")){
                if(mp.containsKey(x)){
                    mp.put(x, mp.get(x)+1);
                }
                else{
                    mp.put(x,1);
                }
            }
        }
        List<Map.Entry<String, Integer>> ds = new ArrayList<>(mp.entrySet());
//        Collections.sort(ds, (o1, o2)->o1.getKey().compareTo(o2.getKey()));
//        Collections.sort(ds, (o1,o2)->o2.getValue().compareTo(o1.getValue()));
//        
        ds.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(Objects.equals(o1.getValue(), o2.getValue()))
                    return o1.getKey().compareTo(o2.getKey());
                return o2.getValue()-o1.getValue();
            }
        });
        for(Map.Entry<String, Integer> x : ds){
            System.out.println(x.getKey()+" "+x.getValue());
        }
        sc.close();
    }
    
}
