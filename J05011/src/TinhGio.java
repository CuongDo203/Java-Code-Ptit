import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TinhGio {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<Gamer> ds = new ArrayList<>();
		while(t-->0) {
			ds.add(new Gamer(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
		}
		ds.sort(new Comparator<Gamer>() {

			@Override
			public int compare(Gamer o1, Gamer o2) {
				if(o1.getGio()==o2.getGio()) {
					return o2.getPhut()-o1.getPhut();
				}
				else
					return o2.getGio()-o1.getGio();
			}
		});
		for(Gamer gm : ds) {
			System.out.println(gm);
		}
		sc.close();
	}

}

class Gamer{
	private String ma, ten;
	private String gioVao, gioRa;
	private int gio, phut;
	
	public int getGio() {
		return gio;
	}

	public void setGio(int gio) {
		this.gio = gio;
	}

	public int getPhut() {
		return phut;
	}

	public void setPhut(int phut) {
		this.phut = phut;
	}

	public Gamer(String ma, String ten, String gioVao, String gioRa) {
		this.ma = ma;
		this.ten = ten;
		this.gioVao = gioVao;
		this.gioRa = gioRa;
		this.gio = Integer.parseInt(this.gioRa.substring(0,2)) - Integer.parseInt(this.gioVao.substring(0,2));
		this.phut = Integer.parseInt(this.gioRa.substring(3)) - Integer.parseInt(this.gioVao.substring(3));
		if(this.phut<0) {
			this.phut += 60;
			this.gio--;
		}
	}

	@Override
	public String toString() {
		return ma + " "+ ten + " " + this.gio + " gio "+ this.phut+" phut";
	}
	
}