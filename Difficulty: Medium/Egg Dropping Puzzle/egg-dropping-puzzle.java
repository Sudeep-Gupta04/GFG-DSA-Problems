//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends



class Solution 
{
    // Function to find minimum number of attempts needed in 
    // order to find the critical floor.
    public static int[][] initializeArrayint(int rows, int cols, int value) {
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(array[i], value);
        }
        return array;
    }
    
    static int eggDrop(int n, int k)
    {
        int[][] dp = initializeArrayint(n + 1, k + 1, -1);
        return eggDropUtil(n, k, dp);
    }

    private static int eggDropUtil(int n, int k, int[][] dp) {
        if (k == 0 || k == 1) return k;
        if (n == 1) return k;

        if (dp[n][k] != -1) return dp[n][k];

        int minAttempts = Integer.MAX_VALUE;

        int low = 1, high = k;
        while (low <= high) {
            int mid = (low + high) / 2;
            int breakCount = eggDropUtil(n - 1, mid - 1, dp); 
            int notBreakCount = eggDropUtil(n, k - mid, dp);  
            int worstCase = 1 + Math.max(breakCount, notBreakCount);

            minAttempts = Math.min(minAttempts, worstCase);

            if (breakCount > notBreakCount) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        dp[n][k] = minAttempts;
        return dp[n][k];
    }
}