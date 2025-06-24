/*

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

*/

class Solution {
    // Return the root of the modified tree after removing all the half nodes.
    public Node RemoveHalfNodes(Node root) {
        // Code Here
        return helper(root);
    }
    
    public Node helper(Node root){
        if(root==null) return null;
        
        root.left = helper(root.left);
        root.right = helper(root.right);
        
        if(root.left==null && root.right!=null) return root.right;
        
        else if(root.left!=null && root.right==null) return root.left;
        
        else{
            return root;
        }
    }
}