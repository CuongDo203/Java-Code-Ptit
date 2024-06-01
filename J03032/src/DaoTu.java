import java.util.Scanner;

public class DaoTu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while(t-- > 0) {
			String[] ar = sc.nextLine().trim().split("\\s+");
			StringBuffer bf = new StringBuffer();
            for (String i : ar) {
                i = new StringBuilder(i).reverse().toString();
                bf.append(i + " ");
            }
            System.out.println(bf);
		}
		sc.close();
	}
}
