//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class GFG {
    ArrayList<Integer> find(int arr[], int x) {
        ArrayList<Integer> al = new ArrayList<>();
        int s = 0;
        int e = arr.length-1;
        int f = 0;
        while(s<=e){
            int mid = s + ((e-s)/2);
            if(arr[mid]>x) e = mid - 1;
            else if(arr[mid]==x){
                f=1;
                e = mid -1;
            }else{
                s = mid + 1;
            }
        }
        if(f!=1) {
            al.add(-1);al.add(-1);
            return al;
        }
        al.add(s);
        s = 0;e = arr.length-1;
        while(s<=e){
            int mid = s + ((e-s)/2);
            if(arr[mid]<x){
                s = mid  + 1;
            }
            else if(arr[mid]==x){
                s = mid +1;
            }
            else{
                e = mid - 1;
            }
        }
        al.add(e);
        return al;
    }    
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {

            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            int x = Integer.parseInt(br.readLine());
            GFG ob = new GFG();
            ArrayList<Integer> ans = ob.find(arr, x);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends