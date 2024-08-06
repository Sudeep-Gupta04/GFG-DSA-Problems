//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution{
    public static int[][] initializeArrayint(int rows, int cols, int value) {
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(array[i], value);
        }
        return array;
    }
     static int nCr(int n, int r) {
        int[][] dp = initializeArrayint(n+1,r+1,-1);
        int mod = 1000000007;
        return findAns(n,r,dp,mod);
    }

    private static int findAns(int n, int r,int[][] dp,int mod) {
        if(n==r || r==0) return 1;
        if(n<0 || r<0 || r>n) return 0;

        if(dp[n][r]!=-1) return dp[n][r];
        return dp[n][r] = (findAns(n-1,r-1,dp,mod) + findAns(n-1,r,dp,mod))%mod;
    }
}