//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            
            int gallery[] = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(s[i]);
            Solution T = new Solution();
            out.println(T.min_sprinklers(gallery,n));
        
out.println("~");
}
		out.close();
		
	}
}





// } Driver Code Ends


// User function Template for Java

class Solution {
    public class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    int min_sprinklers(int gallery[], int n) {
        ArrayList<Point> arr = new ArrayList<>();

        // Create intervals from sprinklers
        for (int i = 0; i < n; i++) {
            if (gallery[i] == -1) continue;
            int left = Math.max(0, i - gallery[i]);
            int right = Math.min(n - 1, i + gallery[i]);
            arr.add(new Point(left, right));
        }

        // Sort by starting point
        Collections.sort(arr, (a, b) -> {
            if (a.x == b.x) return b.y - a.y; 
            return a.x - b.x;
        });

        int count = 0;
        int coveredTill = 0;
        int i = 0;

        while (coveredTill < n) {
            int farthest = -1;

            while (i < arr.size() && arr.get(i).x <= coveredTill) {
                farthest = Math.max(farthest, arr.get(i).y);
                i++;
            }

            if (farthest < coveredTill) return -1; 

            count++;
            coveredTill = farthest + 1;
        }

        return count;
    }
}

