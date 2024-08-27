//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
   int check = 0;

boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
    boolean[] visited = new boolean[N + 1];  // Adjusted for 1-based indexing
    
    // Step 1: Convert Edges to Adjacency List
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(N + 1);
    for (int i = 0; i <= N; i++) {
        adjList.add(new ArrayList<>());
    }

    for (ArrayList<Integer> edge : Edges) {
        int u = edge.get(0);
        int v = edge.get(1);
        adjList.get(u).add(v);
        adjList.get(v).add(u);  // Assuming an undirected graph
    }

    // Step 2: Perform DFS traversal using the adjacency list
    for (int i = 1; i <= N; i++) {
        if (!visited[i] || check == 1) {
            visited[i] = true;
            dfsTraversal(i, adjList, visited);
            visited[i] = false;
        }
    }
    return check == 1;
}

private boolean checkFor(boolean[] visited) {
    for (int i = 1; i < visited.length; i++) {  // Adjusted to check all nodes in 1-based index
        if (!visited[i]) {
            return false;
        }
    }
    return true;
}

private void dfsTraversal(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
    for (int adjNode : adjList.get(node)) {  // Adjusted for 1-based indexing
        if (!visited[adjNode]) {
            visited[adjNode] = true;
            dfsTraversal(adjNode, adjList, visited);
        }
    }
    if (checkFor(visited)) {
        check = 1;
        return;
    }
    if (check == 1) return;
    visited[node] = false;
}

} 