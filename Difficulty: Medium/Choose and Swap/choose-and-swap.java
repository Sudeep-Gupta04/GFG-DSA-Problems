//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        Solution obj = new Solution();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine().trim();

            String ans = obj.chooseandswap(A);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String chooseandswap(String str) {
        int n = str.length();
        int[] exists = new int[26]; 

        for (int i = 0; i < n; i++) {
            int idx = str.charAt(i) - 'a';
            exists[idx] = 1;
        }

        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(str);

        for (int i = 25; i >= 1; i--) {
            if (exists[i] == 1) {
                for (int j = i - 1; j >= 0; j--) {
                    if (exists[j] == 1) {
                        char ch1 = (char) (i + 'a');
                        char ch2 = (char) (j + 'a');
                        StringBuilder sb = new StringBuilder(str);
                        for (int k = 0; k < n; k++) {
                            if (sb.charAt(k) == ch1) {
                                sb.setCharAt(k, ch2);
                            } else if (sb.charAt(k) == ch2) {
                                sb.setCharAt(k, ch1);
                            }
                        }
                        pq.add(sb.toString());
                        if (pq.size() > 1) pq.remove();
                    }
                }
            }
        }

        return pq.peek();
    }
}