import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LopPair {
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            boolean check = false;
            for(int i = 2; i <= 2*Math.sqrt(n); i++){
                Pair<Integer, Integer> p = new Pair<>(i, n-i);
                if(p.isPrime()){
                    System.out.println(p);
                    check = true;
                    break; 
                }
            }
            if(!check) System.out.println(-1);
        }
    }
}

class Pair<T,U> {
	private T num1;
	private U num2;
	
	private boolean isPrime(int n) {
		for(int i = 2; i*i <= n; i++) {
			if(n%i==0) {
				return false;
			}
		}
		return n>1;
	}

	public Pair(T num1, U num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public boolean isPrime() {
		return isPrime((Integer)num1) && isPrime((Integer) num2);
	}
	
	@Override
	public String toString() {
		return num1 + " " + num2;
	}
}
