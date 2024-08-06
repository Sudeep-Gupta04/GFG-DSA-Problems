//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] a = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.longestSubseq(n, a);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends








class Solution {
    public static int[][] initializeArrayint(int rows, int cols, int value) {
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(array[i], value);
        }
        return array;
    }
    
    public static int longestSubseq(int n, int[] a) {
        int[][] dp = initializeArrayint(n, n, -1);
        ArrayList<Integer> al = new ArrayList<>();
        return helper(a, n - 1, dp, al);
    }

    private static int helper(int[] a, int i, int[][] dp, ArrayList<Integer> al) {
        if (i == 0) {
            if (!al.isEmpty() && Math.abs(al.get(al.size() - 1) - a[i]) == 1) {
                return al.size() + 1;
            } else {
                return al.size();
            }
        }
        
        int take = 0;
        if (al.isEmpty() || Math.abs(al.get(al.size() - 1) - a[i]) == 1) {
            al.add(a[i]);
            take = helper(a, i - 1, dp, al);
            al.remove(al.size() - 1);
        }
        
        int notTake = helper(a, i - 1, dp, al);
        return Math.max(take, notTake);
    }
}
