package Arrays;

import java.util.HashMap;
import java.util.HashSet;

/** java program to find all pairs such that a+b = x **/

public class FindAllPairs
{
    //Function to find all pairs in a sum
    static  boolean  FindAll(int[] arr,int sum) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int n = arr.length;
        int index, temp;
        for (index = 0; index < n; index++) {
            temp = sum - arr[index];
            if (hs.contains(temp)) {
                System.out.println("Pair with given sum " + sum + " is " + arr[index] +"   "  + temp);

            }
            hs.add(arr[index]);
        }
        return  false;
    }

    //Driver Program
    public static  void main(String[] args) {
        int arr[] = new int[]{1, 20, 5, 6, 9, 2, 10};
        int sum = 8;
         FindAll(arr, sum);

        }
    }
