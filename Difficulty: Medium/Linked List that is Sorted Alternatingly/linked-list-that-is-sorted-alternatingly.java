//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}

// } Driver Code Ends



/*
class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
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
     Node sortedMerge1(Node head1, Node head2) {
        // This is a "method-only" submission.
        // You only need to complete this method
        Node temp = new Node(-101);
        Node Head = temp;
        Node h1 = head1;
        Node h2 = head2;
        while (h1!=null && h2!=null){
            if(h1.data>=h2.data){
                Node node =  new Node(h2.data);
                temp.next = node;
                temp=temp.next;
                h2 = h2.next;
            }else {
                Node node =  new Node(h1.data);
                temp.next = node;
                temp=temp.next;
                h1 = h1.next;
            }
        }
        while (h1!=null){
            Node node =  new Node(h1.data);
            temp.next = node;
            temp=temp.next;
            h1 = h1.next;
        }
        while (h2!=null){
            Node node =  new Node(h2.data);
            temp.next = node;
            temp=temp.next;
            h2 = h2.next;
        }
        return Head.next;
    }
   public Node sort(Node head){
        //your code here, return the head of the sorted list
        if(head.next==null) return head;
        else {
            Node inc = head;
            Node tinc = head;
            Node dec = head.next;
            Node tdec = head.next;
            while (inc!=null && dec!=null && inc.next!=null && dec.next!=null){
                inc.next = inc.next.next;
                inc = inc.next;
                dec.next= dec.next.next;
                dec = dec.next;
            }
            if(inc!=null) inc.next = null;
            if(dec!=null) dec.next = null;


            Node node = reverseList(tdec);
            return sortedMerge1(node,tinc);
        }
    }
}