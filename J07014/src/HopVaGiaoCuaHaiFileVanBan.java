
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class HopVaGiaoCuaHaiFileVanBan {

    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
    
}

class WordSet{
    Set<String> se;

    public WordSet() {
        se = new TreeSet<>();
    }

    public WordSet(Set<String> se) {
        this.se = new TreeSet<>();
        this.se = se;
    }

    public Set<String> getSe() {
        return se;
    }

    public void setSe(Set<String> se) {
        this.se = se;
    }
    
    public WordSet(String f) throws FileNotFoundException {
        se = new TreeSet<>();
        Scanner sc = new Scanner(new File(f));
        while(sc.hasNext()){
            se.add(sc.next().toLowerCase());
        }
        sc.close();
    }
    
    public WordSet union(WordSet o){
        Set<String> tmp = new TreeSet<>(se);
        tmp.addAll(o.getSe());
        return new WordSet(tmp);
    }
    
    public WordSet intersection(WordSet o){
        Set<String> tmp = new TreeSet<>(se);
        tmp.retainAll(o.getSe());
        return new WordSet(tmp);
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(String x : se){
            sb.append(x+" ");
        }
        return sb.toString();
    }
}