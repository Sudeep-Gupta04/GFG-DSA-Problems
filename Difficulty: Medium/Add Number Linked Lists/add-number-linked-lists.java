//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends

/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/
class Solution {
    static Node reverse(Node head)
    {
        Node prev = null;
        Node temp = head;
        while(temp != null)
        {
            Node after = temp.next;
            temp.next = prev;
            prev = temp;
            temp =after;
        }
        return prev;
    }
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        Node t1 = reverse(num1);
        Node t2 = reverse(num2);
        Node res = new Node(-1);
        Node curr = res;
        int carry = 0;
        while(t1 != null || t2 != null)
        {   int sum =0;
            sum += carry;
            if(t1 != null)
            {
                sum += t1.data;
            }    
            if(t2 != null) 
            {
                sum += t2.data;
            }
            int data = sum%10;
            carry = sum/10;
            Node newNode = new Node(data);
            curr.next = newNode;
            curr = curr.next;
          
            if(t1 != null)
               t1 = t1.next;
            if(t2 != null)
               t2 = t2.next;
            
        }
        if(carry > 0)
        {
            curr.next = new Node(carry);
        }
        Node result = reverse(res.next);
        Node temp = result;
        // skip prepend 0 node 
        while(temp != null)
        {
            if(temp.data == 0)
            {
                temp = temp.next;
            }else{
                break;
            }
        }
        return temp;
    }
}


//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends