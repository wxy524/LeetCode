/*
Author: Xueyi Wang

Problem Description:
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<String>();
        int res = 0;
        String operators = "+-*/";
        int left = 0, right = 0;
        
        for(String str : tokens) {
            if(!operators.contains(str)) {
                s.push(str);
            } else {
                if(s.isEmpty()) {
                    System.out.println("Invalid Input");
                    return 0;
                }
                right = Integer.parseInt(s.pop());
                left = Integer.parseInt(s.pop());
                if(str.equals("+")) {
                    s.push(String.valueOf(left + right));
                } else if (str.equals("-")) {
                    s.push(String.valueOf(left - right));
                } else if (str.equals("*")) {
                    s.push(String.valueOf(left * right));
                } else if (str.equals("/")) {
                    s.push(String.valueOf(left / right));
                }
            }
        }
        res = Integer.parseInt(s.pop());
        return res;
    }

}
