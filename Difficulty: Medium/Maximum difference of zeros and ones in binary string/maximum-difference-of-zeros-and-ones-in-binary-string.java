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
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.maxSubstring(s));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
     int maxSubstring(String S) {
        int [] arr = new int[S.length()];
        for(int i =0;i<S.length();i++){
            if(S.charAt(i)=='0') arr[i]=-1;
            else arr[i]=1;
        }
        int mini =0;
        int min =0;
        for(int i =0;i< arr.length;i++){
             min += arr[i];
             mini = Math.min(min,mini);
             if(min>0) min =0;
        }
        if(mini==0) return -1;
        return Math.abs(mini);
    }
}