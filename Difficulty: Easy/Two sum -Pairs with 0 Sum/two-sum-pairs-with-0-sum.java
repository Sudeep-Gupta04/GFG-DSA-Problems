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

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.getPairs(arr);
            if (res.size() == 0) {
                System.out.println();
            } else {
                IntMatrix.print(res);
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
   public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        int s = 0; int e = arr.length-1;
        while(s<e){
            if(arr[s]+arr[e]==0){
                if(s!=0 && e!=n-1 && arr[s]==arr[s-1] && arr[e]==arr[e+1]){
                    s++;e--;
                    continue;
                }
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(arr[s]);
                temp.add(arr[e]);
                al.add(temp);
                s++;e--;
            }else if(arr[s]+arr[e]>0){
                e--;
            }else s++;
        }
        Collections.sort(al, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.get(0)==o2.get(0)) return o1.get(1)-o2.get(1);
                return o1.get(0)-o2.get(0);
            }
        });
        return al;
    }
}
