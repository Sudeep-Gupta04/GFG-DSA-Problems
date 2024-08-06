//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while(t > 0)
        {
            int n = in.nextInt();
            Geeks obj = new Geeks();
            System.out.println(obj.count(n));
            t--;
        }
    }
}
// } Driver Code Ends




// Complete this function!

class Geeks {
     public static long[][] initializeArraylong(int rows, int cols, long value) {
        long[][] array = new long[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(array[i], value);
        }
        return array;
    }
    
    public long count(int n) {
        long[] prev = new long[n+1];
        for(long i =0;i<prev.length;i++){
            if(i%3==0) prev[(int) i]=1;
        }
        for(int i =0;i<prev.length;i++){
            long nt = prev[i];
            long t =0;
            if(i>=5) t = prev[(int) (i-5)];
            prev[i]= t+nt;
        }
        for(int i =0;i<prev.length;i++){
            long nt = prev[i];
            long t =0;
            if(i>=10) t = prev[(int) (i-10)];
            prev[i]= t+nt;
        }
        return prev[n];
    }

    private long helper(int i, int n, int[] arr, long[][] dp) {
        if(n==0) return 1;
        if(i==0){
            if(n % arr[i]==0) return 1;
            else return 0;
        }
        if(dp[i][n]!=-1) return dp[i][n];
        long not_take = helper(i-1,n,arr,dp);
        long take = 0;
        if(arr[i]<=n) take += helper(i,n-arr[i],arr,dp);
        return dp[i][n] = take+not_take;
    }
}