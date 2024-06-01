import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SoKhacNhauTrongFile_1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("DATA.in"));
		int d[] = new int[1005];
		while(sc.hasNext()) {
			int n = sc.nextInt();
			d[n]++;
		}
		for(int i = 0; i < 1000; i++) {
			if(d[i]>0) {
				System.out.println(i+ " " + d[i]);
			}
		}
		sc.close();
	}

}
