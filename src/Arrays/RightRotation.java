package Arrays;

public class RightRotation {

   private static void ReverseArray(int[] arr, int start, int end)
    {
        int temp;
        while(start < end)
        {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

   static void RightRotate(int []arr,int d)
    {
        if(d == 0)
            return;

        int n = arr.length;
        ReverseArray(arr,0,n-1);
        ReverseArray(arr,0,d-1);
        ReverseArray(arr,d,n-1);
    }

    static  void PrintArray(int []arr)
    {
        int n = arr.length;
        for (int value : arr) System.out.print("   " + value);
    }

    //Drive Program
    public static void main(String[] args)
    {
        int []arr = new int[] {1,2,3,4,5,6,7};
        int d = 2;
        int n = arr.length;
        //in case the d
        //is greater than array size
        d%= n;
        RightRotate(arr,d);
        PrintArray(arr);
    }
}
