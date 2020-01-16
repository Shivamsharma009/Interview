package Arrays;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

public class LargestMultipleof3 {
    //This function put all element of 3 queue in
    //the array auxiliary.
    public static int populateAUX(int aux[],Queue<Integer> queue0,Queue<Integer> queue1,Queue<Integer> queue2)
    {
        int top = 0;
        //put all items of first queue in aux[]
        while(!queue0.isEmpty())
        {
            aux[top++] = queue0.remove();
        }
        //put all items of second queue in aux[]

        while(!queue1.isEmpty())
        {
            aux[top++] = queue1.remove();
        }
        while(!queue2.isEmpty())
        {
            aux[top++] = queue2.remove();
        }
        return top;
    }

    /** the main function that find the largest possible multiple of 3 that can be formed
     * by the arr[] elements.
     *
     */

    public static boolean findMaxMultipleof3(int arr[])
    {
        //step 1 Sort the array in increasing order
        Arrays.sort(arr);

        //create 3 queue to store number with remainder 0 and 1 2 respectively
        Queue<Integer> queue0 = new LinkedList<>();
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        //step 2 and 3 get the sum of number and place them in corresponding queue
        int sum = 0;
        for(int i= 0;i<arr.length;i++)
        {
            sum += arr[i];

            if((arr[i] % 3)==0)
                queue0.add(arr[i]);

            else if((arr[i]%3) == 1)
                queue1.add(arr[i]);
            else
                queue2.add(arr[i]);
        }

        //step 4.1 the sum produces remainder 1
        if((sum % 3)==1)
        {
            //either remove one item from queue1
            if(!queue1.isEmpty())
                queue1.remove();

            //either remove two items from queue 2
            if(!queue2.isEmpty())
                queue2.remove();
            else
                return  false;

            if(!queue2.isEmpty())
                queue2.remove();
            else
                return  false;
        }

        //step 4.2 the sum produces remainder 2
        if((sum % 3 )==2)
        {
            //either remove one element from queue 2
            if(!queue2.isEmpty())
                queue2.remove();

            //either remove two element from queue 1
            if(!queue1.isEmpty())
                queue1.remove();
            else
                return false;

            if(!queue1.isEmpty())
                queue1.remove();
            else
                return false;
        }
        int aux[] = new int[arr.length];
        int top = populateAUX(aux,queue0,queue0,queue2);

        //Sort the array in non incrasing order
        Arrays.sort(aux,0,top);

        //print the result
        for(int i = top-1;i>=0;i--)
            System.out.print(aux[i] + "  ");

        return true;

    }

    //Driver Program
    public static void main(String[] args)
    {
        int arr[] = {3,3,8,6,8};
        if(!findMaxMultipleof3(arr))
            System.out.println("Not Possible");
    }
}

