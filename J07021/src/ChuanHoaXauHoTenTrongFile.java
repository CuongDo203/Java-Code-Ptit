import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChuanHoaXauHoTenTrongFile {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("DATA.in"));
		while(true) {
			String s = sc.nextLine();
			if(s.equals("END")) {
				break;
			}
			String word[] = s.trim().split("\\s+");
			String res = "";
			for(String x : word) {
				res += x.substring(0,1).toUpperCase()+x.substring(1).toLowerCase() + " ";
			}
			System.out.println(res);
		}
		sc.close();
	}

}
