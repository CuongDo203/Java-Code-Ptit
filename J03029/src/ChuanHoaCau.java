
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ChuanHoaCau {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> ds = new ArrayList<>();
        while(sc.hasNextLine()){
            ds.add(sc.nextLine());
        }
        for(String x : ds){
            if(!x.endsWith(".") && !x.endsWith("?") && !x.endsWith("!")) x = x.trim()+".";
            x = x.replaceAll("\\s+", " ");
            x = x.replaceAll("\\,\\s+", ", ");
            x = x.replaceAll("\\s+\\,", ",");
            x = x.replaceAll("\\?\\s+", "? ");
            x = x.replaceAll("\\s+\\?", "?");
            x = x.replaceAll("\\!\\s+", "! ");
            x = x.replaceAll("\\s+\\!", "!");
            x = x.replaceAll("\\.\\s+", ". ");
            x = x.replaceAll("\\s+\\.", ".");
            x = Character.toUpperCase(x.charAt(0))+x.substring(1).toLowerCase();
            System.out.println(x);
        }
        sc.close();
    }
    
}
