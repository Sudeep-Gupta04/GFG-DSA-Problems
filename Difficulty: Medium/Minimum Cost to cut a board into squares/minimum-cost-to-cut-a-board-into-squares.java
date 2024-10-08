//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        Scanner sc=new Scanner(System.in);
        t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            String P[]=br.readLine().trim().split(" ");
            int m=Integer.parseInt(P[0])-1;
            int n=Integer.parseInt(P[1])-1;
            String A[]=br.readLine().trim().split(" ");
            String B[]=br.readLine().trim().split(" ");
            ArrayList<Integer> l=new ArrayList<>();
            for(String s : A){
                if(s.equals(""))
                continue;
                l.add(Integer.parseInt(s));
            }
            for(String s : B){
                if(s.equals(""))
                continue;
                l.add(Integer.parseInt(s));
            }
            int [] X =new int[m];
            int [] Y=new int[n];
            int ind=0;
            for(int i=0;i<m;i++){
                X[i]=l.get(ind++);
            }
            for(int i=0;i<n;i++){
                Y[i]=l.get(ind++);
            }
            
            Solution obj = new Solution();
            int res = obj.minimumCostOfBreaking(X, Y,m,n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends




class Solution {
     
    public static int minimumCostOfBreaking(int[] X, int[] Y, int M, int N) {

        M = M - 1;
        N = N - 1;

        
        Integer[] XInteger = Arrays.stream(X).boxed().toArray(Integer[]::new);
        Arrays.sort(XInteger, Collections.reverseOrder());

        Integer[] YInteger = Arrays.stream(Y).boxed().toArray(Integer[]::new);
        Arrays.sort(YInteger, Collections.reverseOrder());

        int hc = 1; 
        int vc = 1; 
        int i = 0, j = 0;
        int ans = 0;

       
        while (i < YInteger.length && j < XInteger.length) {
            if (YInteger[i] >= XInteger[j]) {
                ans += YInteger[i] * vc;
                i++;
                hc++;
            } else {
                ans += XInteger[j] * hc;
                j++;
                vc++;
            }
        }

        while (i < YInteger.length) {
            ans += YInteger[i] * vc;
            i++;
        }

        while (j < XInteger.length) {
            ans += XInteger[j] * hc;
            j++;
        }

        return ans;
    }
}
        
