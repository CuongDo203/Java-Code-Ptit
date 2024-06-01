import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class TongChuSo {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
		List<String> lst = (List<String>) ois.readObject();
		for(String x : lst) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < x.length(); i++) {
				if(x.charAt(i)>='0' && x.charAt(i)<='9') {
					sb.append(x.charAt(i));
				}
			}
			String s = sb.toString();
			while(s.startsWith("0")) {
				s = s.substring(1);
			}
			int sum = 0;
			for(int i = 0; i < s.length(); i++) {
				sum += (s.charAt(i)-'0');
			}
			System.out.println(s + " " + sum);
		}
	}

}
