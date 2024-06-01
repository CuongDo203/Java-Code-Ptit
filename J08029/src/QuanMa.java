
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class QuanMa {
    
    public static int solve(ToaDo x, ToaDo y){
        int dx[] = {-1,-2,-2,-1,1,2,2,1};
        int dy[] = {-2,-1,1,2,2,1,-1,-2};
        Queue<ToaDo> q = new LinkedList<>();
        boolean vs[][] = new boolean[20][20];
        q.add(x);
        vs[x.getX()][x.getY()] = true;
        while(!q.isEmpty()){
            ToaDo tmp = q.poll();
            if(tmp.getX() == y.getX() && tmp.getY() == y.getY()){
                return tmp.getStep();
            }
            for(int k = 0; k < 8; k++){
                int i1 = tmp.getX()+dx[k];
                int j1 = tmp.getY()+dy[k];
                if(i1>=1&&i1<=8 && j1>=1&&j1<=8 && !vs[i1][j1]){
                    q.add(new ToaDo(i1, j1, tmp.getStep()+1));
                    vs[i1][j1] = true;
                }
            }
        }
        return 0;

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            String s1 = sc.next().trim();
            String s2 = sc.next().trim();
            int x1 = s1.charAt(0)-'a'+1;
            int y1 = s1.charAt(1) - '0';
            int x2 = s2.charAt(0)-'a'+1;
            int y2 = s2.charAt(1) - '0';
            ToaDo a = new ToaDo(x1, y1, 0);
            ToaDo b = new ToaDo(x2, y2, 0);
            System.out.println(solve(a, b));
        }
        sc.close();
    }
    
}
class ToaDo{
    private int x, y, step;

    public ToaDo(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
    
}
