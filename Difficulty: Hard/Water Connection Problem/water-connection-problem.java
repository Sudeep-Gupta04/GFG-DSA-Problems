//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt();
            int p = sc.nextInt();
            ArrayList<Integer> a = new ArrayList<Integer>();
            ArrayList<Integer> b = new ArrayList<Integer>();
            ArrayList<Integer> d = new ArrayList<Integer>();
            
            for(int i=0;i<p;i++)
            {
                a.add(sc.nextInt());
                b.add(sc.nextInt());
                d.add(sc.nextInt());
            }
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.solve(n, p, a, b, d); 
            System.out.println(ans.size());
            for (int i=0;i<ans.size();i++){ 
                System.out.println(ans.get(i).get(0)+" "+ans.get(i).get(1)+" "+ans.get(i).get(2)); 
            }
        
System.out.println("~");
}
    } 
} 
// } Driver Code Ends

class Solution {
    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    ArrayList<ArrayList<Integer>> solve(int n, int p, ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> d) {
        // Store all target nodes
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < p; i++) {
            hs.add(b.get(i));
        }

        // Create adjacency list (1-based indexing)
        ArrayList<ArrayList<Point>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) al.add(new ArrayList<>());

        for (int i = 0; i < p; i++) {
            al.get(a.get(i)).add(new Point(d.get(i), b.get(i)));
        }

        boolean[] vis = new boolean[n + 1];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!vis[i] && !hs.contains(i)) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                int[] t = new int[2];
                t[0] = -1;
                t[1] = Integer.MAX_VALUE;
                dfs(i, t, al, vis);
                temp.add(t[0]);
                temp.add(t[1]);
                if(t[1]!=Integer.MAX_VALUE)ans.add(temp);
            }
        }
        return ans;
    }

    public void dfs(int i, int[] arr, ArrayList<ArrayList<Point>> al, boolean[] vis) {
        vis[i] = true;
        int c = 0;
        for (Point nod : al.get(i)) {
            if (!vis[nod.y]) {
                c = 1;
                if (nod.x < arr[1]) arr[1] = nod.x;
                dfs(nod.y, arr, al, vis);
            }
        }
        if (c == 0 && arr[0] == -1) {
            arr[0] = i;
        }
    }
}
