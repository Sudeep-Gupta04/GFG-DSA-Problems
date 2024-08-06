//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int K = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.numOfSubsets(arr,N,K));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    
     static int numOfSubsets(int[] arr, int N, int K) {
        return computeSubsequenceLessTHanK(0,1,K,arr)-1;
    }

    private static int computeSubsequenceLessTHanK(int i, int pro, int k,int[] arr) {
        if(i==arr.length){
            if(pro<=k) return 1; 
            else return 0;
        }
        int take = 0;
        if(arr[i]*pro<=k) take = computeSubsequenceLessTHanK(i+1,arr[i]*pro,k,arr);
        int NotTake =  computeSubsequenceLessTHanK(i+1,pro,k,arr);
        return take+NotTake;
        
    }
};