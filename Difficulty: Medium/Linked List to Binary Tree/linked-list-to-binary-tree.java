/*
// Tree class
class Tree {
    int data;
    Tree left;
    Tree right;

    Tree(int d) {
        data = d;
        left = null;
        right = null;
    }
}

// Linked List Node class
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public TreeNode linkedListToBinaryTree(Node head) {
    HashMap<Integer, TreeNode> hm = new HashMap<>();

    List<Integer> al = new ArrayList<>();
    Node temp = head;
    while (temp != null) {
        al.add(temp.data);
        temp = temp.next;
    }

    for (int i = 0; i < al.size(); i++) {
        TreeNode root;
        if (hm.containsKey(i)) {
            root = hm.get(i);
        } else {
            root = new TreeNode(al.get(i));
            hm.put(i, root);
        }

        int lftidx = 2*i+1;
        int rightidx = 2*i+2;

        if (lftidx < al.size()) {
            TreeNode node = new TreeNode(al.get(lftidx));
            hm.put(lftidx, node);
            root.left = node;
        }

        if (rightidx < al.size()) {
            TreeNode node = new TreeNode(al.get(rightidx));
            hm.put(rightidx, node);
            root.right = node;
        }
    }

    return hm.get(0);
}

}