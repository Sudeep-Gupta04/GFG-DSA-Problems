//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();

            GFG g = new GFG();
            g.rotate(arr);
            printMatrix(arr);

            System.out.println("~");
        }
    }

    static void printMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) System.out.print(arr[i][j] + " ");
            System.out.println("");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class GFG {
    static void rotate(int mat[][]) {
        // Code Here
        for(int i =0;i< mat.length;i++){
            for(int j =0;j<=i;j++){
                int temp = mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i] = temp;
            }
        }
        for(int i =0;i<mat.length;i++){
            for(int j = 0;j<mat[0].length/2;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[i][mat.length-j-1];
                mat[i][mat.length-j-1] = temp;
            }
        }
    }
}