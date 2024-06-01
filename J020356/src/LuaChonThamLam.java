import java.util.Scanner;

public class LuaChonThamLam {

	public static String genMax(int n, int s) {
		String res = "";
		int len = n, sum = s;
		if(sum == 0) {
			if(len == 1) return "0";
			else return "-1";
		}
		while(sum > 9) {
			res += "9";
			sum -= 9;
		}
		if(sum != 0) {
			res += sum;
		}
		while(res.length() < len) {
			res += "0";
		}
		return res;
	}
	
	public static String genMin(int n, int s) {
		String res = "";
		int len = n, sum = s;
		if(sum == 0) {
			if(len == 1) return "0";
			else return "-1";
		}
		while(len-- > 0) {
			if(sum > 9) {
				res = "9" + res;
				sum -= 9;
			}
			else {
				if(len == 0) {
					res = sum + res;
				}
				else {
					res = (sum-1) + res;
				}
				sum = 1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		if(n*9 < s) {
			System.out.println("-1 -1");
		}
		else {
			System.out.println(genMin(n, s) + " " + genMax(n,s));
		}
		sc.close();
	}

}
