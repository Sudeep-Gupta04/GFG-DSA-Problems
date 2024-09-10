//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


    class Solution {
        
    public int[][] overlappedInterval(int[][] Intervals) {
        Arrays.sort(Intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < Intervals.length; i++) {
            ArrayList<Integer> v = new ArrayList<>();
            v.add(Intervals[i][0]);
            v.add(Intervals[i][1]);
            al.add(v);
        }

        int i = 0;
        while (i < al.size() - 1) {
            if (al.get(i).get(1) >= al.get(i + 1).get(0)) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(al.get(i).get(0));
                temp.add(Math.max(al.get(i).get(1), al.get(i + 1).get(1)));
                al.remove(i);
                al.remove(i);
                al.add(i, temp);
            } else {
                i++;
            }
        }

        int[][] ans = new int[al.size()][2];
        for (int j = 0; j < ans.length; j++) {
            ans[j][0] = al.get(j).get(0);
            ans[j][1] = al.get(j).get(1);
        }

        return ans;
    }
}