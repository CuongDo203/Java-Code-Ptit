
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BienDoiS_T {

    public static int solve(int a, int b){
        Queue<Data> q = new LinkedList<>();
        boolean vs[] = new boolean[1000001];
        Arrays.fill(vs, false);
        vs[a] = true;
        q.add(new Data(a, 0));
        while(!q.isEmpty()){
            Data tmp = q.poll();
            if(tmp.getValue()==b){
                return tmp.getStep();
            }
            if(!vs[tmp.getValue()-1] && tmp.getValue()-1>0){
                vs[tmp.getValue()-1] = true;
                q.add(new Data(tmp.getValue()-1, tmp.getStep()+1));
            }
            if(!vs[tmp.getValue()*2] && tmp.getValue()<b){
                vs[tmp.getValue()*2] = true;
                q.add(new Data(tmp.getValue()*2, tmp.getStep()+1));
            }
        }
        return 1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(solve(a, b));
        }
        sc.close();
    }
    
}

class Data{
    private int value, step;

    public Data(int value, int step) {
        this.value = value;
        this.step = step;
    }

    public int getValue() {
        return value;
    }

    public int getStep() {
        return step;
    }
}
