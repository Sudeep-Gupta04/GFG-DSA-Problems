//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
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
     static int equalPartition(int N, int[] arr)
    {   int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        if (sum % 2 != 0) return 0;
        int target = sum / 2;
        boolean[] prev = new boolean[target + 1];
        prev[0] = true;
        if (arr[0] <= target) {
            prev[arr[0]] = true;
        }
        for (int i = 1; i < N; i++) {
            boolean[] curr = new boolean[target + 1];
            curr[0] = true;
            for (int j = 1; j <= target; j++) {
                boolean notTake = prev[j];
                boolean take = false;
                if (arr[i] <= j) {
                    take = prev[j - arr[i]];
                }
                curr[j] = take || notTake;
            }
            prev = curr.clone();
        }
        return prev[target] ? 1 : 0;
    }

    private static boolean FindTargetSum(int[] arr, int i, int target, int[][] dp) {
       if(target == 0) return true;
        if(i==0){
            return arr[i] == target;
        }
        if(dp[i][target]!=-1) return dp[i][target] != 0;

        boolean take = false;
        if(arr[i]<=target) take = FindTargetSum(arr,i-1,target-arr[i],dp);

        boolean notTake = FindTargetSum(arr,i-1,target,dp);

        boolean ans = take || notTake;
        if(ans) dp[i][target] = 1;
        else {
            dp[i][target] = 0;
        }
        return ans;
    }
}