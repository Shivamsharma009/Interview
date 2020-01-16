package Arrays;

import java.lang.*;
/**
 * Java Program to find all Duplicates in positive Case it means
 * that Algorithm work on when i have only positive integers
 * it not work on whwn i have positve integers.
 */
public class  FindAllDuplicatePositive {
    public static void FindAllDupicatePositive(int arr[],int size)
    {
        int i ;
        System.out.println("All Duplicates  Numbers are ");
        for(i=0;i<size;i++)
        {
            if(arr[Math.abs(arr[i])]>=0)
            {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            }
            else
            {
                System.out.print("   "+Math.abs(arr[i]));

            }
        }
    }
    //Driver Program
    public static void main(String[] args){
        int arr[] = {1,2,3,1,3,6,6};
        int size = arr.length;
        FindAllDupicatePositive(arr,size);
    }
}
