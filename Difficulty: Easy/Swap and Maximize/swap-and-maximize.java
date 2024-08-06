//{ Driver Code Starts
import java.io.*;
import java.util.*;

// Driver class

// } Driver Code Ends
// User function Template for Java

class Solution {
    public long maxSum(Long arr[]) {
        // code here
        Arrays.sort(arr);
        int s = 1; int e = arr.length-2;
        while (s<=e){
            long temp = arr[e];
            arr[e] = arr[s];
            arr[s] = temp;
            s+=2;e-=2;
        }
        long ans =0;
        for(int i =1;i<arr.length;i++){
            ans+= Math.abs(arr[i]-arr[i-1]);
        }
        return ans+= Math.abs(arr[arr.length-1]-arr[0]);
    }
}



//{ Driver Code Starts.
class Main {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the Long integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into Long integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            // Convert ArrayList to array
            Long[] arr = new Long[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call maxSum method and print result
            long ans = ob.maxSum(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends