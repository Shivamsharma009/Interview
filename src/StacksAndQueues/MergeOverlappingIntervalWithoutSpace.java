package StacksAndQueues;

import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervalWithoutSpace {

    static  class Interval{
        int start;
        int end;
        Interval(int start,int end)
        {
            this.start = start;
            this.end = end;
        }
    }

    public static  void mergeOverlappingInterval(Interval[] arr)
    {
        if(arr.length <= 0)
            return;

        Arrays.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o2.start - o1.start;
            }
        });

        int index = 0;

        for(int i = 1 ;i < arr.length;i++)
        {
            if(arr[index].end >= arr[i].start)
            {
                arr[index].start = Math.min(arr[index].start,arr[i].start);
                arr[index].end = Math.max(arr[index].end,arr[i].end);
            }else{
                arr[index] = arr[i];
                index++;
            }
        }
        System.out.print("Merge Overlapping intervals");
        for(int i = 0;i<=index;i++)
        {
            System.out.print("[ "+arr[i].start +"    "+arr[i].end +"]");
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
        mergeOverlappingInterval(arr);
    }
}
