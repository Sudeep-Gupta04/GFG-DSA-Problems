//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int[] ans = new Solution().findSurpasser(arr, n);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends



//     # STUDY THIS NOT UNDERSTOOD #

//User function Template for Java

class Solution {
    
    private void merge(int[] arr, int l, int m, int r, Map<Integer, Integer> hm) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }
        
        int i = 0, j = 0, k = l;
        int c = 0;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                hm.put(L[i], hm.getOrDefault(L[i], 0) + c);
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
                c++;
            }
        }
        
        while (i < n1) {
            hm.put(L[i], hm.getOrDefault(L[i], 0) + c);
            arr[k++] = L[i++];
        }
        
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }
    
    private void mergeSort(int[] arr, int l, int r, Map<Integer, Integer> hm) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m, hm);
            mergeSort(arr, m + 1, r, hm);
            merge(arr, l, m, r, hm);
        }
    }
    
    public int[] findSurpasser(int[] arr, int n) {
        Map<Integer, Integer> hm = new HashMap<>();
        int[] dup = arr.clone();
        mergeSort(dup, 0, n - 1, hm);
        
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(arr[i])) {
                result[i] = (n - 1) - i - hm.get(arr[i]);
            } else {
                result[i] = (n - 1) - i;
            }
        }
        return result;
    }
}
