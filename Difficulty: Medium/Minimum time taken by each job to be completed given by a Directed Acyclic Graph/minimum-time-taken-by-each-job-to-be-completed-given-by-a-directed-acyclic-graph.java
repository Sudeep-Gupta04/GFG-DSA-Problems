//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 2);
            
            
            int[][] edges = IntMatrix.input(br, a[1], 2);
            
            Solution obj = new Solution();
            int [] res = obj.minimumTime(a[0],a[1], edges);
            for(int x: res)
                System.out.print(x+" ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int[] minimumTime(int n, int m, int[][] edges) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    int[] indegree = new int[n + 1]; // Adjusted for 1-based indexing
    Queue<Integer> q = new ArrayDeque<>();

    // Initialize adjacency list for 1-based indexing
    for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

    // Populate adjacency list and indegree array
    for (int i = 0; i < edges.length; i++) {
        adj.get(edges[i][0]).add(edges[i][1]); // Use 1-based indices
        indegree[edges[i][1]]++;
    }

    int[] ans = new int[n + 1]; // Adjusted for 1-based indexing
    int c = 1;

    // Add all nodes with indegree 0 to the queue
    for (int i = 1; i <= n; i++) {
        if (indegree[i] == 0) {
            q.add(i);
            ans[i] = c;
        }
    }
    c++;

    // Process nodes in topological order
   while (!q.isEmpty()) {
            int size = q.size();
            for(int i =0;i<size;i++){
                int temp = q.remove();
                for (int node : adj.get(temp)) {
                    indegree[node] -= 1;
                    if (indegree[node] == 0) {
                        q.add(node);
                        ans[node] = c;
                    }
                }
            }
            c++;
        }

    // Return the result excluding the dummy 0th index
    return Arrays.copyOfRange(ans, 1, n + 1);
}

}
        
