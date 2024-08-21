//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution {
     class Pair{
        int x ;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public  int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int N) {
         // Adjust size to handle 1-based indexing
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(KnightPos[0],KnightPos[1]));
        if(KnightPos[0]==TargetPos[0] && KnightPos[1]==TargetPos[1]) return 0;
        boolean[][] visit = new boolean[N+1][N+1];
        visit[KnightPos[0]][KnightPos[1]] = true;
        int x = solve( KnightPos[0], KnightPos[1], TargetPos[0], TargetPos[1], N,q,visit);
        if (x == 10000) return -1;
        else return x;
    }

    private  int solve( int row, int col, int targetrow, int targetcol, int n,Queue<Pair> q,boolean[][] visit) {
        int way = 0;
        while (!q.isEmpty()){
            int size = q.size();
            way++;
            
            for(int j =0;j<size;j++){
                Pair ele = q.remove();
                int[] x = {-2, -2, -1, 1, 2, 2, -1, 1};
                int[] y = {-1, 1, 2, 2, -1, 1, -2, -2};
                for (int i = 0; i < x.length; i++) {
                    if(ele.x+x[i]==targetrow && ele.y+y[i]==targetcol) return way;
                    else {
                        if(ele.x+x[i]>=1 && ele.x+x[i]<=n && ele.y+y[i]>=1 && ele.y+y[i]<=n && !visit[ele.x+x[i]][ele.y+y[i]]) {
                            visit[ele.x+x[i]][ele.y+y[i]] = true;
                            q.add(new Pair(ele.x+x[i],ele.y+y[i]));
                    }
                } 
            }
        }
    
    }
    return 10000;
}
}
