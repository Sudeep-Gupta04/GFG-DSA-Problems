//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().trim().split(" ");

            String ans = new Solution().printLargest(n, arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    String printLargest(int n, String[] arr) {
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o1o2 = o1 + o2;
                String o2o1 = o2 + o1;
                return o2o1.compareTo(o1o2);
            }
        });

        StringBuilder ans = new StringBuilder();
        for (String s : arr) {
            ans.append(s);
        }

        if (ans.charAt(0) == '0') {
            return "0";
        }

        return ans.toString();
    }
}

