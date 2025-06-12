// User function Template for Java

class Solution {
    static int[][] dp;
    static HashMap<String , HashSet<String>> hm;
    public static List<String> allLCS(String s1, String s2) {
        hm = new HashMap<>();
        int n1 = s1.length();
        int n2 = s2.length();
        // Code here
        dp = new int[n1][n2];
        for(int[] i:dp) Arrays.fill(i,-1);
        helper(n1-1,n2-1,s1,s2);
        ArrayList<String> al =  new ArrayList<>(helperr(n1 - 1, n2 - 1, s1, s2));
        Collections.sort(al);
        return al;
    }

    private static HashSet<String> helperr(int i, int j,String s1, String s2) {
        if(i<0 || j<0) return new HashSet<>(Set.of(""));

        String key = i+","+j;
        if(hm.containsKey(key)) return hm.get(key);
        HashSet<String> newhs = new HashSet<>();
        if(s1.charAt(i)==s2.charAt(j)){
            char ch = s1.charAt(i);
            HashSet<String>  hs = helperr(i-1,j-1,s1,s2);
            for(String st:hs){
                newhs.add(st+ch);
            }
        }else{
            int up = 0; int lft =0;
            if(i-1>=0) up = dp[i-1][j];
            if(j-1>=0) lft = dp[i][j-1];
            int max = Math.max(up,lft);
            HashSet<String> lfths = new HashSet<>();
            HashSet<String> uphs = new HashSet<>();
            if(max==lft){
                lfths = helperr(i,j-1,s1,s2);
            }
            if(max==up){
                uphs = helperr(i-1,j,s1,s2);
            }
            for(String st:lfths) newhs.add(st);
            for(String st:uphs) newhs.add(st);
        }
        hm.put(key,newhs);
        return newhs;
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