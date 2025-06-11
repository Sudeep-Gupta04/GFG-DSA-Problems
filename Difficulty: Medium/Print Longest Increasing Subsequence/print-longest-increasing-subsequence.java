// User function Template for Java

class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        int n = arr.length;
        // Code here
        int[] path = new int[n];
        int[] dp = new int[n];
        for(int i =0;i<n;i++) path[i] = i;
        Arrays.fill(dp,1);
        int max = 1;
        int maxidx = 0;
        for(int i =1;i<n;i++){
            for(int j = i-1;j>=0;j--){
                if(arr[j]<arr[i] && dp[i]<=1+dp[j]){
                    path[i] = j;
                    dp[i] = 1 + dp[j];
                }
            }
            if(dp[i]>max){
                max = dp[i];
                maxidx = i;
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        int i = maxidx;
        //System.out.println(Arrays.toString(path));
        while(path[i]!=i){
            al.add(arr[i]);
            i = path[i];
        }
        al.add(arr[i]); 
        Collections.reverse(al);
        return al;
    }
}
