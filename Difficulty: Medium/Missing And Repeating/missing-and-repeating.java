//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solve {
    
    int[] findTwoElement(int arr[], int n) {
        int[] ans = new int[2];
        int repeating = 0;
        
        // Find the repeating element
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0) {
                repeating = Math.abs(arr[i]);
                break;
            } else {
                arr[index] = -arr[index];
            }
        }
        
        ans[0] = repeating;
        
        // Calculate the sum of absolute values in the array
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.abs(arr[i]);
        }

        // Calculate the expected sum of the first n natural numbers using long to prevent overflow
        long expectedSum;
        if (n % 2 == 0) {
            expectedSum = (long) n / 2 * (n + 1);  // casting n to long before multiplication
        } else {
            expectedSum = (long) n * (n + 1) / 2;  // casting n to long before multiplication
        }

        // Calculate the missing element
        ans[1] = (int) (expectedSum - (sum - repeating)); // casting the result back to int
        return ans;
    }
}


