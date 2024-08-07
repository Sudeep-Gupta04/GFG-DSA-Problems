//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to flatten a linked list
   Node flatten(Node root)
    {
        if(root==null || root.next==null) return root;
        Node prev = root;
        Node temp = root.next;
        while (temp!=null){
            Node node = mergeSortedLLinPlace(prev,temp);
            node.next = temp.next;
            temp = temp.next;
            prev = node;
        }
        return prev;

    }
    public Node mergeSortedLLinPlace(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node Head = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data >= head2.data) {
                dummy.bottom = head2;
                head2 = head2.bottom;
                dummy = dummy.bottom;
            } else {
                dummy.bottom = head1;
                head1 = head1.bottom;
                dummy = dummy.bottom;
            }
        }

        if (head1 != null) {
            dummy.bottom = head1;
        }

        if (head2 != null) {
            dummy.bottom = head2;
        }

        return Head.bottom;
    }
}

//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the remaining newline

        while (t-- > 0) {
            String[] workArray = sc.nextLine().trim().split(" ");
            int n = workArray.length;

            Node head = null;
            Node pre = null;

            for (int i = 0; i < n; i++) {
                int m = Integer.parseInt(workArray[i]);
                int data = sc.nextInt();
                Node temp = new Node(data);
                if (head == null) {
                    head = temp;
                    pre = temp;
                } else {
                    pre.next = temp;
                    pre = temp;
                }

                Node preB = temp;
                for (int j = 0; j < m - 1; j++) {
                    int tempData = sc.nextInt();
                    Node tempB = new Node(tempData);
                    preB.bottom = tempB;
                    preB = tempB;
                }
            }

            // Consume the remaining newline if there's any
            if (sc.hasNextLine()) {
                sc.nextLine();
            }

            Solution ob = new Solution();
            Node root = ob.flatten(head);
            printList(root);
        }
        sc.close();
    }
}

// } Driver Code Ends