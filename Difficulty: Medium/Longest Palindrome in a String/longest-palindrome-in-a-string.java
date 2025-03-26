//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
       static String longestPalindrome(String s) {
        // code here
        int ans = 1;
        int sidx = 0;
        int edidx = 1;
        StringBuilder anss = new StringBuilder("");
        if(s.length()==0) return "" ;
        for(int i =0;i<s.length();i++){
            //odd
            int mid = i;
            int os = i-1;
            int oe  = i+1;
            while(os>=0 && oe<s.length() && s.charAt(os)==s.charAt(oe)){
                os--;oe++;
            }
            if(oe-os-1>ans){
                ans = oe-os-1;
                sidx = os+1; edidx = oe;
            }
           

            // even

            if(i!=s.length()-1){
                int es = i; int ee = i+1;
                while(es>=0 && ee<s.length() && s.charAt(ee)==s.charAt(es)){
                    es--;ee++;
                }
                if(ee-es-1>ans){
                    ans = ee-es-1;
                    sidx = es+1; edidx = ee;
                }
               
            }
        }
        return s.substring(sidx,edidx);
    }
}