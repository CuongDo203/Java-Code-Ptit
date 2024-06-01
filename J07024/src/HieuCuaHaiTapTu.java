
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class HieuCuaHaiTapTu {

    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.difference(s2));
        System.out.println(s2.difference(s1));
    }
    
}

class WordSet{
    private Set<String> se;

    public WordSet() {
        se = new TreeSet<>();
    }

    public WordSet(Set<String> se) {
        this.se = se;
    }

    public Set<String> getSe() {
        return se;
    }

    public void setSe(Set<String> se) {
        this.se = se;
    }
    
    public WordSet(String f) throws FileNotFoundException{
        se = new TreeSet<>();
        Scanner sc = new Scanner(new File(f));
        while(sc.hasNext()){
            se.add(sc.next().toLowerCase());
        }
    }
    
    public WordSet difference(WordSet o){
        Set<String> tmp = new TreeSet<>(se);
        tmp.removeAll(o.getSe());
        return new WordSet(tmp);
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(String s : se){
            sb.append(s+" ");
        }
        return sb.toString().trim();
    }
}