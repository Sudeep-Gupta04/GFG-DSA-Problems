//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int ans = 0;
      
    static int inversionCount(int arr[]) {
        ans = 0; 
        helper(arr, 0, arr.length - 1);
        return ans;
    }

    static void helper(int arr[], int s, int e) {
        if (s >= e) return;
        int mid = (s + e) / 2;
        helper(arr, s, mid);
        helper(arr, mid + 1, e);
        merge(arr, s, mid, e);
    }

    static void merge(int[] arr, int s, int mid, int e) {
        int[] a1 = Arrays.copyOfRange(arr, s, mid + 1);
        int[] a2 = Arrays.copyOfRange(arr, mid + 1, e + 1);
        int k = s;
        int p1 = 0, p2 = 0;

        while (p1 < a1.length && p2 < a2.length) {
            if (a1[p1] <= a2[p2]) {
                arr[k++] = a1[p1++];
            } else {
                arr[k++] = a2[p2++];
                ans += (a1.length - p1); 
            }
        }

        while (p1 < a1.length) {
            arr[k++] = a1[p1++];
        }

        while (p2 < a2.length) {
            arr[k++] = a2[p2++];
        }
    }
}