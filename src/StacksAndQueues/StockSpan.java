package StacksAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

    static void CalculateSpan(int []Prices,int n , int []Span)
    {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        Span[0] = 1;

        for(int i = 0 ; i < n ;  i++)
        {
            while(!st.isEmpty() && Prices[st.peek()] <= Prices[i])
                st.pop();

            Span[i] = (st.empty() ? (i+1) : i - st.peek());

            st.push(i);
        }
    }

    static  void printArray(int []arr)
    {
        System.out.println(Arrays.toString(arr));
    }


    //Driver Program
    public static void main(String[] args)
    {
        int []Prices = new int[]{100,80,60,70,60,75,85};
        int n = Prices.length;

        int []Span = new int[n];

        CalculateSpan(Prices,n,Span);

        printArray(Span);

    }
}
