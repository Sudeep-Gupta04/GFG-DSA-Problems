//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends



class Solution {
    // Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int arr[]) {
        int[] brr = Arrays.copyOf(arr,arr.length);
        Arrays.sort(brr);

        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i =0;i<arr.length;i++){
            hm.put(arr[i],i);
        }
        int c =0;
        int k = 0;
        while(k<arr.length){
            if(arr[k]==brr[k]) k++;
            else{
                c++;
                int idx = hm.get(brr[k]);
                int temp = arr[k];
                arr[k] = arr[idx];
                arr[idx] = temp;

                hm.put(arr[k],k);
                hm.put(arr[idx],idx);
            }
        }
        return c;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
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
            int ans = obj.minSwaps(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends