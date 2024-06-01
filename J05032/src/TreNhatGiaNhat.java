import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TreNhatGiaNhat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<Person> ds = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		while(t-->0) {
			try {
				String name = sc.next();
				Date dob = sdf.parse(sc.next());
				ds.add(new Person(name, dob));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		Collections.sort(ds);
		System.out.println(ds.get(ds.size()-1));
		System.out.println(ds.get(0));
		sc.close();
	}

}

class Person implements Comparable<Person>{
	private String name;
	private Date dob;
	
	public Person(String name, Date dob) {
		super();
		this.name = name;
		this.dob = dob;
	}
	
	@Override
	public int compareTo(Person o) {
		return this.dob.compareTo(o.dob);
	}

	@Override
	public String toString() {
		return name;
	}
	
}