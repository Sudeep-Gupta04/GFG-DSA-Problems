//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) { this.data = data; }
}

class GFG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void preorder(Node root, List<Integer> temp) {
        if (root == null) return;
        temp.add(root.data);
        preorder(root.left, temp);
        preorder(root.right, temp);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            Node root = buildTree(s);
            Solution obj = new Solution();
            List<Node> res = obj.printAllDups(root);

            List<List<Integer>> ans = new ArrayList<>();

            for (int i = 0; i < res.size(); i++) {
                List<Integer> temp = new ArrayList<>();
                preorder(res.get(i), temp);
                ans.add(temp);
            }
            Collections.sort(ans,
                             (x, y)
                                 -> x.get(0) == y.get(0) ? x.size() - y.size()
                                                         : x.get(0) - y.get(0));

            for (int i = 0; i < ans.size(); i++) {
                for (int j = 0; j < ans.get(i).size(); j++) {
                    System.out.print(ans.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends




class Solution {
     public List<Node> printAllDups(Node root){
        HashMap<String, Integer> mp = new HashMap<>();
        ArrayList<String> al = new ArrayList<>();
        checkSubtree(root, mp);
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            if (entry.getValue() >= 2) {
                al.add(entry.getKey());
            }
        }
        ArrayList<Node> alNode = new ArrayList<>();
        getAllNodes(al,alNode,root);
        return alNode;

    }

    private void getAllNodes(ArrayList<String> al, ArrayList<Node> alNode, Node root) {
        
        if(root==null) return;
        if(al.size()==0) return;
        String ans = preorderTraversal(root);
        if(al.contains(ans)){
            alNode.add(root);
            al.remove(ans);
        }
           
        getAllNodes(al,alNode,root.left);
        getAllNodes(al,alNode,root.right);
    }

    private void checkSubtree(Node root, HashMap<String,Integer> mp) {
        if(root==null) return;
        String io = preorderTraversal(root);
        if(!mp.containsKey(io)) mp.put(io,1);
        else if (mp.containsKey(io)) {
            mp.put(io,mp.get(io)+1);
        }
        checkSubtree(root.left,mp);
        checkSubtree(root.right,mp);
    }
    public String preorderTraversal(Node root){
        if(root==null) return "N";
        return root.data+"-" + "" + preorderTraversal(root.left)+preorderTraversal(root.right);
    }
}