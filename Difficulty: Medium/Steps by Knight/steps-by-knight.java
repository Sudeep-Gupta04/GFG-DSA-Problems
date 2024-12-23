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
       
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        boolean[][] vis = new boolean[N][N];
        return dfs(KnightPos[0]-1, KnightPos[1]-1, TargetPos[0]-1, TargetPos[1]-1, N, vis);
    }

    public int dfs(int x, int y, int fx, int fy, int n, boolean[][] vis) {
        Queue<Pair> q = new ArrayDeque<>();
        if ((x == fx) && (y == fy)) return 0;
        else {
            int c = 0;
            q.add(new Pair(x, y));
            vis[x][y] = true;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Pair p = q.remove();
                    if ((p.x == fx) && (p.y == fy)) return c;
                    int[] xc = {-2, -2, -1, +1, +2, +2, +1, -1};
                    int[] yc = {-1, +1, +2, +2, +1, -1, -2, -2};
                    for (int j = 0; j < yc.length; j++) {
                        int newx = p.x + xc[j];
                        int newy = p.y + yc[j];
                        if (newx < n && newy < n && newx >= 0 && newy >= 0) {
                            if (!vis[newx][newy]) {
                                vis[newx][newy] = true;
                                q.add(new Pair(newx, newy));
                            }
                        }
                    }
                }
                c++;
            }
            return -1;
        }
    }
}