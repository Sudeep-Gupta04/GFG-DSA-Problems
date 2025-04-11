//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
        	String [] str = br.readLine().trim().split(" ");
        	int n = Integer.parseInt(str[0]);
        	int m = Integer.parseInt(str[1]);
        	ArrayList<ArrayList<Integer>> trains = new ArrayList<>();
        	for(int i = 0; i < m; i++) {
        		str = br.readLine().trim().split(" ");
        		ArrayList<Integer> arr = new ArrayList<>();
        		for(int j = 0; j < 3; j++)
        			arr.add(Integer.parseInt(str[j]));
        		trains.add(arr);
        	}
        	Solution obj = new Solution();
        	int res = obj.maxStop(n, m, trains);
        	System.out.println(res);
        }
    }
}

// } Driver Code Ends


//User function Template for Java





class Solution {
    int maxStop(int n, int m, ArrayList<ArrayList<Integer>> trains) {
        ArrayList<ArrayList<Point>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) al.add(new ArrayList<>());

        for (ArrayList<Integer> i : trains) {
            al.get(i.get(2) - 1).add(new Point(i.get(0), i.get(1)));
        }

        int ans = 0;

        for (ArrayList<Point> platform : al) {
            Collections.sort(platform, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    return o1.y - o2.y;
                }
            });

            int count = 0;
            int lastDeparture = -1;

            for (Point train : platform) {
                if (train.x >= lastDeparture) {
                    count++;
                    lastDeparture = train.y;
                }
            }

            ans += count;
        }

        return ans;
    }
}

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

