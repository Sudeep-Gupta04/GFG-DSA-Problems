//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            Solution obj = new Solution();
            Node res = obj.Bst(arr, n);
            printPostorder(res);
            System.out.println();
        }
    }

    
// } Driver Code Ends
// User function Template for Java

/*
class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

static class Solution {
    // Function that constructs BST from its preorder traversal.
    public Node Bst(int pre[], int size) {
        if (size == 0) return null;
        else {
            return Preorder_to_BST(pre, 0, size - 1, 0);
        }
    }

    private Node Preorder_to_BST(int[] pre, int start, int end, int idx) {

        if (start > end) return null;
        Node node = new Node(pre[start]);
        int greateridx = Find(pre, start + 1, end, node.data);
        if(greateridx==-1) {
            node.right = null;
            node.left =  Preorder_to_BST(pre,start+1,end,idx);
        }else {
            node.left =  Preorder_to_BST(pre,start+1,greateridx-1,idx);
            node.right = Preorder_to_BST(pre,greateridx,end,idx);
        }
        return node;
    }

    private int Find(int[] pre, int start, int end, int data) {

        int index = -1;
        if(start>end) return -1;
        for (int i = start; i <= end; i++) {
            if (pre[i] > data) {
                index = i;
                break;
            }
        }
    return index;
    }
}


//{ Driver Code Starts.

    public static void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void printPostorder(Node node) {
        if (node == null) {
            return;
        }
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
}
// } Driver Code Ends