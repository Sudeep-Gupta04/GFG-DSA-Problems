//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends





class Solution {
    public static String smallestNumber(int s, int d) {
        String ans ="";
        if(s > d*9 ) return "-1";
        else if (d==1 && s==1) {
            return s+"";
        } else {
           while (s>9){
               ans = 9 + ans;
               s = s-9;
               d--;
           }
           if(d==0) return ans;
           if(d==1) return s+ans;
           if(d==2) return 1+""+(s-1)+ans;
           else {
               String z = "";
               for(int i =1;i<d;i++){
                   if(i==d-1) z+=s-1;
                   else  z+=0;
               }
               return 1+z+ans;
           }
        }
    }
}
