//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.divAndSub(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String divAndSub(int N) {
        if(N==1) return "Arya";
        int[] dp = new int[N+1];
        dp[0] = 0;
        for(int i =1;i<=N;i++){
            for(int j = 2;j<=5;j++){
                if(dp[i/j] == 0){
                    dp[i] = 1;
                    break;
                }if(i-j>=0 && dp[i-j]==0){
                    dp[i]=1;
                    break;
                }
            }
        }
        if(dp[N]==0) return "Arya";
        else return "Jon";
    }
};