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
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.findLeastGreater(n, arr);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends




class Solution {
    
    public static class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

    public static Node succ = null;
    
    public static ArrayList<Integer> findLeastGreater(int n, int[] arr){
       ArrayList<Integer> al = new ArrayList();
       al.add(-1);
       Node root =  new Node(arr[n-1]);
       for(int i = arr.length-2;i>=0;i--){
           insertElementInBST(root,arr[i]);
           if(succ==null) al.add(-1);
           else {
               al.add(succ.data);
               succ=null;
           }
       }
     Collections.reverse(al);
        return al;
}

    private static Node insertElementInBST(Node node, int i) {
        if(node==null){
            Node element = new Node(i);
            return element;
        }
        if(i < node.data)  {
            succ = node;
            node.left = insertElementInBST(node.left,i);
            return node;

        }
        else {
            node.right = insertElementInBST(node.right,i);
            return node;
        }
    }
}
        
