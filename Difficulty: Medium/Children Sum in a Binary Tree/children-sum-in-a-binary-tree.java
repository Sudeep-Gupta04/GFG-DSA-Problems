/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

*/
class Solution {
    // Function to check whether all nodes of a tree have the value
    // equal to the sum of their child nodes.
    public static int isSumProperty(Node root) {
        // add your code here
        return (helper(root))?1:0;
    }

    public static boolean helper(Node root){
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        boolean ans = false;
        int left = 0 ; int right = 0;

        if(root.left!= null)  left = root.left.data;
        if(root.right!=null)  right = root.right.data;

        if(root.data==left+right) return (true && helper(root.left) && helper(root.right));
        else return false;
    }
}