import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class WordSet{
	private Set<String> se;
	
	public WordSet(String input) throws FileNotFoundException {
		se = new TreeSet<String>();
		Scanner sc = new Scanner(new File(input));
		while(sc.hasNext()) {
			se.add(sc.next().toLowerCase());
		}
	}

	@Override
	public String toString() {
		String s = "";
		for(String x : se) {
			s += x + "\n";
		}
		return s;
	}
	
}

public class LietKeTuKhacNhau {

	public static void main(String[] args) throws IOException {
        WordSet ws = new WordSet("VANBAN.in");
        System.out.println(ws);
    }

}
