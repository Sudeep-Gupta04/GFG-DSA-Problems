//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}

// } Driver Code Ends






//User function Template for Java


class Solution
{
    //Function to find the maximum number of cuts.
      public static int maximizeCuts(int n, int x, int y, int z)
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int[] arr = {x,y,z};
        int ans = RodCutting(dp,arr,n);
        if(ans<=0) return 0;
        else return ans;
        //return RodCutting(dp,arr,n);
    }

    private static int RodCutting(int[] dp,int[] arr, int size) {
        if(size==0) return 0;
        if(size<0) return -10000007;
        if(dp[size]!=-1) return dp[size];

        int count = -10000007;
        for(int i = 0;i<3;i++){
            count = Math.max(1+RodCutting(dp,arr,size-arr[i]),count);
            //System.out.println(count);
        }
        //System.out.println(count);
        return dp[size] = count;
    }
}
