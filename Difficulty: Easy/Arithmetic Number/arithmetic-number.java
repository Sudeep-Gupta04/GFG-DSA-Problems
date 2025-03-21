//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int A = Integer.parseInt(in.readLine());
            int B = Integer.parseInt(in.readLine());
            int C = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            int ans = (ob.inSequence(A, B, C));
            if (ans == 1)
                System.out.println("true");
            else
                System.out.println("false");
        }
        // out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int inSequence(int a, int b, int c) {
        if((b-a)%c==0) return 1;
        return 0;
    }
}