//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int R = Integer.parseInt(read.readLine());
            int C = Integer.parseInt(read.readLine());
            int matrix[][] = new int[R][C];
            int c = 0;
            for (int i = 0; i < R; i++) {
                String line[] = read.readLine().trim().split(" ");
                for (int j = 0; j < C; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int median(int mat[][]) {
        // code here
        int min = 2000;int max = 0;
        for(int i =0;i<mat.length;i++){
            min = Math.min(min,mat[i][0]);
            max = Math.max(max,mat[i][mat[0].length-1]);
        }
        int c = mat.length*mat[0].length/2;
        while(min<=max){
            int mid = (min+max)/2;
            if(isValid(mid,c,mat)) max = mid -1;
            else min = mid+1;
        }
        return min; // Changed from max to min
    }
    public boolean isValid(int mid, int c, int[][] mat){
        
        int count = 0;
        for(int i =0;i<mat.length;i++){
            int s = 0; int e = mat[0].length-1;
            while(s<=e){
                int m = (s+e)/2;
                if(mat[i][m]<=mid) s = m+1; // Changed from s = mid+1 to s = m+1
                else e = m-1;
            }
            count += s; // Changed from (s+1) to s
        }
        //System.out.println(count+" "+mid);
        return count>c;
    }
}