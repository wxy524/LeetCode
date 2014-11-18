/*
Author: Xueyi Wang
Date: Nov 17 2014

Probelm Description:
Design a stack that supports push, pop, top, and retrieving 
the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/

class MinStack {
    ArrayList<Integer> stk = new ArrayList<Integer>();
    ArrayList<Integer> minStk = new ArrayList<Integer>();
    
    public void push(int x) {
        stk.add(x);
        if(minStk.isEmpty() || minStk.get(minStk.size()-1) >= x) {
            minStk.add(x);
        }
    }

    public void pop() {
        if(stk.isEmpty()) {
            return;
        }
        
        int elm = stk.remove(stk.size()-1);
        if(!minStk.isEmpty() && minStk.get(minStk.size()-1) == elm) {
            minStk.remove(minStk.size()-1);
        }
    }

    public int top() {
        if(stk.isEmpty()) {
            return 0;
        } else {
             return stk.get(stk.size()-1);    
        }
    }

    public int getMin() {
        if(minStk.isEmpty()) {
            return 0;
        } else {
            return minStk.get(minStk.size()-1);
        }
    }
}
