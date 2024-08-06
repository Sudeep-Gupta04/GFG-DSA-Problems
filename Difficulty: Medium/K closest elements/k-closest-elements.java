//{ Driver Code Starts
// Initial Template for Java

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
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    
    public static class ReverseInsertion implements Comparable<ReverseInsertion> {
        int key;
        int value;

        public ReverseInsertion(Map.Entry<Integer, Integer> entryset) {
            this.key = entryset.getKey();
            this.value = entryset.getValue();
        }

        @Override
        public int compareTo(ReverseInsertion other) {
            return Integer.compare(this.value, other.value);
        }
    }
    
    
   int[] printKClosest(int[] arr, int n, int k, int x) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i =0;i<arr.length;i++){
            if(arr[i]-x==0) continue;
            else {
                mp.put(i,Math.abs(arr[i]-x));
            }
        }
        PriorityQueue<ReverseInsertion> pq = new PriorityQueue<>(new Comparator<ReverseInsertion>() {
            @Override
            public int compare(ReverseInsertion o1, ReverseInsertion o2) {
                return Integer.compare(o2.value, o1.value); // Reversed order (max heap)
            }
        });

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            pq.add(new ReverseInsertion(entry));
            if(pq.size()>k) pq.remove();
        }
        
        int[] ans = new int[k];
        
      while (!pq.isEmpty()) {
            int diff1st = pq.peek().value;
            int first = arr[pq.peek().key];
    
            pq.remove();
            if(pq.size()==0){
                ans[--k]= first;
                break;
            }
            int diff2nd = pq.peek().value;
            if(diff2nd==diff1st){
                int second = arr[pq.peek().key];
                pq.remove();
                if(first>=second) {
                    ans[--k] = second;
                    ans[--k] = first;
                }
                else {
                    ans[--k] = first;
                    ans[--k] = second;
                }
                continue;
            }
            ans[--k] = first;

        }
    return ans;
}
}
