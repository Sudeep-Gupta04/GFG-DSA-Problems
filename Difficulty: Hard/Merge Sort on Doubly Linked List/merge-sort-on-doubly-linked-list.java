//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next, prev;

    Node(int key) {
        data = key;
        next = prev = null;
    }
}

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                Node n1 = new Node(a);
                n1.prev = temp;
                temp.next = n1;
                temp = n1;
            }

            head = new Solution().sortDoubly(head);
            printList(head);
        }
    }

    public static void printList(Node node) {
        Node temp = node;
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/
class Solution {
    
     private static int getCount(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    static Node sortDoubly(Node head) {
        int count = getCount(head);
        return helper(head, count);
    }

    private static Node helper(Node head, int count) {
        if (count <= 1) return head;

        Node mid = getMiddle(head, count);
        Node secondHalf = mid.next;
        mid.next = null;
        if (secondHalf != null) {
            secondHalf.prev = null;
        }

        Node left = helper(head, (count + 1) / 2);
        Node right = helper(secondHalf, count - (count + 1) / 2);
        return sortedMergeInPlace(left, right);
    }

    static Node sortedMergeInPlace(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node temp = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1.prev = temp;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2.prev = temp;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        if (head1 != null) {
            temp.next = head1;
            head1.prev = temp;
        } else {
            temp.next = head2;
            if (head2 != null) {
                head2.prev = temp;
            }
        }

        dummy.next.prev = null; // Set the prev pointer of the new head to null
        return dummy.next;
    }

    private static Node getMiddle(Node head, int count) {
        Node slow = head;
        for (int i = 1; i < (count + 1) / 2; i++) {
            slow = slow.next;
        }
        return slow;
    }
}