package StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingOneQueue {

    static class Stack{

        static int curr_size;
        Stack(){
            curr_size = 0;
        }

       static Queue<Integer> q = new LinkedList<Integer>();

        static void push(int val)
        {
            //current size
            curr_size++;

            //previous size of stack
            int size = q.size();

            //Add Current Element
            q.add(val);

            //pop previous element and add
            //after current element
            for(int i = 0 ;i < size;i++)
            {
                int x = q.remove();
                q.add(x);

            }
        }

        static int pop()
        {
            if(q.isEmpty()) {
                System.out.println("No Element present");
                return -1;
            }
            curr_size--;
            int x = q.remove();

            return x;
        }

        static int top()
        {
            if(q.isEmpty())
                return -1;

            return q.peek();
        }

        static int size()
        {
            return curr_size;
        }
    }

    //Driver Program
    public static void main(String[] args)
    {
        Stack s = new Stack();
        Stack.push(1);
        Stack.push(2);
        Stack.push(5);
        System.out.println(Stack.top());
        Stack.pop();
        System.out.println(Stack.top());
        Stack.pop();
        System.out.println(Stack.size());
    }
}
