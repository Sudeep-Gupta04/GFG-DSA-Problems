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


// } Driver Code Ends
/* Following is the Linked list node structure */

/*class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
     void reorderlist(Node head) {
        if(head==null|| head.next==null||head.next.next==null) return;
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node dummy= new Node(-1);
        dummy.next = head;
        Node temp = head;
        
        Node next_half = slow.next;
        slow.next = null;
        Node half = reverseList(next_half);
        
        while (half!=null){
            temp = temp.next;
            dummy = dummy.next;
            dummy.next = half;
            half = half.next;
            dummy = dummy.next;
            dummy.next = temp;
        }
        
    }
    Node reverseList(Node head) {
        if(head.next==null ) return head;
        Node prev = null;
        Node curr = head;
        Node fut = head.next;
        while (fut!=null){
           curr.next = prev;
           prev = curr;
           curr = fut;
           fut = fut.next;
        }
        curr.next = prev;
        return curr;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            new Solution().reorderlist(head);

            printList(head);
        }
    }
}
// } Driver Code Ends