import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TinhTong {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("DATA.in"));
		long sum = 0;
		while(sc.hasNext()) {
			if(sc.hasNextInt()) {
				sum += sc.nextInt();
			}
			else {
				sc.next();
			}
		}
		System.out.println(sum);
		sc.close();
	}

}
