import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SoKhacNhauTrongFile_3 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
		ArrayList<Integer> a = (ArrayList<Integer>)ois.readObject();
		int d[] = new int[1005];
		for(Integer x : a) {
			d[x]++;
		}
		for(int i = 0; i < 1000; i++) {
			if(d[i]>0) {
				System.out.println(i+" "+d[i]);
			}
		}
		
	}

}
