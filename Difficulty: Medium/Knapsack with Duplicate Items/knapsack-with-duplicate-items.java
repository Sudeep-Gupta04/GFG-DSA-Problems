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
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
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
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        //int[][] dp = initializeArrayint(N,W+1,-1);
        //return MaximizeProfit(dp,N-1,W,val,wt);
         
        // int[][] dp = initializeArrayint(N,W+1,0);
        // for(int i =1;i<=W;i++){
        //     dp[0][i] = (i/wt[0])*val[0];
        // }
        int[] prev = new int[W+1];
        for(int i =1;i<=W;i++){
            prev[i] = (i/wt[0])*val[0];
        }
        int[] curr = new int[W+1];
        for(int i =1;i<N;i++){

            for(int j = 0;j<W+1;j++){

                int take = Integer.MIN_VALUE;
                if(wt[i]<=j) take = val[i]+curr[j-wt[i]];

                int notTake = prev[j];

                curr[j] =  Math.max(take,notTake);
//               dp[i][j] = Math.max(take,notTake);
            }
            prev = curr;
        }
        return prev[W];
    }

    private static int MaximizeProfit(int[][] dp, int i, int w, int[] val, int[] wt) {
        if(i==0){
            if(wt[i]<=w) return (w/wt[i])*val[i];
            else return 0;
        }
        if(dp[i][w]!=-1) return dp[i][w];
        int take = Integer.MIN_VALUE;
        if(wt[i]<=w) take = val[i]+MaximizeProfit(dp,i,w-wt[i],val,wt);
        int notTake = MaximizeProfit(dp,i-1,w,val,wt);
        return dp[i][w] = Math.max(take,notTake);
    }
}