//{ Driver Code Starts
import java.util.*;

class Node
{

    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class LinkedList
{
    
 

    /* Function to print linked list */
   public static void print(Node root)
    {
        Node temp = root;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
    }


    /* Driver program to test above functions */
    public static void main(String args[])
    {

        /* Constructed Linked List is 1.2.3.4.5.6.
         7.8.8.9.null */
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt() )
        {
            int n = sc.nextInt();
            
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;

            for (int i = 1; i < n && sc.hasNextInt() ; i++)
            {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }


            Node result = new Solution().compute(head);
            print(result);
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution
{    Node reverseList(Node head) {
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
    
    Node compute(Node head)
    {
        Node Head = reverseList(head);
        Node temp = Head;
        while(temp.next!=null){
            if(temp.next.data<temp.data){
                temp.next = temp.next.next;
            }else temp = temp.next;
        }
        return reverseList(Head);
        
    }
}
  