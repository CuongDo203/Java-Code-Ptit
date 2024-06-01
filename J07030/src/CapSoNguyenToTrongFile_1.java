import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CapSoNguyenToTrongFile_1 {

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
		ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
		List<Integer> lst1 = (List<Integer>) ois1.readObject();
		Set<Integer> se1 = new TreeSet<Integer>();
		for(int x : lst1) {
			if(p[x]==1) {
				se1.add(x);
			}
		}
		ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
		List<Integer> lst2 = (List<Integer>) ois2.readObject();
		Set<Integer> se2 = new TreeSet<Integer>();
		for(int x : lst2) {
			if(p[x]==1) {
				se2.add(x);
			}
		}
		for(int x : se1) {
			if(se2.contains(MAXN-x) && x < (MAXN-x)) {
				System.out.println(x+" "+(MAXN-x));
			}
		}
	}

}
