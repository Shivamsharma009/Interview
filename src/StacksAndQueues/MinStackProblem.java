package StacksAndQueues;

import java.util.Stack;

class MyStack {
    Stack<Integer> stack = new Stack<Integer>();
    Integer minEle;


    void getMin() {
        if (stack.isEmpty()) {
            System.out.print("stack is Empty");
        } else {
            System.out.print("   " + minEle);
        }
    }

    //peek() function

    void peek() {
        if (stack.isEmpty()) {
            System.out.println("stack is Empty");
            return;
        }
        Integer t = stack.peek();

        if (t < minEle) {
            System.out.print("    " + minEle);
        } else {
            System.out.print("   " + t);
        }
    }


    void pop() {
        if (stack.isEmpty()) {
            System.out.print("Stack is empty");
            return;
        }
        Integer t = stack.pop();

        if (t < minEle) {
            System.out.print("Popeed Element " + minEle);
            minEle = minEle - (-t);
        } else {
            System.out.print("Popped Element " + t);
        }
    }

    void push(Integer x) {
        if (stack.isEmpty()) {
            minEle = x;
            stack.push(x);
            return;
        }

        if (x < minEle) {
            stack.push(x - minEle);
            minEle = x;
        } else {
            stack.push(x);
        }
    }

}

    //Driver Program
    class MinStackProblem{
    public static  void main(String[] args)
    {
        MyStack  s = new MyStack();
        s.push(3);
        s.push(5);
        s.push(1);
        s.getMin();

        s.push(9);
        s.push(10);
        s.push(14);
        s.getMin();

    }
}
