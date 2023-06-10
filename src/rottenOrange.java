import java.sql.SQLIntegrityConstraintViolationException;
import java.util.LinkedList;
import java.util.Queue;

public class rottenOrange {
    class Pair{
        int row,col,time;
        Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int checkTime(int [][]A){
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < A.length; i++)
            for(int j = 0; j < A[0].length; j++)
                if(A[i][j] == 2) q.add(new Pair(i,j,0));

        int maxT = Integer.MIN_VALUE;

        while(!q.isEmpty()){
          Pair p = q.poll();
          int row = p.row;
          int col = p.col;
          int time = p.time;
          int []dx = {1,0,-1,0};
          int []dy = {0,1,0,-1};

          for(int i = 0 ; i < 4; i++){
              int x = row+dx[i];
              int y = col+dy[i];
              if(x >= 0 && y >= 0 && x < A.length && y < A[0].length && A[x][y] == 1){
                  A[x][y] = 2;
                  q.add(new Pair(x,y,time+1));
                  maxT = Math.max(maxT,time+1);
              }
          }
        }

        for(int[] x:A)
            for(int i:x)
                if(i == 1) return -1;

        return maxT;
    }
}
