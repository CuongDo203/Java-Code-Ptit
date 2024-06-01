import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LoaiBoSoNguyen {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("DATA.in"));
		List<String> lst = new ArrayList<>();
		while(sc.hasNext()) {
			if(sc.hasNextInt()) {
				sc.nextInt();
			}
			else {
				lst.add(sc.next());
			}
		}
		Collections.sort(lst);
		for(String x : lst) {
			System.out.print(x + " ");
		}
		System.out.println();
		sc.close();
	}
}
