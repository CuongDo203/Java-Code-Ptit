import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SoNguyenToLonNhatTrongFile {

	public static final int MAXN = (int)1e6;
	
	public static int p[] = new int[MAXN+1];
	
	public static void sieve() {
		Arrays.fill(p, 1);
		p[0] = p[1] = 0;
		for(int i = 2; i <= Math.sqrt(MAXN); i++) {
			if(p[i]==1) {
				for(int j=i*i; j <= MAXN; j+=i) {
					p[j] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		sieve();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
		List<Integer> lst = (ArrayList<Integer>)ois.readObject();
		int dd[] = new int[MAXN+1];
		for(Integer x : lst) {
			dd[x] += p[x];
		}
		int cnt = 0;
		for(int i = MAXN; i >= 2; i--) {
			if(dd[i]>0) {
				System.out.println(i+" "+dd[i]);
				cnt++;
				if(cnt==10) {
					break;
				}
			}
		}
	}

}
