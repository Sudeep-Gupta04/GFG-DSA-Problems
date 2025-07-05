class Solution {
    // Function to find the nodes that are common in both BST.
    public static ArrayList<Integer> findCommon(Node r1, Node r2) {
    Stack<Node> st1 = new Stack<>();
    Stack<Node> st2 = new Stack<>();
    ArrayList<Integer> ans = new ArrayList<>();

    Node t1 = r1;
    Node t2 = r2;

    while (t1 != null) {
        st1.add(t1);
        t1 = t1.left;
    }
    while (t2 != null) {
        st2.add(t2);
        t2 = t2.left;
    }

    while (!st1.isEmpty() && !st2.isEmpty()) {

        Node n1 = st1.peek();
        Node n2 = st2.peek();

        if (n1.data == n2.data) {
            ans.add(n1.data);
            st1.pop();
            st2.pop();

            if (n1.right != null) {
                Node temp = n1.right;
                while (temp != null) {
                    st1.add(temp);
                    temp = temp.left;
                }
            }
            if (n2.right != null) {
                Node temp = n2.right;
                while (temp != null) {
                    st2.add(temp);
                    temp = temp.left;
                }
            }
        } else if (n1.data > n2.data) {
            st2.pop();
            if (n2.right != null) {
                Node temp = n2.right;
                while (temp != null) {
                    st2.add(temp);
                    temp = temp.left;
                }
            }
        } else {
            st1.pop();
            if (n1.right != null) {
                Node temp = n1.right;
                while (temp != null) {
                    st1.add(temp);
                    temp = temp.left;
                }
            }
        }
    }

    return ans;
}

}