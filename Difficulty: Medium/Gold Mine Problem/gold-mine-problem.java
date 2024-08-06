//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} 
// } Driver Code Ends




//User function Template for Java

class Solution{
    public static int[][] initializeArrayint(int rows, int cols, int value) {
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(array[i], value);
        }
        return array;
    }
    static int maxGold(int n, int m, int[][] M)
    {
        int[][] dp = initializeArrayint(n,m,-1);
        int maxi = Integer.MIN_VALUE;

        for(int i =0;i<n;i++){
            maxi = Integer.max(maxi,MaximumPathSum(i,0,dp,M));
        }
        return maxi;
    }

    private static int MaximumPathSum(int i, int j, int[][] dp, int[][] val) {
         if(i<0 || i > val.length-1) return 0;
        if(j==val[0].length-1) return val[i][j];
       
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int topDig = val[i][j] + MaximumPathSum(i-1,j+1,dp,val);
        int rigtht = val[i][j] + MaximumPathSum(i,j+1,dp,val);
        int botDig = val[i][j] + MaximumPathSum(i+1,j+1,dp,val);
        
        return dp[i][j] = Math.max(topDig,Math.max(rigtht,botDig));
    }
}