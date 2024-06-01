import java.util.Scanner;

public class ChuanHoaXauHoTen_2 {

	public static String chuanHoa(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while(t-- > 0) {
			String s = sc.nextLine();
			String res[] = s.trim().split("\\s+");
			for(int i = 1; i < res.length; i++) {
				System.out.print(chuanHoa(res[i]));
				if(i == res.length - 1) {
					System.out.print(", ");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println(res[0].toUpperCase());
		}
		sc.close();
	}

}
