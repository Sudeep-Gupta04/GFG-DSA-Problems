//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private static int findTarget(int l, int r, int target, int[] nums) {
        int ans = r;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    static List<Integer> nextPermutation(int N, int arr[]) {
        int idx = -1;

        // Step 1: Find the first decreasing element from the end
        for (int i = N - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                idx = i;
                break;
            }
        }

        // Step 2: If no such element is found, the array is in descending order
        if (idx == -1) {
            Arrays.sort(arr);
            return convertArrayToList(arr);
        }

        // Step 3: Find the smallest element greater than arr[idx-1] to the right of idx
        int swapIndex = findTarget(idx, N - 1, arr[idx - 1], arr);

        // Step 4: Swap the elements at idx-1 and swapIndex
        int temp = arr[idx - 1];
        arr[idx - 1] = arr[swapIndex];
        arr[swapIndex] = temp;

        // Step 5: Sort the subarray from idx to the end of the array
        Arrays.sort(arr, idx, N);

        return convertArrayToList(arr);
    }

    private static List<Integer> convertArrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }
}
