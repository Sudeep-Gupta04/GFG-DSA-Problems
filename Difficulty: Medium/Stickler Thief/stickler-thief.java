//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            // calling method findMaxSum() of class solve
            System.out.println(new Solution().findMaxSum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int findMaxSum(int arr[]) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        return solve(dp,arr,0);
    }

    int solve(int[] dp , int[] arr, int i){
        if(i>=arr.length) return 0;

        if(dp[i]!=-1) return dp[i];

        int t = arr[i] + solve(dp,arr,i+2);
        int nt = solve(dp,arr,i+1);
        dp[i] = Math.max(t,nt);
        return dp[i];
    }
}