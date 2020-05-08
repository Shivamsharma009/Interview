package StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingTwoQueue{

    static class Stack{

        static int curr_size;

        Stack(){
            curr_size = 0;
        }

        //Two Queue Maintaining
        static   Queue<Integer> q1 = new LinkedList<Integer>();
        static Queue<Integer> q2 = new LinkedList<Integer>();

        static  void push(int x)
        {
            curr_size++;
            //push the element into q2
            q2.add(x);


            //push to other queue and become q2 become empty
            while(!q1.isEmpty())
            {
                q2.add(q1.peek());
                q1.remove();
            }

            //swap the queue for  not create confusion
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
        }

        static void pop()
        {
            if(q1.isEmpty())
                return;
            q1.remove();
            curr_size--;
        }

        static int size()
        {
            return curr_size;
        }

        static int top()
        {
            if(q1.isEmpty())
                return -1;
            return q1.peek();
        }
    }

    //Driver Program
    public static void main(String[] args)
    {
        Stack s = new Stack();
        Stack.push(1);
        Stack.push(2);
        Stack.push(3);
        Stack.push(4);
        Stack.push(5);

        System.out.print(Stack.top() +"     ");
        Stack.pop();
        System.out.println(Stack.top());
        Stack.pop();

        System.out.print("Current size of stack is "+Stack.size());
    }
}
