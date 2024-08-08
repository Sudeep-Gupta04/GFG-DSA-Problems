//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    /* Function to print nodes in a given linked list */
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Driver program to test the above functions
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            List<Node> arr = new ArrayList<>();
            List<Integer> nums = new ArrayList<>();
            String input = sc.nextLine();

            Scanner ss = new Scanner(input);
            while (ss.hasNextInt()) {
                nums.add(ss.nextInt());
            }
            int ind = 0;
            int N = nums.size();

            while (ind < N) {
                int n = nums.get(ind++);
                int x = nums.get(ind++);
                Node head = new Node(x);
                Node curr = head;
                n--;

                for (int i = 0; i < n; i++) {
                    x = nums.get(ind++);
                    Node temp = new Node(x);
                    curr.next = temp;
                    curr = temp;
                }
                arr.add(head);
            }

            Solution obj = new Solution();
            Node res = obj.mergeKLists(arr);
            printList(res);
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
/*class Node
{
    int data;
    Node next;

    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// arr is an array of Nodes of the heads of linked lists

class Solution {
    // Function to merge K sorted linked list.
     public Node mergeKLists(List<Node> arr) {

        Node ans = new Node(-1);
        Node head = ans;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        for(int i =0;i<arr.size();i++){
            if(arr.get(i)!=null){
                pq.add(arr.get(i));
            }
        }

        while (!pq.isEmpty()){
            Node linklist =  pq.remove();
            if (linklist == null) {
                pq.remove(linklist.next);
                continue;
            }
            else if(linklist!=null){
                Node node = new Node(linklist.data);
                ans.next = node;
                ans = ans.next;
                if(linklist.next!=null){
                    pq.add(linklist.next);
                }

            }
        }
        return head.next;
    }
}