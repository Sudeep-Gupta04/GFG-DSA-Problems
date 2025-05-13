//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
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

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().combinationSum4(arr, key));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int combinationSum4(int[] arr, int key) {
        // Complete this function
        int[] dp = new int[key+1];
         Arrays.fill(dp, -1);
        return generateAllSets(arr,key,dp);
    }
      private static int generateAllSets(int[] nums, int target, int[] dp) {
        if(target<0) return 0;
        if(target==0) return 1;
        if(dp[target] != -1) return dp[target];
        
        int ans = 0;
        for(int i =0;i< nums.length;i++){
            ans+=generateAllSets(nums,target-nums[i],dp);
        }
        return dp[target] = ans;
    }
}