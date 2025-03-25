//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[][] mat = IntMatrix.input(br, n, n);
            
            Solution obj = new Solution();
            int res = obj.findMaxValue(n, mat);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int findMaxValue(int n, int[][] mat) {
        // code here
        int maxx = -10000;  int maxy = -10000;
        int[][] gre = new int[n][n];
        for(int i = n-1;i>=0;i--){
            maxx = Math.max(maxx,mat[n-1][i]);
            maxy = Math.max(maxy,mat[i][n-1]);
            gre[n-1][i] = maxx;
            gre[i][n-1] = maxy;
        }
        for(int i = n-2;i>=0;i--){
            for(int j = n-2;j>=0;j--){
                gre[i][j] = Math.max(mat[i][j], Math.max(gre[i+1][j],gre[i][j+1]));
            }
        }
    int maxDiff = Integer.MIN_VALUE;

    // Step 3: Find the maximum difference
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - 1; j++) {
            maxDiff = Math.max(maxDiff, gre[i + 1][j + 1] - mat[i][j]);
        }
    }

    return maxDiff;
    }
}
        
