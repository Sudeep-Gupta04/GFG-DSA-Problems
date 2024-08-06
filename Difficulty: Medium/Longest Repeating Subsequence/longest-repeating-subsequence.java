//{ Driver Code Starts
//Initial Template for Java

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
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends






//User function Template for Java

class Solution
{   
    public static int[][] initializeArrayint(int rows, int cols, int value) {
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(array[i], value);
        }
        return array;
    }
    
    public int LongestRepeatingSubsequence(String str)
    {
        int[][] dp = initializeArrayint(str.length(),str.length(),0);
      

        dp[0][0]=0;
        boolean check = false;
        for(int i = 1;i<str.length();i++){
            if(check == true || str.charAt(i)==str.charAt(0)){
                check = true;
                dp[0][i]=1;
                dp[i][0]=1;
            }
        }

        for(int i = 1;i<dp.length;i++){
            for(int j =1;j< dp.length;j++){
                if(i!=j && str.charAt(i)==str.charAt(j)){
                    dp[i][j]= 1+dp[i-1][j-1];
                }else{
                    dp[i][j] =  Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[dp.length-1][dp.length-1];
    }

    private int mirror(String str , int i, int j, int[][] dp) {
        if(i<0 || j < 0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(i!=j && str.charAt(i)==str.charAt(j)){
            int take = 1 + mirror(str,i-1,j-1,dp);
            return dp[i][j] =  take;
        } 
        else {
            int take = mirror(str,i-1,j,dp);
            int notTake = mirror(str,i,j-1,dp);
            return dp[i][j] =  Math.max(take,notTake);
        }
    }
}