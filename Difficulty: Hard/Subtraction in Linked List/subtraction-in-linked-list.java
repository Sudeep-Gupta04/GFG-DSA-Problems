//{ Driver Code Starts
import java.util.Scanner;
import java.math.*;

// Node Class
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

// Linked List Class
class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    // creates a new node with given value and appends it at the end of the linked list
    void insert(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
    }
}


public class Main {
    static void printList(Node n) 
    {
        while (n != null) {
            System.out.print(n.data);
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; ++i) {
            int n = sc.nextInt();
            LinkedList LL1 = new LinkedList();
            String l1 = sc.next();
            for (int j = 0; j < n; ++j) {
                int x = Character.getNumericValue(l1.charAt(j));
                LL1.insert(x);
            }

            int m = sc.nextInt();
            LinkedList LL2 = new LinkedList();
            String l2 = sc.next();
            for (int j = 0; j < m; ++j) {
                int x = Character.getNumericValue(l2.charAt(j));
                LL2.insert(x);
            }

            Solution ob = new Solution();
            Node res = ob.subLinkedList(LL1.head, LL2.head);
            printList(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
        private Node solve(Node h1, Node h2) {
        Node H1 = reverseList(h1);
        Node H2 = reverseList(h2);


        Node temp = new Node(-1);
        Node h = temp;
        while(H2!=null){
            int num1 = H1.data;;
            int num2 = H2.data;
            if(num1>=num2){
                Node node = new Node(num1-num2);
                temp.next = node;
                temp = temp.next;
                H1 = H1.next;
                H2 = H2.next;
            }else {
                Node t = H1.next;
                while (true){
                   if(t.data==0) {
                       t.data = 9;
                       t = t.next;
                   }
                   else {
                       t.data = t.data-1;
                       num1 = 10+num1;
                       break;
                   }
                }
                Node node = new Node(num1-num2);
                temp.next = node;
                temp = temp.next;
                H1 = H1.next;
                H2 = H2.next;
            }
        }
        while(H1!=null){
            Node q = new Node(H1.data);
            temp.next = q;
            temp = temp.next;
            H1 = H1.next;
        }
        return reverseList(h.next);
    }
     public Node fix(Node head){
        while(head!=null && head.data==0){
            head = head.next;
        }
        return head;
    }
    public int count(Node head){
        Node temp = head;
        int c = 0;
        while(temp!=null){
            c++;
            temp = temp.next;
        }
        return c;
    }
    public Node subLinkedList(Node head1, Node head2) {
        Node H1 = fix(head1);
        Node H2 = fix(head2);
        if(H1==null && H2==null){
            return new Node(0);
        }
        if(H1==null) return H2;

        if(H2==null) return H1;

        int c1 = count(H1);
        int c2 = count(H2);
        if(c1==c2 && c1==1){
            return new Node(Math.abs(H1.data-H2.data));
        }
        Node ans;
        if(c2>c1){
            ans = solve(H2,H1);
        } else if (c1>c2) {
            ans = solve(H1,H2);
        }else {
            int a = findBigger(H1,H2);
            if(a==1){
                ans = solve(H1,H2);
            } else if (a==2) {
                ans = solve(H2,H1);
            }else {
                return new Node(0);
            }
        }
        Node p = fix(ans);
        if(p==null) return new Node(0);
        else return p;
    }

    private int findBigger(Node H1, Node H2) {
        Node t1 = H1;
        Node t2 = H2;
        while (t1 != null && t2 != null) {
            if (t1.data > t2.data) {
                return 1;  
            } else if (t1.data < t2.data) {
                return 2;  
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        return 0;
    }
    Node reverseList(Node head) {
        if (head.next == null) return head;
        Node prev = null;
        Node curr = head;
        Node fut = head.next;
        while (fut != null) {
            curr.next = prev;
            prev = curr;
            curr = fut;
            fut = fut.next;
        }
        curr.next = prev;
        return curr;
    }

}
        
