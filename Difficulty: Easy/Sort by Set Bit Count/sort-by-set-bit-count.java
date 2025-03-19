//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Integer arr[] = new Integer[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            obj.sortBySetBitCount(arr, n);
            StringBuilder output = new StringBuilder();
            for(int i = 0; i < n; i++)
            output.append(arr[i] + " ");
            System.out.println(output);
            
        
System.out.println("~");
}
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute  
{ 
    static void sortBySetBitCount(Integer arr[], int n)
    {
        TreeMap<Integer,List<Integer>> tm = new TreeMap<>();
        for(int i =0;i<arr.length;i++){
            int num = arr[i];
            int c = Integer.bitCount(num);
            if(!tm.containsKey(c)){
                List<Integer> al = new ArrayList<>();
                al.add(num);
                tm.put(c,al);
            }else{
                 List<Integer> al = tm.get(c);
                 al.add(num);
                 tm.put(c,al);
            }
        }
        //System.out.println(tm);
        int k = arr.length-1;
        for(Map.Entry<Integer, List<Integer>> i:tm.entrySet()){
            for(int j = i.getValue().size()-1;j>=0;j--){
                arr[k--] = i.getValue().get(j);
            }
        }
        return;
    }
}
