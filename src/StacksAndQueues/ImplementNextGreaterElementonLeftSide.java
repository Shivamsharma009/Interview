package StacksAndQueues;

public class ImplementNextGreaterElementonLeftSide {

    static class stack {
        int top;
        int[] items = new int[100];

        void push(int x)
        {
            if(top == 99)
            {
                System.out.println("Stack is Full");
            }
            else{
                items[++top] = x;
            }
        }

        int pop()
        {
            int element = 0;
            if(top == -1)
            {
                System.out.println("Stack is Empty");
            }
            else
            {
                element = items[top--];
            }
            return element;
        }

        boolean isEmpty()
        {
            if(top == -1)
                return true;
            else
                return false;
        }
    }

    static  void PrintNextGreaterElement(int arr[] ,int n)
    {
        int ele , next;
        int i ;
        stack s = new stack();
        s.top = -1;
        s.push(arr[0]);

        for(i = 1; i < n; i++)
        {
            ele =  s.pop();
            next = arr[i];
            while(ele < next)
            {
                ele = s.pop();
                //System.out.println("Next Greater Element on Right side is");
                //System.out.println(ele + "-------> " +next);
                if(s.isEmpty() == true)
                    break;
            }

            if(ele > next) {
              System.out.println("Next Greater Element on Left Side");
              System.out.print(next + "---> " + ele);
                s.push(ele);
            }

            s.push(next);
        }

//        while(s.isEmpty() == false)
//        {
//            ele = s.pop();
//           next = -1;
//            System.out.println(ele + "-------> " +next);
//        }
    }

    //Driver Program
    public static void main(String[] args)
    {
        int []arr = new int[]{9,5,3,2,1,8};
        int n = arr.length;
        PrintNextGreaterElement(arr,n);
    }
}

