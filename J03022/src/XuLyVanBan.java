import java.util.Scanner;

public class XuLyVanBan {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		while(sc.hasNext()) {
			sb.append(sc.next()+" ");
		}
		String res = sb.toString();
		res = res.replaceAll("\\s+", " ");
		res = res.replaceAll("\\s+\\,", "\\,");
		res = res.replaceAll("\\,\\s+", "\\, ");
		res = res.replaceAll("\\.\\s+", "\\. ");
		res = res.replaceAll("\\s+\\.", "\\.");
		res = res.replaceAll("\\s+\\!","\\!");
		res = res.replaceAll("\\!\\s+", "\\! ");
		res = res.replaceAll("\\s+\\?","\\?");
		res = res.replaceAll("\\?\\s+", "\\? ");
		String []sentence = res.trim().split("\\.|\\?|\\!");
		for(String x : sentence) {
			x = x.trim();
			x = x.substring(0,1).toUpperCase()+x.substring(1).toLowerCase();
			System.out.println(x);
		}
		sc.close();
	}

}
