package StacksAndQueues;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    static void SlidingWindowMAX(int [] arr,int n ,int k)
    {
        Deque<Integer> q1 = new LinkedList<>();

        int i ;
        for(i = 0 ; i < k; i++)
        {
            //Remove the Element which are smaller than current element
            //Or Remove needless element
            while (!q1.isEmpty() && arr[i] >= arr[q1.peekLast()])
                q1.removeLast();
            q1.addLast(i);
        }
        for(i = k ; i < n; i++)
        {
            //Print first Element because first element is largest Element.
            System.out.print("      "+arr[q1.peek()]);

            //Remove the Element which are out of this window
            while(!q1.isEmpty() && q1.peek() <= i-k)
                q1.removeFirst();

            //Remove the Element which are smaller than current element
            //Or Remove needless element
            while(!q1.isEmpty() && arr[i] >= arr[q1.peekLast()])
                q1.removeLast();

            q1.addLast(i);
        }
        System.out.print("    "+arr[q1.peek()]);
    }


    //Driver Program
    public static void main(String[] args)
    {
        int[] arr = {12,1,78,90,57,89,56};
        int n = arr.length;
        int k = 3;
        SlidingWindowMAX(arr,n,k);
    }
}
