//{ Driver Code Starts
//Initial Template for Java

import java.math.*;
import java.util.*;
import java.io.*;

class Driverclass
{
    // Driver Code
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }
        
        Long nextLong(){
            return Long.parseLong(next());
        }
    }
    
	public static void main(String args[])
	{
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		
		while(t>0)
		{
			int n = sc.nextInt();
			long arr[] = new long[n];
			
			for(int i=0; i<n; i++)
				arr[i] = sc.nextLong();
		    out.println(new Solution().minCost(arr, n));
		    t--;
		}
		out.flush();
	}
}
// } Driver Code Ends




class Solution
{
     long minCost(long arr[], int n)
    {   PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i =0;i<arr.length;i++){
        pq.add(arr[i]);
        }
        long ans = 0;
        if(pq.size()==1) return 0;
        while (pq.size()!=1){
            long top = pq.remove();
            long second = pq.remove();
            ans += top+second;
            pq.add(top+second);
        }
        return ans;
    }
}