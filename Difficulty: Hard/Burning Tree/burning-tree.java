/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}  */
class Solution {
    public static int minTime(Node root, int target) {
        // code here
        ArrayList<Node> al = helper(root,target);;
        Collections.reverse(al);
        // for(int i =0;i<al.size();i++){
        //     System.out.print(al.get(i).data+" ");
        // }
        Node temp = al.get(al.size()-1);
        int time1 = bfs(temp);
        temp.right = null; temp.left = null;

        for(int i = al.size()-2;i>=0;i--){
            Node par = al.get(i);
            Node child = al.get(i+1);

            if(child.left==null) child.left=par;
            else child.right=par;

            if(par.left==child) par.left = null;
            else par.right = null;
        }

        int time2 = bfs(al.get(al.size()-1));
        return Math.max(time1,time2)-1;
    }
    public static int bfs(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        int lv =0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                Node nd = q.remove();
                if(nd.left!=null) q.add(nd.left);
                if(nd.right!=null) q.add(nd.right);
            }
            lv++;
        }
        return lv;
    }
    public static ArrayList<Node> helper(Node root,int tar){
        if(root==null) return null;

        if(root.data==tar){
            ArrayList<Node> al = new ArrayList<>(); al.add(root);
            return al;
        }

        ArrayList<Node> alleft  =  helper(root.left,tar);
        ArrayList<Node> alright =  helper(root.right,tar);

        if(alleft==null && alright!=null){
            alright.add(root);
            return alright;
        }else if(alleft!=null && alright==null){
            alleft.add(root);
            return alleft;
        }else{
            return null;
        }
    }
}