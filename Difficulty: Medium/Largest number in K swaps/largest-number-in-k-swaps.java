//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int k = sc.nextInt();
                    String str = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.findMaximumNum(str, k));
                }
        }
}
// } Driver Code Ends




class Solution
{
    //Function to find the largest number after k swaps.
    static String result;
    static String sorted;

    // Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        sorted = new StringBuilder(new String(charArray)).reverse().toString();
        if (k > str.length() - 1) {
            return sorted;
        }

        result = str;
        helper(k, str, 0);
        return result;
    }

    public static String swapCharacters(String str, int index1, int index2) {
        char[] charArray = str.toCharArray();
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
        return new String(charArray);
    }

    private static void helper(int k, String str, int start) {
        if (str.compareTo(sorted)==0){
            result = sorted;
            k=0;
            return;
        }
        if (k == 0) {
            if (str.compareTo(result) > 0) {
                result = str;
            }
            return;
        }

        for (int i = start; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) > str.charAt(i)) {
                    String swapped = swapCharacters(str, i, j);
                    helper(k - 1, swapped, i);
                }
            }
        }
    }
}