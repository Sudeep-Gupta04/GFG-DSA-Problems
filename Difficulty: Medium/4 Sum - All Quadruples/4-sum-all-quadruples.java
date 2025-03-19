//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            // String[] nk = br.readLine().trim().split(" ");
            // int n = Integer.parseInt(nk[0]);
            // int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int target = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            List<List<Integer>> ans = ans = sln.fourSum(a, target);
            Collections.sort(ans, (list1, list2) -> {
                for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
                    int cmp = list1.get(i).compareTo(list2.get(i));
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                return 0;
            });
            for (List<Integer> v : ans) {
                for (int x : v) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            if (ans.isEmpty()) {
                System.out.println(-1);
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// target : the quadruple sum required

class Solution {
     public List<List<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);  // Sort the array
        List<List<Integer>> al = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue; // Skip duplicates

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue; // Skip duplicates

                int left = j + 1, right = n - 1;
                long newTarget = (long) target - arr[i] - arr[j]; // Use long to prevent overflow

                while (left < right) {
                    long sum = (long) arr[left] + arr[right]; // Use long here

                    if (sum == newTarget) {
                        al.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));

                        while (left < right && arr[left] == arr[left + 1]) left++;
                        while (left < right && arr[right] == arr[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < newTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return al;
    }
}