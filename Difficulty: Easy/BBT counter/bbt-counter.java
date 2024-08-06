//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int h = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.countBT(h));
        }
    }
}
// } Driver Code Ends




//User function Template for Java
class Solution {
  static long countBT(int h) {
    long mod = 1000000007;; // 10^7
    long first = 1;
    long second = 3;
    
    if (h == 1) return first;
    if (h == 2) return second;
    
    for (int num = 3; num <= h; num++) {
        long current = (second * (second + first) + first * second) % mod;
        first = second;
        second = current;
    }
    
    return second % mod;
}
}