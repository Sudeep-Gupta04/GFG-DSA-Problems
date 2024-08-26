//{ Driver Code Starts
import java.util.*;

class Partition_Arr_To_K_Subsets
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			int k = sc.nextInt();
			Solution g = new Solution();
			if(g.isKPartitionPossible(a,n,k)==true)
				System.out.println(1);
			else 
				System.out.println(0);
			
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method */

class Solution {
    public boolean isKPartitionPossible(int[] a, int n, int k) {
        int total = 0;
        for (int num : a) {
            total += num;
        }
        if (total % k != 0) {
            return false;
        }

        int targetBucketSum = total / k;
        boolean[] visited = new boolean[n];
        return canPartition(a, visited, 0, k, 0, targetBucketSum);
    }

    private boolean canPartition(int[] a, boolean[] visited, int start, int k, int bucketSum, int targetBucketSum) {
        if (k == 0) {
            return true;
        }
        if (bucketSum == targetBucketSum) {
            return canPartition(a, visited, 0, k - 1, 0, targetBucketSum);
        }
        for (int i = start; i < a.length; i++) {
            if (visited[i] || bucketSum + a[i] > targetBucketSum) {
                continue;
            }
            visited[i] = true;
            if (canPartition(a, visited, i + 1, k, bucketSum + a[i], targetBucketSum)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}
