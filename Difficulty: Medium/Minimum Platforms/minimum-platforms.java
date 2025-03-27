//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input (arr)
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] =
                    Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input (dep)
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] dep = new int[m];
            for (int i = 0; i < m; i++) {
                dep[i] =
                    Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            System.out.println(obj.findPlatform(arr, dep));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java



class Solution {
    static class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p) {
            if (this.x != p.x) {
                return this.x - p.x; // Sort by arrival time
            }
            return this.y - p.y; // If arrival time is same, sort by departure
        }
    }

    // Function to find the minimum number of platforms required at the railway station
    static int findPlatform(int arr[], int dep[]) {
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 

        Point[] train = new Point[n];
        for (int i = 0; i < n; i++) {
            train[i] = new Point(arr[i], dep[i]);
        }

        Arrays.sort(train); 

        pq.add(train[0].y);
        int maxPlatforms = 1;

        for (int i = 1; i < n; i++) {
          
            while (!pq.isEmpty() && pq.peek() < train[i].x) {
                pq.poll();
            }

            pq.add(train[i].y); 
            maxPlatforms = Math.max(maxPlatforms, pq.size());
        }

        return maxPlatforms;
    }

  
}
