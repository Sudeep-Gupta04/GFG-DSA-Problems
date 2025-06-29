class Solution {
    // Return True if the given trees are isomotphic. Else return False.
    boolean isIsomorphic(Node root1, Node root2) {
        // code here.
        return helper(root1,root2);
    }
    public static boolean helper(Node a, Node b){
        if((a==null  && b!=null) || (a!=null  && b==null)) return false;
        if(a==null && b==null) return true;
        
        return ((a.data==b.data) && ((helper(a.right,b.left) && helper(a.left,b.right)) || (helper(a.right,b.right) && helper(a.left,b.left))));
    }
}