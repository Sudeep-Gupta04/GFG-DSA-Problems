//{ Driver Code Starts
import java.util.*;
import java.lang.Math;
class Pots{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
			int n = sc.nextInt();
			int[] a =new  int[n];
			for(int i=0;i<n;i++)
			{
				a[i] = sc.nextInt();
			}
			GfG g = new GfG();
			System.out.println(g.maxCoins(a,n));
			
		}
	}
}
// } Driver Code Ends




/*Complete the function below*/


class GfG {
    static int dp[][];
    
    public static int maxCoins(int A[], int n) {
        dp = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return getMaxGold(A, 0, n-1, true);
    }
    
    static int getMaxGold(int A[], int left, int right, boolean xTurn) {
        if (left == right) {
            return xTurn ? A[left] : 0;
        }
        
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        
        if (xTurn) {
            int m = A[left] + getMaxGold(A, left + 1, right, !xTurn);
            int n = A[right] + getMaxGold(A, left, right - 1, !xTurn);
            dp[left][right] = Math.max(m, n);
            return dp[left][right];
        } else {
            return Math.min(
                getMaxGold(A, left + 1, right, !xTurn),
                getMaxGold(A, left, right - 1, !xTurn)
            );
        }
    }
}
