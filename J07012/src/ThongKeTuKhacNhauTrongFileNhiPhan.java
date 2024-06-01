
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class ThongKeTuKhacNhauTrongFileNhiPhan {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        List<String> a = (List<String>) ois.readObject();
        String s = "";
        for(String tmp : a){
            s+=tmp.toLowerCase()+" ";
        }
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
    }
    
}
