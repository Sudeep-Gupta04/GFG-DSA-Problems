//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        Stack<Long> st = new Stack<>();
        for(int i =0;i<S.length();i++){
            if(S.charAt(i)=='*' || S.charAt(i)=='/' || S.charAt(i)=='+' || S.charAt(i)=='-'){
                char operator = S.charAt(i);
                Long top = st.pop();
                Long below = st.pop();
                if(operator=='+')  st.push(below + top);
                else if (operator=='-')  st.push(below - top);
                else if (operator=='*')  st.push(below * top);
                else  st.push(below / top);
            }else st.push((long) Integer.parseInt(S.charAt(i)+""));
        }
        return Math.toIntExact(st.peek());
    }
}