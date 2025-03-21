//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            
            System.out.println(new Solution().findNum(n));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findNum(int n)
    {
        int c = 0;
        for(int i=1;i<100000;i++){
            int num = i;
            while(num/5!=0){
                if(num%5!=0) break;
                else{
                   // System.out.println(i);
                    c++;
                    if(c==n) return i;
                    num/=5;
                }
            }
            if(c==n) return i;
        }
        return -1;
    }
}