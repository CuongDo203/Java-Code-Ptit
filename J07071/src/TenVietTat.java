import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TenVietTat {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("DANHSACH.in"));
		int n = Integer.parseInt(sc.nextLine());
		List<Person> ds = new ArrayList<>();
		while(n-->0) {
			String s = sc.nextLine();
			ds.add(new Person(s));
		}
		int m = Integer.parseInt(sc.nextLine());
		while(m-->0) {
			String s = sc.next();
			int idx = s.indexOf('*');
			List<Person> lst = new ArrayList<>();
			for(Person ps : ds) {
				String vt = ps.getTenVietTat();
				boolean ok = true;
				if(s.length()!=vt.length()) {
					ok = false;
					continue;
				}
				for(int i = 0; i < idx; i++) {
					if(s.charAt(i)!=vt.charAt(i)) {
						ok = false;
						break;
					}
				}
				for(int i = idx+1; i < s.length(); i++) {
					if(s.charAt(i)!=vt.charAt(i)) {
						ok = false;
						break;
					}
				}
				if(ok) {
					lst.add(ps);
				}
			}
			Collections.sort(lst);
			for(Person ps : lst) {
				System.out.println(ps);
			}
		}
		sc.close();
	}

}

class Person implements Comparable<Person>{
	private String ten, tenVietTat;

	public Person(String ten) {
		this.ten = ten;
		this.tenVietTat = vietTat(ten);
	}
	
	private String vietTat(String s) {
		String res = "";
		String []w = s.split("\\s+");
		for(String x : w) {
			res += x.charAt(0) + ".";
		}
		res = res.substring(0, res.length()-1);
		return res;
	}

	private String Ten() {
		String []w = ten.split("\\s+");
		return w[w.length-1];
	}
	
	private String Ho() {
		String []w = ten.split("\\s+");
		return w[0];
	}
	
	public String getTen() {
		return ten;
	}

	public String getTenVietTat() {
		return tenVietTat;
	}

	@Override
	public String toString() {
		return ten;
	}

	@Override
	public int compareTo(Person o) {
		if(Ten().equals(o.Ten())) {
			return Ho().compareTo(o.Ho());
		}
		else {
			return Ten().compareTo(o.Ten());
		}
	}
	
	
}