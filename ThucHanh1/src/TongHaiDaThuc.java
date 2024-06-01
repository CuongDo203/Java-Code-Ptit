import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TongHaiDaThuc {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);       
            DaThuc p = new DaThuc(sc.nextLine());
            DaThuc q = new DaThuc(sc.nextLine());
            DaThuc r = p.cong(q);
            r.out();
    }

}

class DaThuc{
	private List<Integer> soMu, heSo;
	
	public DaThuc(String s) {
		String w[] = s.split(" \\+ ");
		List<Integer> sm = new ArrayList<>();
		List<Integer> hs = new ArrayList<>();
		for(String x : w) {
			hs.add(Integer.parseInt(x.substring(0, x.indexOf('*'))));
			sm.add(Integer.parseInt(x.substring(x.indexOf('^')+1)));
		}
		this.heSo = hs;
		this.soMu = sm;
	}
	
	public DaThuc(List<Integer> soMu, List<Integer> heSo) {
		this.soMu = soMu;
		this.heSo = heSo;
	}
	
	public DaThuc cong(DaThuc o) {
		List<Integer> hs = new ArrayList<>();
		List<Integer> sm = new ArrayList<>();
		int i = 0, j = 0;
		while(i<this.soMu.size() && j < o.soMu.size()) {
			if(this.soMu.get(i) == o.soMu.get(j)) {
				sm.add(this.soMu.get(i));
				hs.add(this.heSo.get(i)+ o.heSo.get(j));
				i++;
				j++;
			}
			else if(this.soMu.get(i)>o.soMu.get(j)) {
				sm.add(this.soMu.get(i));
				hs.add(this.heSo.get(i));
				i++;
			}
			else {
				sm.add(o.soMu.get(j));
				hs.add(o.heSo.get(j));
				j++;
			}
		}
		while(i<this.soMu.size()) {
			sm.add(this.soMu.get(i));
			hs.add(this.heSo.get(i));
			i++;
		}
		while(j < this.soMu.size()) {
			sm.add(o.soMu.get(j));
			hs.add(this.heSo.get(j));
			j++;
		}
		return new DaThuc(sm,hs);
	}
	
	public void out() {
		String res = "";
		for(int i = 0; i < this.soMu.size(); i++) {
			if(this.heSo.get(i)!=0) {
				res += this.heSo.get(i) + "*x^" + this.soMu.get(i);
				if(i<this.soMu.size()-1) {
					res += " + ";
				}
			}
				
			
		}
		System.out.println(res);
	}
}

