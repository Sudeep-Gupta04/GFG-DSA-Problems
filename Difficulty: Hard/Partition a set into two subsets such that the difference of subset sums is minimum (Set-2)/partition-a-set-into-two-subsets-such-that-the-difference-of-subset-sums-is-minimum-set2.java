//{ Driver Code Starts
                               import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        int S1=0, S2=0, k=0;
        for(var a : m)
        {
            k++;
            for(int e : a){
                if(k==1) S1+=e;
                else S2+=e;
            }
        }
        
        if(S1 < S2){
            System.out.println(S1);
            System.out.println(S2);
        }
        else{
            System.out.println(S2);
            System.out.println(S1);
        }
    }
    
    
    
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.minDifference(n, arr);
            
            IntMatrix.print(res);
            
        }
    }
}

                               
// } Driver Code Ends


   // ES
 class Solution {
    private int ans = Integer.MAX_VALUE;
    private ArrayList<Integer> l = new ArrayList<>();
    private ArrayList<Integer> r = new ArrayList<>();

    private void helper(ArrayList<Integer> arr, int index, int leftSum, int rightSum, ArrayList<Integer> left, ArrayList<Integer> right, int n) {
        if (index == n) {
            int k = (n + 1) / 2;
            if (left.size() <= k && right.size() <= k) {
                int difference = Math.abs(leftSum - rightSum);
                if (difference < ans) {
                    ans = difference;
                    l = new ArrayList<>(left);
                    r = new ArrayList<>(right);
                }
            }
            return;
        }

        // Add current element to the left subset and recurse
        left.add(arr.get(index));
        helper(arr, index + 1, leftSum + arr.get(index), rightSum, left, right, n);
        left.remove(left.size() - 1);

        // Add current element to the right subset and recurse
        right.add(arr.get(index));
        helper(arr, index + 1, leftSum, rightSum + arr.get(index), left, right, n);
        right.remove(right.size() - 1);
    }

    public ArrayList<ArrayList<Integer>> minDifference(int n, int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num : arr) {
            arrayList.add(num);
        }

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        helper(arrayList, 0, 0, 0, left, right, n);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(l);
        result.add(r);

        return result;
    }
}
