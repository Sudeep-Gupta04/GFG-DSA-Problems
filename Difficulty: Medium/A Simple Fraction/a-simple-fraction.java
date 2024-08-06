//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int numerator = Integer.parseInt(S[0]);
            int denominator = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            String ans = ob.fractionToDecimal(numerator, denominator);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    public String  fractionToDecimal(int numerator, int denominator)
    {
        // code here
        HashMap<Integer,Integer> mp = new HashMap<>();
        String ans = numerator / denominator + ".";
        int remainder = numerator % denominator;
        if(remainder==0){
            return numerator / denominator +"";
        }
        int k=1;
        int inxRepeat = 0;
        boolean repeat = false;
        while (remainder!=0){
            
            if(mp.containsKey(remainder)){
                repeat = true;
                inxRepeat = mp.get(remainder);
                break;
            }
            
            mp.put(remainder,k);
            k++;
            remainder = remainder*10;
            ans += remainder/denominator;
            remainder = remainder%denominator;
        }
        if(repeat){
           int idxDecimal = ans.indexOf('.');
           ans = ans.substring(0,idxDecimal+inxRepeat) + '(' + ans.substring(idxDecimal+inxRepeat) + ')';
        }
        return ans;
    }
}