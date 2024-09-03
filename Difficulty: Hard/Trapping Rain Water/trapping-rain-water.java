//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends

class Solution {

    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) {
        int i = 0, left_max = arr[0];
        long sum = 0;
        int j = n - 1, right_max = arr[j];
        
        while (i < j) {
            if (left_max <= right_max) {
                sum += (left_max - arr[i]);
                i++;
                left_max = Math.max(left_max, arr[i]);
            } else {
                sum += (right_max - arr[j]);
                j--;
                right_max = Math.max(right_max, arr[j]);
            }
        }
        return sum;
    }
}



