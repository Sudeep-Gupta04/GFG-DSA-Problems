/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)
   {
        data = item;
        left = right = null;
    }
} */

class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
        helper(node);
    }
    
    public static Node helper(Node root){
        if(root==null) return null;
        
        
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        helper(root.left);
        helper(root.right);
        
        return root;
    }
    
}