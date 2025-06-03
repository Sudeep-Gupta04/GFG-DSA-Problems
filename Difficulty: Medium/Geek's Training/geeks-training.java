// User function Template for Java

class Solution {
    int[][] dp;
    public int maximumPoints(int arr[][]) {
        // code here
        dp = new int[arr.length][3];
        for(int[]i:dp) Arrays.fill(i,-1);
        return Math.max(arr[0][0] + solve(1,0,arr), Math.max(
                arr[0][1] + solve(1,1,arr),arr[0][2] + solve(1,2,arr)
        ));
    }
    public int solve(int i,int previ,int[][] arr){
        if(i>=arr.length) return 0;
        if(dp[i][previ]!=-1) return dp[i][previ];
        int p0 = -1000000,p1 = -1000000,p2 = -1000000;
        if(previ!=0) p0 = arr[i][0] + solve(i+1,0,arr);
        if(previ!=1) p1 = arr[i][1] + solve(i+1,1,arr);
        if(previ!=2) p2 = arr[i][2] + solve(i+1,2,arr);

        return dp[i][previ] = Math.max(p0,Math.max(p1,p2));
    }
}