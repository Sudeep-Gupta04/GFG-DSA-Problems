//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class Solution {
    long countTriplets(int n, int sum, long arr[]) {
        Arrays.sort(arr);
        long c = 0;
        for(int i =0;i<arr.length-1;i++){
            long ts = sum - arr[i];
            int j = i+1;
            int k = arr.length-1;
            while(j<k){
             if(arr[j]+arr[k]<ts){
                 c+=(k-j);
                 j++;
             }else{
                 k--;
             }
            }
        }
        return c;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            //            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n = Integer.parseInt(q[0]);
            int k = Integer.parseInt(q[1]);
            //            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            //            String line2 = br.readLine();
            //            String[] a2 = line2.trim().split("\\s+");
            //            long b[] = new long[m];
            //            for (int i = 0; i < m; i++) {
            //                b[i] = Long.parseLong(a2[i]);
            //            }
            Solution ob = new Solution();
            long ans = ob.countTriplets(n, k, a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends