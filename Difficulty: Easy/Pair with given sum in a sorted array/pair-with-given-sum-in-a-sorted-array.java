//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    int countPair(int k, int arr[]) {
        // Complete the function
        int s = 0;
        int e = arr.length-1;
        int count =0;
        while(s<e){
            if(arr[s]+arr[e]==k){
                count++;
                s++;e--;
            }
            else if(arr[s]+arr[e]>k) e--;
            else s++;
        }
        return count;
        
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);

            inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();
            int res = obj.countPair(k, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends