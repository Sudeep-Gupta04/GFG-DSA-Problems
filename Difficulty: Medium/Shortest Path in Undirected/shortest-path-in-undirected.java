//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u); // Since the graph is undirected
            }

            int src = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.shortestPath(adj, src);

            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find the shortest path from a source node to all other nodes
    class pair implements Comparable<pair>{
        int weight;
        int node;

        public pair(int weight, int node) {
            this.weight = weight;
            this.node = node;
        }

        @Override
        public int compareTo(pair o) {
            int compare = Integer.compare(this.weight,o.weight);
            if(compare==0) return  Integer.compare(this.node,o.node);
            return compare;
        }
    }
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        PriorityQueue<pair> pq = new PriorityQueue<>();
        int[] dis = new int[adj.size()];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        pq.add(new pair(0,src));
        while(!pq.isEmpty()){
            pair temp = pq.remove();
            for(int nebegior:adj.get(temp.node)){
                if(1+temp.weight<=dis[nebegior]){
                    dis[nebegior] = 1+temp.weight;
                    pq.add(new pair(1+temp.weight,nebegior));
                }
            }
        }
        for(int i =0;i<dis.length;i++){
            if(dis[i]==Integer.MAX_VALUE) dis[i]=-1;
        }
        return dis;
    }
}
