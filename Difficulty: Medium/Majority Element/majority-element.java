//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int majorityElement(int arr[]) {
        if(arr.length==2){
            return arr[0]==arr[1]?arr[0]:-1;
        }
        Arrays.sort(arr);
        if(arr.length %2 !=0){
            int num = arr[arr.length/2];
            int c =0;
            for(int i =0;i<arr.length;i++){
                if(arr[i]==num)c++;
            }
            return c>(arr.length/2)?num:-1;
        }else{
            int num = arr[arr.length/2];
            int c =0;
            for(int i =0;i<arr.length;i++){
                if(arr[i]==num)c++;
            }
            return c>(arr.length/2)?num:-1;
        }
    }
}