package Arrays;

//Java program to find Next greater Number

import java.util.Arrays;

public class NextGreaterNumber {

    // Utility function to swap two digit
    static void swap(int ar[], int i, int j)
    {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    //Function to find next greater number
  static   void FindNextGreater(int[] arr,int size)
    {
        int i ;
        for(i=size-1;i > 0;i--) {
            if (arr[i] > arr[i - 1])
                break;
        }
            if (i == 0)
            {
                System.out.println("Next Greater element is not possible");
            }
        int x = arr[i-1],smallest =i;
        for(int j = i+1;j < size;j++)
        {
            if(arr[j] > x && arr[j] < arr[smallest])
                smallest = j;
        }
        swap(arr,i-1,smallest);

        Arrays.sort(arr,i,size);
        System.out.println("Next Greater Element is  set of digits is ");
        for (i = 0; i < size; i++)
            System.out.print(arr[i]);

    }
    //Driver Program
    public static  void main(String[] args)
    {
        int []arr = new int[]{2,1,8,7,6,5};
        int size = arr.length;
        FindNextGreater(arr,size);

    }

}
