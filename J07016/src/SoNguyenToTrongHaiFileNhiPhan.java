
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author win
 */
public class SoNguyenToTrongHaiFileNhiPhan {

    public static boolean isPrime(int n){
        for(int i = 2; i*i <= n; i++){
            if(n%i==0) return false;
        }
        return n>1;
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        List<Integer> a = (List<Integer>) ois1.readObject();
        
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        List<Integer> b = (List<Integer>) ois2.readObject();
        
        int dd1[] = new int[10005];
        int dd2[] = new int[10005];
        Arrays.fill(dd1, 0);
        Arrays.fill(dd2, 0);
        for(Integer x : a){
            if(isPrime(x)){
                dd1[x]++;
            }
        }
        for(Integer x : b){
            if(isPrime(x) && a.contains(x)){
                dd2[x]++;
            }
        }
        for(int i = 2; i <= 10000; i++){
            if(dd2[i]!=0){
                System.out.println(i+" "+dd1[i]+" "+dd2[i]);
            }
        }
    }
    
}
