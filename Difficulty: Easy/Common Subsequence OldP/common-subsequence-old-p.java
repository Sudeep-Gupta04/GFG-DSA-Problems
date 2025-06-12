// User function template for Java
class Solution {
    static int[][] dp;
    static int commonSubseq(String S1, String S2) {
        // code here
        int n1 = S1.length();
        int n2 = S2.length();
        dp = new int[n1][n2];
        for(int[] i:dp) Arrays.fill(i,-1);
        int ans = helper(n1-1,n2-1,S1,S2);
        return ((ans==0)?0:1);
    }
    private static int helper(int i, int j, String s1, String s2) {
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ntake = Math.max(helper(i-1,j,s1,s2),helper(i,j-1,s1,s2));
        int take = 0;
        if(s1.charAt(i)==s2.charAt(j))  take = 1 + helper(i-1,j-1,s1,s2);
        return dp[i][j] = Math.max(take,ntake);
    }
}