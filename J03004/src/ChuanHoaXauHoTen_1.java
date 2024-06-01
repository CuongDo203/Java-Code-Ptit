import java.util.Scanner;

public class ChuanHoaXauHoTen_1 {

	public static String chuanHoa(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while(t-- > 0) {
			String s = sc.nextLine();
			String res[] = s.trim().split("\\s+");
			for(String x : res) {
				x = chuanHoa(x);
				System.out.print(x + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
