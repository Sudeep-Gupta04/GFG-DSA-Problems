//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = A.length-1;i>=0;i--){
            for(int j = B.length-1;j>=0;j--){
                if(pq.size()<K) pq.add(A[i]+B[j]);
                else {
                    if(A[i]+B[j] <= pq.peek()) break;
                    else {
                        pq.add(A[i]+B[j]);
                        pq.remove();
                    }
                }
            }
        }
        List<Integer> l = new ArrayList<>();
        while (!pq.isEmpty()){
            l.add(pq.remove());
        }
        Collections.reverse(l);
        return l;
    }
}
