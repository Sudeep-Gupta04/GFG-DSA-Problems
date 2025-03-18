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

            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int x;
            x = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            boolean res = obj.findPair(arr, x);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public boolean findPair(int[] arr, int x) {
        // code here
        HashSet<Integer> hm = new HashSet<>();
        for(int i =0;i<arr.length;i++){
            if(arr[i]>=x){
              if(hm.contains(arr[i]-x) || hm.contains(arr[i]+x) ) return true;  
            }else{
               if(hm.contains(arr[i]-x) || hm.contains(arr[i]+x) ) return true;  
            }
            hm.add(arr[i]);
        }
        return false;
    }
}
