//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            Solution ob = new Solution();
            
            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
    			out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 out.print(" ");
    				}
    				out.print(")");
    			}
    		}
    		out.println();
    		res.clear();
	    }
	    out.flush();
    }
    
}
// } Driver Code Ends


//User function template for JAVA


class Solution {
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        ArrayList<Integer> seq = new ArrayList<>();
        
        Collections.sort(A);
        ArrayList<Integer> uniqueCandidates = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (i == 0 || !A.get(i).equals(A.get(i - 1))) {
                uniqueCandidates.add(A.get(i));
            }
        }

        helper(0, uniqueCandidates, B, l, seq);

        Collections.sort(l, (a, b) -> {
            int i = 0;
            while (i < a.size() && i < b.size()) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
                i++;
            }
            return a.size() - b.size();
        });

        return l;
    }

    private static void helper(int idx, ArrayList<Integer> candidates, int target, ArrayList<ArrayList<Integer>> l, ArrayList<Integer> seq) {
        if (target == 0) {
            ArrayList<Integer> sortedSeq = new ArrayList<>(seq);
            Collections.sort(sortedSeq);
            l.add(sortedSeq);
            return;
        }

        if (target < 0) {
            return;
        }

        for (int q = idx; q < candidates.size(); q++) {
            seq.add(candidates.get(q));
            helper(q, candidates, target - candidates.get(q), l, seq);
            seq.remove(seq.size() - 1);
        }
    }
}
