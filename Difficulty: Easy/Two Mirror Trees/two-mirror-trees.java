// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

class Solution {
    boolean areMirror(Node a, Node b) {
        // Your code here
        return helper(a,b);
    }
    public static boolean helper(Node a, Node b){
        if((a==null  && b!=null) || (a!=null  && b==null)) return false;
        if(a==null && b==null) return true;
        
        return ((a.data==b.data) && helper(a.right,b.left) && helper(a.left,b.right));
    }
}