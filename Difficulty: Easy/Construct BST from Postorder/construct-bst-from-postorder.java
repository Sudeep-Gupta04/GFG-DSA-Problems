/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

// Function should return the root of the bst formed using postorder traversal.
class GFG {
    static int i;
    public static Node constructTree(int post[], int n) {
        i = n-1;
        // Add your code here.
        return helper(post,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public static Node helper(int[] post,int min, int max){
        if(i<0) return null;
        int val = post[i];
        if(val< min || val>max) return null;

        i--;
        Node node = new Node(val);
        node.right = helper(post,val,max);
        node.left = helper(post,min,val);
        return node;
    }
}