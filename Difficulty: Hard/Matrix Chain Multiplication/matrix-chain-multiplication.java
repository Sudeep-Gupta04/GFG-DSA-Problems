class Solution {
    static int[][] dp;
    static int matrixMultiplication(int arr[]) {
        // code here
        dp = new int[arr.length][arr.length];
        for(int[] i:dp) Arrays.fill(i,-1);
        return helper(1,arr.length-1,arr);
    }

    public static int helper(int i, int j,int[] arr){
        if(i==j) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        int ans = 999999999;
        for(int k =i;k<j;k++){
            ans = Math.min(ans,arr[i-1]*arr[k]*arr[j] + helper(i,k,arr) + helper(k+1,j,arr));
        }
        return dp[i][j] = ans;
    }
}