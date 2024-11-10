//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

        int countDistinctIslands(int[][] grid) {
        // Your Code here
        HashSet<ArrayList<String>> al = new HashSet<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    Point base = new Point(i,j);
                    ArrayList<String> temp = new ArrayList<>();
                    Traverse(i,j,grid,vis,base,temp);
                    al.add(temp);
                }
            }
        }
        return al.size();
    }
    
    String toString(int a, int b){
        return Integer.toString(a)+" "+Integer.toString(b);
    }
    
    private void Traverse(int i, int j,int[][] grid, boolean[][] vis, Point base,ArrayList<String> al) {
        vis[i][j] = true;
        al.add(toString(i-base.x,j- base.y));
      //  al.add((Math.abs(i-base.x)+""+Math.abs(j- base.y)+""));
        int [] row = {-1,0,1,0};
        int [] col = {0,1,0,-1};
        for(int k =0;k<row.length;k++){
            int x = i+row[k];
            int y = j+col[k];
            if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]==1 && !vis[x][y]){
                Traverse(x,y,grid,vis,base,al);
            }
        }
    }
    
    class Point {
    public int x; // x-coordinate
    public int y; // y-coordinate

    // Constructor for Point
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Override equals to compare Point objects based on edge values
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return (x == point.x && y == point.y) || (x == point.y && y == point.x); // Compare edges in both directions
    }

    // Override hashCode to ensure consistent hashing based on sorted x, y values
    @Override
    public int hashCode() {
        return Objects.hash(Math.min(x, y), Math.max(x, y));
    }

    // Override toString for easy printing of Point instances
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}


}
