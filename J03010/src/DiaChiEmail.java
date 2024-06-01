import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DiaChiEmail {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		ArrayList<String> dd = new ArrayList<>();
		while(t-- > 0) {
			String s = sc.nextLine();
			String res[] = s.trim().split("\\s+");
			StringBuffer bf = new StringBuffer();
			bf.append(res[res.length-1].toLowerCase());
			for(int i = 0; i < res.length-1; i++) {
				bf.append(res[i].substring(0,1).toLowerCase());
			}
			dd.add(bf+"");
			int cnt = Collections.frequency(dd, bf+"");
			if(cnt != 1) {
				bf.append(cnt+"");
			}
			bf.append("@ptit.edu.vn");
			System.out.println(bf);
		}
		sc.close();
	}

}
