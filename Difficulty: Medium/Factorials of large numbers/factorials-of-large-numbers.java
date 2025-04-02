//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class Solution {
 public static ArrayList<Integer> factorial(int n) {
        ArrayList<Integer> sum = new ArrayList<>();
        sum.add(1);

        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> brr = new ArrayList<>();
            int num = i;
            while (num != 0) {
                brr.add(0, num % 10);
                num /= 10;
            }
            sum = multiply(sum, brr);
        }
        ArrayList<Integer> al = new ArrayList<>();
        int c = 0;
        for(int i:sum){
            if(i==0 && c==0){}
            else {
                c=1;
                al.add(i);
            }
        }
        return al;
    }

    public static ArrayList<Integer> multiply(List<Integer> arr, List<Integer> brr) {
        ArrayList<Integer> sum = new ArrayList<>(Collections.nCopies(arr.size() + brr.size(), 0));
        int n = brr.size() - 1;

        for (int i = n; i >= 0; i--) {
            List<Integer> temp = product_of_element(arr, brr.get(i));

            for (int j = 0; j < n - i; j++) {
                temp.add(0);
            }

            sum = addNumbers(sum, temp);
        }
        return sum;
    }

    public static List<Integer> product_of_element(List<Integer> arr, int ele) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;

        for (int i = arr.size() - 1; i >= 0; i--) {
            int p = (arr.get(i) * ele) + carry;
            result.add(0, p % 10);
            carry = p / 10;
        }

        while (carry != 0) {
            result.add(0, carry % 10);
            carry /= 10;
        }

        return result;
    }

    public static ArrayList<Integer> addNumbers(List<Integer> sum, List<Integer> list) {
        ArrayList<Integer> ans = new ArrayList<>();
        int carry = 0;
        int i = sum.size() - 1, j = list.size() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sVal = (i >= 0) ? sum.get(i--) : 0;
            int lVal = (j >= 0) ? list.get(j--) : 0;

            int total = sVal + lVal + carry;
            ans.add(0, total % 10);
            carry = total / 10;
        }

        return ans;
    }
}


//{ Driver Code Starts.

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends