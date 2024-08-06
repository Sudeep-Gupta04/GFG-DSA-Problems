//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends




class Solution
{ 
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        ArrayList<Integer> al = new ArrayList<>();
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i =0;i<k;i++){
            if(!mp.containsKey(A[i])){
                mp.put(A[i],1);
            }else {
                mp.put(A[i], mp.get(A[i])+1);
            }
        }
        al.add(mp.size());
        for(int i =k;i<A.length;i++){
            if(!mp.containsKey(A[i])){
                mp.put(A[i],1);
            }
            else {
                mp.put(A[i], mp.get(A[i])+1);
            }
            if(mp.get(A[i-k])>1){
                mp.put(A[i-k],mp.get(A[i-k])-1);
            }else {
               mp.remove(A[i-k]); 
            }
            al.add(mp.size());
        }
        return al;
    }
}

