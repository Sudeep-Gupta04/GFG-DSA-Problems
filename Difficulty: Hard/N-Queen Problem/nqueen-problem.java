//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
     public ArrayList<ArrayList<Integer>> nQueen(int n) {
        
        int[][] bord = new int[n][n];
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        solve(0,bord,al);
        return al;
    }

    private void solve(int row,int[][] bord, ArrayList<ArrayList<Integer>> al) {
        if(row==bord.length){
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i =0;i<bord.length;i++){
                
                for(int j = 0;j<bord.length;j++){
                    if(bord[i][j]==1){
                        ans.add(j+1);
                    }
                }
            }
            al.add(ans);
            return;
        }

        for(int i =0;i<bord.length;i++){
            if(isSafe(row,i,bord)){
                bord[row][i] = 1;
                solve(row+1,bord,al);
                bord[row][i] = 0;
            }
        }
    }

    private boolean isSafe(int r,int i, int[][] bord) {
        // up
        for(int row =0;row<r;row++){
            if(bord[row][i]==1) return false;
        }
        //left
        for(int col =0;col<i;col++){
            if(bord[r][col]==1) return false;
        }
        int row = r;
        int col = i;
        while (r-1 >= 0 && i+1<bord.length){
            if(bord[r-1][i+1]==1) return false;
            r--;i++;
        }
        while (row-1 >= 0 && col-1>=0){
            if(bord[row-1][col-1]==1) return false;
            row--;col--;
        }
        return true;
    }
}