
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TimViTriXauCon {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("STRING.in"));
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int k = 0;
            while(true){
                k = s1.indexOf(s2, k);
                if(k==-1) break;
                System.out.printf("%d ", ++k);
            }
            System.out.println();
        }
        sc.close();
    }
    
}
