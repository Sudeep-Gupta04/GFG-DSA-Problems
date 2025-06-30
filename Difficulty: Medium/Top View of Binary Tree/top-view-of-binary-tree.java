/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    static TreeMap<Integer, int[]> tm;
    static ArrayList<Integer> topView(Node root) {
        tm = new TreeMap<>();
        helper(root, 0,0);
        ArrayList<Integer> al = new ArrayList<>();

        for(Map.Entry<Integer, int[]> i:tm.entrySet()){
            al.add(i.getValue()[1]);
        }
        return al;
    }

    public static void helper(Node root, int dir,int depth) {
        if (root == null) return;

        if (!tm.containsKey(dir)) {
            tm.put(dir, new int[]{depth , root.data});
        }
        else if(tm.containsKey(dir)){
            int[] arr = tm.get(dir);
            if(arr[0]>depth) tm.put(dir,new int[]{depth , root.data});
        }
        helper(root.left, dir - 1,depth+1);
        helper(root.right, dir + 1,depth+1);
    }
}
