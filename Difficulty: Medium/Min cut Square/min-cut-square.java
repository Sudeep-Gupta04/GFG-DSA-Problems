//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int m = sc.nextInt();
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCut(m,n));
                }
        }
}    
// } Driver Code Ends




class Solution
{
	public static int[][] initialize2DArray(int rows, int cols, int initialValue) {
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = initialValue;
            }
        }
        return array;
    }
    public int minCut(int M, int N)
    {
        int[][] dp = initialize2DArray(M+1,N+1,-1);
        return countSquares(M,N,dp);
    }

    private int countSquares(int m, int n, int[][] dp) {
        if(n==0 || m==0) return 0;
        if(n==m) return 1;
        if(m==1) return n;
        if(n==1) return m;
        if(dp[m][n]!=-1) return dp[m][n];
        int x = Math.min(m,n);
        int p = Integer.MAX_VALUE;
        for(int i=1;i<=x;i++){
            int p1a = 1+ countSquares(m-i,n,dp) + countSquares(i,n-i,dp);
            int p1b = 1+countSquares(m,n-i,dp) + countSquares(m-i,i,dp);
             p = Math.min(Math.min(p1a,p1b),p);
        }
        return dp[m][n] = p;
    }
} 