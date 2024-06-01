
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;


public class QuayHinhVuong {

    public static String quayPhai(String s){
        StringBuilder ro = new StringBuilder("");
        ro.append(s.charAt(0));
        ro.append(s.charAt(4));
        ro.append(s.charAt(1));
        ro.append(s.charAt(3));
        ro.append(s.charAt(5));
        ro.append(s.charAt(2));
        return ro.toString(); 
    }
    
    public static String quayTrai(String s){
        StringBuilder ro = new StringBuilder("");
        ro.append(s.charAt(3));
        ro.append(s.charAt(0));
        ro.append(s.charAt(2));
        ro.append(s.charAt(4));
        ro.append(s.charAt(1));
        ro.append(s.charAt(5));
        return ro.toString();
    }
    
    public static int solve(String s, String t){
        Queue<String> q = new LinkedList<>();
        Set<String> se = new HashSet<>();
        q.add(s);
        se.add(s);
        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                String tmp = q.poll();
                if(tmp.equals(t)) return cnt;
                String s1 = quayPhai(tmp);
                String s2 = quayTrai(tmp);
                if(s1.equals(t)||s2.equals(t)) return cnt + 1;
                if(!se.contains(s1)){
                    se.add(s1);
                    q.add(s1);
                }
                if(!se.contains(s2)){
                    se.add(s2);
                    q.add(s2);
                }
            }
            cnt++;
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String start = sc.nextLine().replaceAll(" ", "");
            String end = sc.nextLine().replaceAll(" ", "");
            System.out.println(solve(start, end));
        }
        sc.close();
    }
    
}
