import java.util.Scanner;

public class SoLaMa {

	static int getVal(char c) {
		switch (c){
			case 'I':
				return 1;
			case 'V' :
				return 5;
			case 'X':
				return 10;
			case 'L':
				return 50;
			case 'C':
				return 100;
			case 'D':
				return 500;
			case 'M':
				return 1000;
			default:
				return 0;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			String s = sc.next();
			long sum = 0;
			sum += getVal(s.charAt(s.length()-1));
			for(int i = s.length()-2; i >= 0; i--) {
				if(getVal(s.charAt(i))>=getVal(s.charAt(i+1))) {
					sum += getVal(s.charAt(i));
				}
				else {
					sum -= getVal(s.charAt(i));
				}
			}
			System.out.println(sum);
		}
		sc.close();
	}

}
