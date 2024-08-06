//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				String str = br.readLine();
				Solution ob= new Solution();
				String str1 = ob. rearrangeCharacters(str);
				
        		int flag=1;
        	    int[] c = new int[26];
        	    Arrays.fill(c,0);
        	    for(int i=0; i<str.length(); i++)
        	        c[str.charAt(i)-'a']+=1;
        	    int f = 0;
        	    int x = (str.length()+1)/2;
        	    for(int i=0; i<26; i++)
        	    {
        	        if(c[i]>x)
        	            f = 1;
        	    }
        	    if(f == 1)
        	    {
        	        if(str1=="-1")
        	            System.out.println(0);
            	    else
            	        System.out.println(1);
        	    }
        	    else
        	    {
            	    int[] a = new int[26];
        	        Arrays.fill(a,0);
            	    int[] b = new int[26];
        	        Arrays.fill(b,0);
            	    for(int i=0; i<str.length(); i++)
            	        a[str.charAt(i)-'a']+=1;
            	    for(int i=0; i<str1.length(); i++)
            	        b[str1.charAt(i)-'a']+=1;
            	        
            	    for(int i=0; i<26; i++)
            	        if(a[i]!=b[i])
            	            flag = 0;
            	    
            	    for(int i=0;i<str1.length();i++)
            	    {
            		    if(i>0)
            		        if(str1.charAt(i-1)==str1.charAt(i))
            			        flag=0;
            	    }
            	    if(flag==1)
            		    System.out.println(1);
            	    else
            	        System.out.println(0);
        	    }
			}
		} catch (Exception e) {

		}
	}
}
// } Driver Code Ends




class Solution
{
	public static class Pairs implements Comparable<Pairs> {
        int value;
        char ch;

        Pairs(int value, char ch) {
            this.value = value;
            this.ch = ch;
        }

        @Override
        public int compareTo(Pairs other) {
            return Integer.compare(other.value, this.value); 
        }
    }

    public static String rearrangeCharacters(String str) {
        
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        
        PriorityQueue<Pairs> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            pq.add(new Pairs(entry.getValue(), entry.getKey()));
        }
        int n = str.length();
        StringBuilder ans = new StringBuilder();
        if (pq.peek().value > (str.length() + 1) / 2) return "-1";
        Pairs prev = new Pairs(0, '#'); 
        
        while (!pq.isEmpty()) {
            Pairs current = pq.poll();
            ans.append(current.ch);

            
            if (prev.value > 0) {
                pq.add(prev);
            }

           
            current.value--;
            prev = current;
        }
       // if(prev.value>0) return "-1";
        return ans.toString();
    }
}