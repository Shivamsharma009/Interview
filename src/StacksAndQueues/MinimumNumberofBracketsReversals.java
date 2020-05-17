package StacksAndQueues;

import javax.swing.*;
import java.util.Stack;

public class MinimumNumberofBracketsReversals {

    static int CountMinReversals(String str)
    {
        int len = str.length();
        if(len % 2 != 0)
            return -1;

        Stack<Character> st = new Stack<>();
        for(int i = 0; i < len ; i++)
        {
            char ch = str.charAt(i);
            if(ch == '}' && !st.isEmpty()) {
                int x = st.peek();
                if (x == '{')
                    st.pop();
                else
                    st.push(ch);
            }
            else {
                st.push(ch);
            }
        }

        int unbal_len = st.size();
        int n = 0;
        while(!st.isEmpty() && st.peek() == '{')
        {
            st.pop();
            n++;
        }
        return (unbal_len / 2 + n%2);
    }

    //Driver Program
    public static void main(String[] args)
    {
        String str = "}}{{}}{{{}";
        int res = CountMinReversals(str);
        System.out.println("Min Number of Brackets Reversals needed "+res);

    }
}
