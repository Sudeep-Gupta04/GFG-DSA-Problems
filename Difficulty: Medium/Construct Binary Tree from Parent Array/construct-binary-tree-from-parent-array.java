/*node class of the binary tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/
class Solution {
    // Function to construct binary tree from parent array.
    public Node createTree(int parent[]) {
    Node root = null; // Initialize root
    HashMap<Integer, Node> hm = new HashMap<>();

    for (int i = 0; i < parent.length; i++) {
        if (parent[i] == -1) {
            if (hm.containsKey(i)) {
                root = hm.get(i);
            } else {
                root = new Node(i);
                hm.put(i, root);
            }
        } else {
            int child = i;
            int par = parent[i];
            if (!hm.containsKey(child) && !hm.containsKey(par)) {
                Node parNode = new Node(par);
                Node chl = new Node(child);
                parNode.left = chl;
                hm.put(child, chl);
                hm.put(par, parNode);
            } else if (hm.containsKey(par) && !hm.containsKey(child)) {
                Node parNode = hm.get(par);
                Node chl = new Node(child);
                if (parNode.left == null) {
                    parNode.left = chl;
                } else {
                    parNode.right = chl;
                }
                hm.put(child, chl);
            } else if(hm.containsKey(child) && hm.containsKey(par)){
                Node parNode = hm.get(par);
                if(parNode.left==null) parNode.left = hm.get(child);
                else parNode.right = hm.get(child);
            }else{
                Node parNode = new Node(par);
                parNode.left = hm.get(child);
                hm.put(par,parNode);
            }
        }
    }
    return root;
}

}