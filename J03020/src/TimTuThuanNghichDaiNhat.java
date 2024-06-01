import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class TimTuThuanNghichDaiNhat {

	public static boolean tn(String s) {
		int l = 0, r = s.length()-1;
		while(l < r) {
			if(s.charAt(l)!=s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> mp = new LinkedHashMap<>();
		int len = 1, val = 1;
		while(sc.hasNext()) {
			String s = sc.next();
			if(tn(s)) {
				if(mp.containsKey(s)) {
					mp.put(s, mp.get(s)+1);
				}
				else {
					mp.put(s, 1);
				}
				len = Math.max(len, s.length());
				
			}
		}
		for(Map.Entry<String, Integer> e : mp.entrySet()) {
			if(e.getKey().length() == len) {
				val = Math.max(val, e.getValue());
				System.out.println(e.getKey()+" "+e.getValue());
			}
		}
//		for(Map.Entry<String, Integer> e : mp.entrySet()) {
//			if(e.getValue()==val) {
//				System.out.print(e.getKey()+" "+val);
//			}
//		}
		sc.close();
	}

}
