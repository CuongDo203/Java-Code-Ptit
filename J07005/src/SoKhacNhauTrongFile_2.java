import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SoKhacNhauTrongFile_2 {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		DataInputStream dis = new DataInputStream(new FileInputStream("DATA.in"));
		int d[] = new int[1005];
		for(int i = 0; i < 100000; i++) {
			d[dis.readInt()]++;
		}
		for(int i = 0; i < 1000; i++) {
			if(d[i]>0) {
				System.out.println(i+" " +d[i]);
			}
		}
		dis.close();
	}
}
