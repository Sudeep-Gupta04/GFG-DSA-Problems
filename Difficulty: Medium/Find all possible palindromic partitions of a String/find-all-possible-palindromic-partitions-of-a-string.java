//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);
            
            for (int i=0; i<allPart.size(); i++)  
            { 
                for (int j=0; j<allPart.get(i).size(); j++) 
                { 
                    System.out.print(allPart.get(i).get(j) + " "); 
                } 
                System.out.println(); 
            } 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
     public ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        ArrayList<ArrayList<String>> al = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        helper2(al,S,temp);
        return al;
    }

    private void helper2(ArrayList<ArrayList<String>> al, String s, ArrayList<String> temp) {
        if(s.length()==0){
            al.add(new ArrayList<>(temp));
            return;
        }
        for(int i =0;i<s.length();i++){
            int start = 0;
            int end = i;
            if(isPalindrom(s.substring(start,end+1))){
                temp.add(s.substring(start,end+1));
                helper2(al,s.substring(end+1),temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrom(String s) {
        StringBuilder S = new StringBuilder(s);
        return S.toString().equals(S.reverse().toString()); // Correct palindrome check
    }
};