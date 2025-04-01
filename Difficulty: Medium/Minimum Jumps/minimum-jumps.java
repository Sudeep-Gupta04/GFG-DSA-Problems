//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
    int n = arr.length;
    int[] dp = new int[n];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[n - 1] = 0;

    for (int i = n - 2; i >= 0; i--) {
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= arr[i] && i + j < n; j++) {
            min = Math.min(min, dp[i + j]);
        }
        if (min != Integer.MAX_VALUE) {
            dp[i] = 1 + min;
        }
    }
    return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
}
}