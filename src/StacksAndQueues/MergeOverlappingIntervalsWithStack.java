package StacksAndQueues;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeOverlappingIntervalsWithStack {

    static class Interval{
        int start;
        int end;

        Interval(int start,int end)
        {
            this.start = start;
            this.end = end;
        }
    }

    public static void MergeOverlappingInterval(Interval[] arr)
    {
        if(arr.length <= 0)
            return;

        Stack<Interval> stack = new Stack<>();

        Arrays.sort(arr, new Comparator<Interval>(){
            public int compare(Interval v1 , Interval v2){
                return v1.start - v2.start;
        }
    });
        stack.push(arr[0]);

        for(int i = 1; i< arr.length;i++)
        {
            Interval top = stack.peek();

            if(top.end <= arr[i].start)
                stack.push(arr[i]);

            else if(top.end <= arr[i].end)
            {
                top.end = arr[i].end;
                stack.pop();
                stack.push(top);
            }
        }
        System.out.println("Merge Overlapping Interval is ");
        while(!stack.isEmpty())
        {
            Interval t = stack.pop();
            System.out.print("["+ t.start+"  "+t.end +"]");
        }
    }

    //Driver Program
    public static  void main(String[] args)
    {
        Interval []arr = new Interval[6];
        arr[0] = new Interval(6,8);
        arr[1] = new Interval(2,5);
        arr[2] = new Interval(1,3);
        arr[3] = new Interval(13,20);
        arr[4] = new Interval(9,14);
        arr[5] = new Interval(100,120);
        MergeOverlappingInterval(arr);
    }
}
