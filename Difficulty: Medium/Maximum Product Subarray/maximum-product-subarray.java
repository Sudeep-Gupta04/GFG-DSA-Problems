//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        // code here
        int n = arr.length;
        int[] pre = new int[arr.length];
        int[] suf = new int[n];
        int pro =1;
        for(int i = 0;i<pre.length;i++){
            if(arr[i]==0){
                pre[i] = 0;
                pro = 1;
            }else{
                pre[i] = pro * arr[i];
                pro = pre[i];
            }
    
        }
        pro = 1;
        for(int i = n-1;i>=0;i--){
            if(arr[i]==0){
                suf[i] = 0;
                pro = 1;
            }else{
                suf[i] = pro * arr[i];
                pro = suf[i];
            }
    
        }
        int ans = Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            ans = Math.max(ans,Math.max(pre[i],suf[i]));
        }
        
        return ans;
    }
}