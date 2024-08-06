//{ Driver Code Starts
import java.io.*; 
import java.util.*; 
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException  
    {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//testcases
		int t = Integer.parseInt(br.readLine().trim());
		
		while(t-- > 0)
		{
		    String inputLine[] = br.readLine().trim().split(" ");
		    //size of array
		    int n = Integer.parseInt(inputLine[0]);
		    int start[] = new int[n];
		    int end[] = new int[n];
		    
		    //adding elements to arrays start and end
		    inputLine = br.readLine().trim().split(" ");
		    for(int i = 0; i < n; i++)
		     start[i] = Integer.parseInt(inputLine[i]);
		    
		    inputLine = br.readLine().trim().split(" ");
		    for(int i= 0; i < n; i++)
		      end[i] = Integer.parseInt(inputLine[i]);
		    
		    //function call
		    System.out.println(new Solution().activitySelection(start, end, n));
		}
    }
}


// } Driver Code Ends




class Solution
{
    class Pair implements Comparable<Pair>{
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.end==o.end) return this.start-o.start;
            return this.end - o.end;
        }
    }
    public int activitySelection(int start[], int end[], int n)
    {
        Pair[] p = new Pair[n];
        for (int i =0;i<n;i++){
            p[i] = new Pair(start[i],end[i]);
        }
        Arrays.sort(p);
        int count=1;
        int e = p[0].end;
        for(int i =1;i<n;i++){
            if(p[i].start>e){
                count++;
                e = p[i].end;
            }
        }
        return count;
    }
}