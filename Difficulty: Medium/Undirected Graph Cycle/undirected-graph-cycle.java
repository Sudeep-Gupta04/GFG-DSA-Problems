//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[adj.size()];
        for(int i =0;i<vis.length;i++){
            if(!vis[i] && Findcycle(i,-1,vis,adj)) return true;
        }
        return false;
    }
     private boolean Findcycle(int n, int p, boolean[] vis, ArrayList<ArrayList<Integer>> al) {
        // Mark the current node as visited
        vis[n] = true;
        boolean ans = false;

        // Check all adjacent nodes
        for (int node : al.get(n)) {
            // If the neighbor is not visited, continue DFS
            if (!vis[node]) {
                ans = Findcycle(node, n, vis, al) || ans;
            } else {
                // If the neighbor is visited and not the parent, a cycle is detected
                if (p != node) {
                    return true;
                }
            }
        }

        // Return true if a cycle is detected, otherwise false
        return ans;
    }
}