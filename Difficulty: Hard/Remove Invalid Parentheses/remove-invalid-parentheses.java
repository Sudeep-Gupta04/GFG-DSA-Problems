//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }
    
    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<String> a)
    {
        for(int i = 0; i < a.size()-1; i++)
            System.out.print(a.get(i)+" ");
        System.out.println(a.get(a.size()-1));
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            ArrayList<String> res = obj.removeInvalidParentheses(s);
            
            StringArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<String> removeInvalidParentheses(String s) {
        HashSet<String> hs = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();
        healper(result, s, new StringBuilder(), hs);
        result.addAll(hs);
        Collections.sort(result);
        return result;
    }

    private static void healper(List<String> l, String s, StringBuilder c, HashSet<String> hs) {
        if (s.length() == 1) {
            // Case 1: Include the last character
            c.append(s.charAt(0));
            if (checkIsValid(c)) {
                String a = "";
                if (!hs.isEmpty()) {
                    a = hs.iterator().next();
                }
                if (hs.isEmpty() || a.length() == c.length()) {
                    hs.add(c.toString());
                } else if (a.length() < c.length()) {
                    hs.clear();
                    hs.add(c.toString());
                }
            }
            c.deleteCharAt(c.length() - 1);  // Remove the last character

            // Case 2: Exclude the last character (do nothing)
            if (checkIsValid(c)) {
                String a = "";
                if (!hs.isEmpty()) {
                    a = hs.iterator().next();
                }
                if (hs.isEmpty() || a.length() == c.length()) {
                    hs.add(c.toString());
                } else if (a.length() < c.length()) {
                    hs.clear();
                    hs.add(c.toString());
                }
            }
            return;
        }

        // Include current character
        c.append(s.charAt(0));
        healper(l, s.substring(1), c, hs);
        c.deleteCharAt(c.length() - 1);  // Backtrack

        // Exclude current character
        healper(l, s.substring(1), c, hs);
    }

    private static boolean checkIsValid(StringBuilder c) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < c.length(); i++) {
            if (c.charAt(i) == '(') {
                st.push('(');
            } else if (c.charAt(i) == ')') {
                if (st.isEmpty() || st.peek() != '(') {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }
}
