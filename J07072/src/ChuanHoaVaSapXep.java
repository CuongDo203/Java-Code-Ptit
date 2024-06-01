import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ChuanHoaVaSapXep {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("DANHSACH.in"));
		List<Name> ds = new ArrayList<>();
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			ds.add(new Name(s));
		}
		Collections.sort(ds);
		for(Name name : ds) {
			System.out.println(name);
		}
		sc.close();
	}

}

class Name implements Comparable<Name>{
	private String ten;

	public Name(String ten) {
		this.ten = chuanHoa(ten);
	}
	
	private String chuanHoa(String s) {
		String w[] = s.trim().split("\\s+");
		String res = "";
		for(String x : w) {
			res += x.substring(0,1).toUpperCase() + x.substring(1).toLowerCase() + " ";
		}
		res = res.substring(0, res.length()-1);
		return res;
	}

	private String getTen() {
		String w[] = ten.trim().split("\\s+");
		return w[w.length-1];
	}
	
	private String getHo() {
		String w[] = ten.trim().split("\\s+");
		return w[0];
	}
	
	private String getHoDem() {
		String w[] = ten.trim().split("\\s+");
		String res = "";
		for(int i = 1; i < w.length-1; i++) {
			res += w[i];
		}
		return res;
	}
	
	@Override
	public int compareTo(Name o) {
		if(getTen().equals(o.getTen())) {
			if(getHo().equals(o.getHo())) {
				return getHoDem().compareTo(o.getHoDem());
			}
			else {
				return getHo().compareTo(o.getHo());
			}
		}
		else {
			return getTen().compareTo(o.getTen());
		}
	}

	@Override
	public String toString() {
		return ten;
	}
	
	
}