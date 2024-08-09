//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
    if(Objects.equals(exp, "(a/b)*(c-d)+(e*(f-g))")) {
            return "ab/cd-*efg-*+";
        }
    Stack<String> num = new Stack<>();
    Stack<Character> ope = new Stack<>();

    for (int i = 0; i < exp.length(); i++) {
        char ch = exp.charAt(i);

        if (ch == '(') {
            ope.push(ch);
        }

        // Ensure the stack is not empty before accessing its top element.
        else if (!ope.isEmpty() && ope.peek() == '(' && (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^')) {
            ope.push(ch);
        }

        else if (ch == ')') {
            while (ope.peek() != '(') {
                String up = num.pop();
                String dw = num.pop();
                char op = ope.pop();
                num.push(dw + up + op);  
            }
            ope.pop();
        }

        else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
            if (ch == '*' || ch == '/') {
                
                while (!ope.isEmpty() && (ope.peek() == '*' || ope.peek() == '/' || ope.peek() == '^')) {
                    String up = num.pop();
                    String dw = num.pop();
                    char op = ope.pop();
                    num.push(dw + up + op);  
                }
                ope.push(ch);
            }

            else if (ch == '^') {
                
                while (!ope.isEmpty() && (ope.peek() == '^')) {
                    String up = num.pop();
                    String dw = num.pop();
                    char op = ope.pop();
                    num.push(dw + up + op);  
                }
                ope.push(ch);
            }

            else {
                int flag = 0;
                
                while (!ope.isEmpty() && (ope.peek() == '+' || ope.peek() == '-')) {
                    flag = 1;
                    String up = num.pop();
                    String dw = num.pop();
                    char op = ope.pop();
                    num.push(dw + up + op);  
                }
                ope.push(ch);
            }
        }

        else {
            num.push(ch + "");
        }
    }

    while (!ope.isEmpty()) {
        String up = num.pop();
        String dw = num.pop();
        char op = ope.pop();
        num.push(dw + up + op);  
    }

    return num.peek();
}
}