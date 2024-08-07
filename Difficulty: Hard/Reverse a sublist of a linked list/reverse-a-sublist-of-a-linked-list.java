//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Main {
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input1 = br.readLine().trim().split("\\s+");
            if (input1.length < 2) {
                System.out.println(-1);
                continue;
            }
            int a = Integer.parseInt(input1[0]);
            int b = Integer.parseInt(input1[1]);

            String[] input2 = br.readLine().trim().split("\\s+");
            if (input2.length == 0) {
                System.out.println(-1);
                continue;
            }

            Node head = new Node(Integer.parseInt(input2[0]));
            Node tail = head;
            for (int i = 1; i < input2.length; i++) {
                tail.next = new Node(Integer.parseInt(input2[i]));
                tail = tail.next;
            }

            Solution ob = new Solution();
            Node newHead = ob.reverseBetween(a, b, head);
            printList(newHead);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution {
     public static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }

    public static Node reverseBetween(int a, int b, Node head) {
        if (a == b) return head;

        Node tempL = head;
        Node tempR = head;
        int count = 1;
        
        for (int i = 1; i < b; i++) {
            if (count < a - 1) {
                tempL = tempL.next;
                count++;
            }
            tempR = tempR.next;
        }

        Node rotatingStart;
        if (a == 1) {
            rotatingStart = tempL;
        } else {
            rotatingStart = tempL.next;
        }

        Node secondHalf = tempR.next;
        tempR.next = null;

        Node node = reverseList(rotatingStart);
        Node temp = node;
        
        while (temp.next != null) {
            temp = temp.next;
        }
        
        temp.next = secondHalf;
        
        if (a == 1) {
            return node;
        }
        
        tempL.next = node;
        return head;
    }

}