import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.List;

public class SoNguyenToTrongFileNhiPhan {

	public static int p[] = new int[10001];
	
	public static void sieve() {
		Arrays.fill(p, 1);
		p[0] = p[1] = 0;
		for(int i = 2; i <= Math.sqrt(10000); i++) {
			for(int j = i*i; j <= 10000; j+=i) {
				p[j] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		sieve();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SONGUYEN.in"));
		List<Integer> lst = (List<Integer>)ois.readObject();
		int dd[] = new int[10000];
		for(Integer x : lst) {
			dd[x] += p[x];
		}
		for(int i = 2; i < 10000; i++) {
			if(dd[i]>0) {
				System.out.println(i+" "+dd[i]);
			}
		}
	}

}
