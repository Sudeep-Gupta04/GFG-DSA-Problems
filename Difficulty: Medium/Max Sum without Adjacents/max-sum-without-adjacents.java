//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    public static int[][] initializeArrayint(int rows, int cols, int value) {
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(array[i], value);
        }
        return array;
    }
    
      int findMaxSum(int arr[], int n) {
    //   int[][] dp =initializeArrayint(n+1,n+1,-1);
    //   return maxnonAdjecentSum(dp,arr,0,-1);
       if(n==1) return arr[0];
       // int[][] dp = new int[n+1][n+1];
       //return maxnonAdjecentSum(dp,arr,0,-1);
        int[] dp = new int[n];
        int first = dp[0] = arr[0];
        int second = dp[1] = Math.max(dp[0],arr[1]);

        for(int i = 2;i<arr.length;i++){
            int curr = Math.max(first+arr[i],second);
            first = second;
            second = curr;
        }
        return second;
    }

    private int maxnonAdjecentSum(int[][] dp, int[] arr, int cu, int pr) {
        if(cu==arr.length) return 0;

        if(dp[cu][pr+1]!=-1) return dp[cu][pr+1];
        int take = 0;
        if( pr == -1 || cu-(pr)!=1) take = arr[cu] + maxnonAdjecentSum(dp,arr,cu+1,cu);
        int notTake = maxnonAdjecentSum(dp,arr,cu+1,pr);

        return dp[cu][pr+1]= Math.max(take,notTake);
    }
}