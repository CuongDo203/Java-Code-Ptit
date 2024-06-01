import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class SoThuanNghichTrongFile {

	public static boolean isThuanNghich(String s) {
		StringBuilder sb = new StringBuilder(s).reverse();
        if (!sb.toString().equals(s)) {
            return false;
        }

        if (s.length() % 2 == 0 || s.length() == 1) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) - '0') % 2 == 0) {
                return false;
            }
        }
        return true;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
		List<Integer> lst1 = (List<Integer>)ois1.readObject();
		ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
		List<Integer> lst2 = (List<Integer>)ois2.readObject();
		int dd[] = new int[1000001];
		for(int x : lst1) {
			if(isThuanNghich(x+"") && lst2.contains(x)) {
				dd[x]++;
			}
		}
		for(int x : lst2) {
			if(isThuanNghich(x+"") && dd[x]!=0) {
				dd[x]++;
			}
		}
		int cnt =0;
		for(int i = 0; i <= 1000000; i++) {
			if(dd[i] > 0) {
				System.out.println(i + " " + dd[i]);
				cnt++;
			}
			if(cnt == 10) {
				break;
			}
		}
	}

}
