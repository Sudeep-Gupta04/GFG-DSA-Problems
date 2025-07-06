/*
Node defined as
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
    boolean isHeap(Node tree) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(tree);
        int flag = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.remove();

                if (node.left == null && node.right != null) return false;
                else if (node.left != null && node.right != null) {
                    if (node.left.data > node.data || node.right.data > node.data) return false;
                    q.add(node.left);
                    q.add(node.right);
                } else if (node.left == null) {
                    flag = 1;
                    break;
                } else {
                    if (node.left.data > node.data) return false;
                    q.add(node.left);
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) break;
        }

        while (!q.isEmpty()) {
            Node node = q.remove();
            if (!(node.left == null && node.right == null)) return false;
        }
        return true;
    }
}
