/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
static int i = 0;

public static Node treeFromString(String s) {
    Stack<Node> st = new Stack<>();
    String str = "(" + s + ')'; 
    int i = 0;

    while (i < str.length()) {
        char ch = str.charAt(i);

        if (ch == '(') {
            st.push(null);
        } else if (ch != ')') {
            int num = 0;
            while (i < str.length() && str.charAt(i) != ')' && str.charAt(i) != '(') {
                num = num * 10 + (str.charAt(i) - '0');
                i++;
            }
            st.push(new Node(num));
            continue; 
        } else {
            List<Node> al = new ArrayList<>();
            
            if(st.peek()==null){
                st.pop();
                st.add(new Node(-1));
            }else{
                
                 while (!st.isEmpty() && st.peek() != null) {
                    al.add(st.pop()); 
                }
                st.pop();
                Collections.reverse(al);
    
                if (al.size() == 1) {
                    st.push(al.get(0)); 
                } else if (al.size() == 2) {
                    Node parent = al.get(0);
                    parent.left = al.get(1);
                    if(parent.left.data==-1) parent.left =null;
                    st.push(parent);
                } else if (al.size() == 3) {
                    Node parent = al.get(0);
                    parent.left = al.get(1);
                    parent.right = al.get(2);
                    if(parent.left.data==-1) parent.left =null;
                    if(parent.right.data==-1) parent.right =null;
                    st.push(parent);
                } 
            }
            
        }

        i++;
    }

    return st.peek();
}


public static Node helper(String s) {
    if (i >= s.length()) return null;

    if (s.charAt(i) == ')') return null;

    int start = i + 1;
    while (start < s.length() && Character.isDigit(s.charAt(start))) start++;

    Node root = new Node(Integer.parseInt(s.substring(i + 1, start)));
    i = start;

    if (i < s.length() && s.charAt(i) == '(') {
        i++; // skip '('
        root.left = helper(s);
        i++; // skip ')'
    }

    if (i < s.length() && s.charAt(i) == '(') {
        i++; // skip '('
        root.right = helper(s);
        i++; // skip ')'
    }

    return root;
}



}
