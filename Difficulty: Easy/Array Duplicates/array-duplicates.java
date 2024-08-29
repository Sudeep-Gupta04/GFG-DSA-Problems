//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.duplicates(arr);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends



class Solution {
     public static ArrayList<Integer> duplicates(int[] arr) {
        // code here
        Arrays.sort(arr);
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]) al.add(arr[i]);
        }
        al.add(-1);
        ArrayList<Integer> p = new ArrayList<>();
        for(int i =0;i<al.size()-1;i++){
            if(al.get(i)!=al.get(i+1)) p.add(al.get(i));
        }
        if(p.size()==0){
            p.add(-1);
            return p;
        }
        return p;
    }
}
