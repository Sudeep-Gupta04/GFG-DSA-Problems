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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {   
        int color = newColor;
        if (image[sr][sc] == color) return image;

        fill(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    void fill(int[][] image, int r, int c, int color, int orig_color) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != orig_color) return;
        
        image[r][c] = color;
        
        fill(image, r - 1, c, color, orig_color);
        fill(image, r + 1, c, color, orig_color);
        fill(image, r, c - 1, color, orig_color);
        fill(image, r, c + 1, color, orig_color);
    }
}