//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        adj.get(c).remove(Integer.valueOf(d));
        adj.get(d).remove(Integer.valueOf(c));
        boolean[] vis = new boolean[V];
        dfs(c,d,adj,vis);
        if(vis[d]) return 0;
        return 1;
    }
    
    public static void dfs(int c, int d , ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        vis[c] = true;
        for(int i:adj.get(c)){
            if(!vis[i]){
                dfs(i,d,adj,vis);
            }
        }
    }

}