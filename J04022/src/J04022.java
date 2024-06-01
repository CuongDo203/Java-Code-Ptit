import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class J04022 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
	}

}

class WordSet{
	private Set<String> sen;
	
	public WordSet(String s) {
		sen = new TreeSet<String>();
		s = s.toLowerCase().trim();
		String w[] = s.split("\\s+");
		for(int i = 0; i < w.length; i++) {
			this.sen.add(w[i]);
		}
	}
	
	public WordSet union(WordSet o) {
		Set<String> tmp = new TreeSet<String>(this.sen);
		tmp.addAll(o.sen);
		StringBuilder sb = new StringBuilder();
		for(String x : tmp) {
			sb.append(x + " ");
		}
		return new WordSet(sb.toString());
	}
	
	public WordSet intersection(WordSet o) {
		Set<String> tmp = new TreeSet<String>(this.sen);
		tmp.retainAll(o.sen);
		StringBuilder sb = new StringBuilder();
		for(String x : tmp) {
			sb.append(x + " ");
		}
		return new WordSet(sb.toString());
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(String x : this.sen) {
			sb.append(x + " ");
		}
		return sb.toString();
	}
}
