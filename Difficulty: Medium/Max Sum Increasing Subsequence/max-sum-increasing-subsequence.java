//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends




//User function Template for Java

class Solution
{
     public static int[][] initializeArrayint(int rows, int cols, int value) {
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(array[i], value);
        }
        return array;
    }
    
     public int maxSumIS(int arr[], int n)
    {
        int[][] dp = initializeArrayint(n+1,n+1,-1);
        return ISandMaxSum(dp,0,-1,0,arr);
    }

    private int ISandMaxSum(int[][] dp, int cu, int pr, int sum,int[] arr) {
        if(cu==arr.length){
            return 0;
        }
        if(dp[cu][pr+1]!=-1) return dp[cu][pr+1];
        int take = 0;
        if( pr == -1 || arr[cu]>arr[pr]) take = arr[cu] + ISandMaxSum(dp,cu+1,cu,sum+arr[cu],arr);
        int notTake = ISandMaxSum(dp,cu+1,pr,sum,arr);
        
        return dp[cu][pr+1]= Math.max(take,notTake);
    } 
}