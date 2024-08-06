//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.findCatalan(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends





class Solution {
    public static int findCatalan(int n) {
        
        int mod = 1000000007;
        long[] dp = new long[n+1];
        dp[0]=dp[1]=1;
        for(int i =2;i<=n;i++){
            long ans = 0;
            for(int j = 1;j<=i;j++){
                ans +=  ((dp[j-1]%mod)*(dp[i-j]%mod)) % mod;
            }
            dp[i]=ans % mod;
        }
        return (int)dp[n];
    }
}
        
