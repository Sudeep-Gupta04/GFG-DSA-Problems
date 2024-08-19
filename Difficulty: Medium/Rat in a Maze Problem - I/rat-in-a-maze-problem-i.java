//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
      int N;
    int M;
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        N = mat.length;
        M = mat[0].length;
        boolean[][] vis = new boolean[N][M];
        ArrayList<String> al = new ArrayList<>();
        helper(mat,"",al,0,0,vis);
        return al;
    }
    private void helper(int[][] mat, String s, ArrayList<String> al, int r, int c, boolean[][] vis) {
    if (r == N-1 && c == M-1 && mat[r][c] != 0) {
        al.add(s);
        return;
    }
    if (r >= N || c >= M || r < 0 || c < 0 || mat[r][c] == 0 || vis[r][c]) {
        return;
    }

    vis[r][c] = true;

    if (c - 1 >= 0 && mat[r][c - 1] != 0) {
        helper(mat, s + "L", al, r, c - 1, vis);
    }

    if (c + 1 < M && mat[r][c + 1] != 0) {
        helper(mat, s + "R", al, r, c + 1, vis);
    }

    if (r + 1 < N && mat[r + 1][c] != 0) {
        helper(mat, s + "D", al, r + 1, c, vis);
    }

    if (r - 1 >= 0 && mat[r - 1][c] != 0) {
        helper(mat, s + "U", al, r - 1, c, vis);
    }

    vis[r][c] = false;
}

}