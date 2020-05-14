package StacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args)
    {
        Stack<Character> st = new Stack<>();
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        for(int i = 0 ; i < str.length();i++)
        {
            char ch = str.charAt(i);

            if(ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else {
                if(ch == ')')
                {
                    boolean val = handleClosing(st,ch);
                    if(val == false){
                        System.out.print(val);
                        return;
                    }
                }else if(ch == '}'){
                    boolean val = handleClosing(st,ch);
                    if(val == false){
                        System.out.print(val);
                        return;
                    }
                }else if(ch == ']'){
                    boolean val = handleClosing(st,ch);
                    if(val == false){
                        System.out.print(val);
                        return;
                    }
                }
            }
        }
        if(st.size() == 0){
            System.out.print(false);
        }else{
            System.out.print(true);
        }
    }


    public static  boolean handleClosing(Stack<Character> st , char ch )
    {
        if(st.size() == 0)
            return false;
        else if(st.peek() != ch)
            return false;
        else{
                 st.pop();
                 return true;
            }
        }
    }

