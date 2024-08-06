//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends




class Solution{
    private int RodCutting(int[] dp, int[] arr, int size) {
        if (size == 0) return 0;
        if (size < 0) return -100007;
        if (dp[size] != -1) return dp[size];

        int count = -100007;
        for (int i = 0; i < arr.length; i++) {
            if (size - (i) < 0) break;
            count = Math.max(arr[i] + RodCutting(dp, arr, size - (i+1)), count);
        }
        return dp[size] = count;
    }
    public int cutRod(int price[], int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return RodCutting(dp,price,n);
    }
}