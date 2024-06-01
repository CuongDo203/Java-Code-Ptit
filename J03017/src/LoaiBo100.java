
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LoaiBo100 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String s = sc.nextLine();
            int res = 0;
            List<Integer> ds = new ArrayList<>();
            ds.add(-1);
            String s1 = "";
            for(int i = 0; i < s.length(); i++){
                s1 += s.charAt(i);
                ds.add(i);
                while(s1.length()>0&&s1.endsWith("100")){
                    s1 = s1.substring(0, s1.length()-3);
                    ds.remove(ds.size()-3);
                    ds.remove(ds.size()-2);
                    ds.remove(ds.size()-1);
                }
                res = Math.max(res, i - ds.get(ds.size()-1));
            }
            System.out.println(res);
        }
        sc.close();
    }
    
}
