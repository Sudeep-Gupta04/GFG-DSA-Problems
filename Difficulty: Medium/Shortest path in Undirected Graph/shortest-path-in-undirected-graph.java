//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    
     public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++) adj.add(new ArrayList<>());
        for(int i =0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        // Code here
        Queue<Integer> q = new ArrayDeque<>();
        int[] dis = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(dis,-1);
        q.add(src);
        vis[src] = true;
        int reach = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
               int num = q.remove();
               dis[num] = reach;
               for(int node: adj.get(num)){
                  if(!vis[node]){
                      vis[node] = true;
                      q.add(node);
                  }
               }
            }
            reach+=1;
        }
        return dis;
    }
}