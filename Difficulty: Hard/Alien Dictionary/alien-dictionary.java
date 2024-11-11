//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());

            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, n, k);
            if (order.length() == 0) {
                System.out.println(0);
                System.out.println("~");
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++) temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0;
                         i < Math.min(a.length(), b.length()) && index1 == index2;
                         i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2) {
                        return Integer.compare(a.length(), b.length());
                    }

                    return Integer.compare(index1, index2);
                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }

            System.out.println(flag);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
     public String findOrder(String[] dict, int n, int k) {
        // Write your code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<k;++i){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<n-1;++i){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int length=Math.min(s1.length(),s2.length());
            for(int j=0;j<length;++j){
                if(s1.charAt(j)!=s2.charAt(j)){
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }
        
        boolean[] vis = new boolean[k];
        List<Integer> list = Kahn(adj,k);
        
        
        String ans = "";
        
        for(int i:list){
            ans=ans + (char)(i+(int)'a');
        }
        
        return list.size()<k?"":ans;
    }
    
    public List<Integer> Kahn(List<List<Integer>> adj, int k){
        int[] indegree = new int[k];
        
        for(int i=0;i<k;++i){
            for(int j:adj.get(i)) indegree[j]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<k;++i){
            if(indegree[i]==0) q.add(i);
        }
        
        while(!q.isEmpty()){
            int i = q.poll();
            list.add(i);
            for(int j:adj.get(i)){
                indegree[j]--;
                if(indegree[j]==0) q.add(j);
            }
        }
        
        return list;
    }
}
