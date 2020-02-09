package Arrays;

import javax.swing.*;
import java.util.HashMap;

public class SubarrayWithGivenSumNegative {

    public static void SubarraywithgivenSum(int arr[],int size ,int sum)
    {
        int curr_sum=0,start = 0,end = -1;
        HashMap<Integer,Integer>hm = new HashMap<>();
        for(int i =0;i < size;i++)
        {
            curr_sum = curr_sum + arr[i];

            if(curr_sum == sum)
            {
                start = 0;
                end = i;
                break;
            }

            if(hm.containsKey(curr_sum - sum)){
                start = hm.get(curr_sum - sum )+1;
                end = i;
                break;
            }
            hm.put(curr_sum , i);
        }
        if(end==-1)
            System.out.println("No Subarray Found");
        else
            System.out.println("Sum found Between indexes "+start + "to " +end);
    }


    //Driver Program

    public static void main(String[] args){
        int arr[] = new int[]{8,5,-2,3,4,-5,7};
        int size = arr.length;
        int sum = 10;
        SubarraywithgivenSum(arr,size,sum);
    }
}
