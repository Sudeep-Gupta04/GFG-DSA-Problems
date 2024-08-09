//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SpeStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Stack<Integer> s=new Stack<>();
			GfG g=new GfG();
			while(!g.isEmpty(s)){
			    g.pop(s);
			}
			while(!g.isFull(s,n)){
				g.push(sc.nextInt(),s);
			}
		System.out.println(g.min(s));
		}
	}
}
// } Driver Code Ends


/*Complete the function(s) below*/
class GfG{
    int count =0;
	public void push(int a,Stack<Integer> s)
	{   
	    count++;
	    s.push(a);
	}
	public int pop(Stack<Integer> s)
        {
            count--;
            return s.pop();
            
	}
	public int min(Stack<Integer> s)
        {   
           int min =1000007;
           Stack<Integer> st = new Stack<>();
           while(!s.isEmpty()){
               int num = s.pop();
               if(num<=min) min = num;
               st.push(num);
           }
           while(!st.isEmpty()){
               s.push(st.pop());
           }
           return min;
            
	}
	public boolean isFull(Stack<Integer>s, int n)
        {
           if(count==n) return true;
           else{
               return false;
           }
    
	}
	public boolean isEmpty(Stack<Integer>s)
        {
           if(count==0) return true;
           else{
               return false;
           }
	}
}