//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Tree g = new Tree();
                float answer = g.findMedian(root);
                if(answer-(int)answer == 0)
        		    System.out.println((int)answer);
        		else
        		    System.out.println(answer);
                t--;
            
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Tree
{   
    public static void countNodes(Node root, int[] len) {
        if(root == null) return;
        
        countNodes(root.left, len);
        len[0] += 1;
        countNodes(root.right, len);
    }
    
    public static void helper(Node root, int mid, int[] count, int[] prev, int[] first, int[] sec) {
        if(root == null) return;
        
        helper(root.left, mid, count, prev, first, sec);
        count[0] += 1;
        if(mid == count[0]) {
            count[0] = mid+1;
            first[0] = root.data;
            sec[0] = prev[0];
            return;
        }
        prev[0] = root.data;
        
        helper(root.right, mid, count, prev, first, sec);
    }
    
    public static float findMedian(Node root) {
        int[] len = {0};
        countNodes(root, len);
        
        int mid = len[0]/2 + 1;
        int[] count = {0};
        int[] prev = {0};
        int[] first = {0};
        int[] sec = {0};
        helper(root, mid, count, prev, first, sec);
        
        float res = first[0];
        if(len[0]%2 == 0) {
            res =(float) (first[0]+sec[0]) / 2;
        }
        
        return res;
    }
}