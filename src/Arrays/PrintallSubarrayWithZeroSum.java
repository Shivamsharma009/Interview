package Arrays;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;



//User defined class to create Pairs to Store subarray indexes
class Pair {
    int first,second;
    Pair(int a ,int b)
    {
        first = a;
        second = b;
    }
}
public class PrintallSubarrayWithZeroSum {
    //The function is return all subarray with zero sum
    static  ArrayList<Pair> PrintAllSubarray(int arr[],int n) {
        int sum = 0;
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        ArrayList<Pair> out = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //Create maintain sum so far
            sum += arr[i];
            ArrayList<Integer> al = new ArrayList<Integer>();
            if (sum == 0)
                out.add(new Pair(0, i));
            if (hm.containsKey(sum))
            {
                al = hm.get(sum);
                for (int it = 0; it < al.size(); it++)
                {
                    out.add(new Pair(al.get(it)+1, i));
                }
            }
            al.add(i);
            hm.put(sum, al);
        }
        return out;
    }

    //Print the ArrayList
private static  void Print(ArrayList<Pair> out)
{
    for(int i =0;i<out.size();i++){
        Pair p = out.get(i);
        System.out.println("Subarry found between indexes "+p.first +" to " +p.second);
    }
}


     //Driver Program
    public static void main(String[] args){
        int arr[] = new int[]{6,3,-1,-3,4,-2,2};
        int n = arr.length;
        ArrayList<Pair> out = PrintAllSubarray(arr,n);
        if(out.size()==0)
            System.out.println("No Subarray Found");
        else
            Print(out);

    }
}

