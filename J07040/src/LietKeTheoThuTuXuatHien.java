import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LietKeTheoThuTuXuatHien {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NHIPHAN.in"));
		ArrayList<String> lst = (ArrayList<String>) ois.readObject();
		Set<String> se = new TreeSet<String>();
		for(String s : lst) {
			String word[] = s.trim().toLowerCase().split("\\s+");
			se.addAll(Arrays.asList(word));
		}
		
		Scanner sc = new Scanner(new File("VANBAN.in"));
		while(sc.hasNext()) {
			String s = sc.next().toLowerCase();
			if(se.contains(s)) {
				System.out.println(s);
				se.remove(s);
			}
		}
	}

}
