//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
     public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[V];
        boolean[] pathvis = new boolean[V];
        for(int i =0;i< adj.size();i++){
            if(!vis[i]){
                if(iscycle_inDirectedgraph(vis,pathvis,i,adj)) return true;
            }
        }
        return false;
    }

    private boolean iscycle_inDirectedgraph(boolean[] vis, boolean[] pathvis, int i, ArrayList<ArrayList<Integer>> adj) {
        vis[i] = true;
        pathvis[i] = true;
        for(int node : adj.get(i)){
            if(!vis[node]){
                if(iscycle_inDirectedgraph(vis,pathvis,node,adj)) return true;
            }
            else{
                if(pathvis[node]) return true;
            }
        }
        pathvis[i] = false;
        return false;
    }
}