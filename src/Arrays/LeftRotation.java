package Arrays;
// Java program for reversal algorithm of array rotation

class LeftRotation {
    /* Function to left rotate arr[] of size n by d */
    private static void leftRotate(int[] arr, int d)
    {

        if (d == 0)
            return;
        int n = arr.length;
        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, n - 1);
        reverseArray(arr, 0, n - 1);
    }

    /*Function to reverse arr[] from index start to end*/
    private static void reverseArray(int[] arr, int start, int end)
    {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    /*UTILITY FUNCTIONS*/
    /* function to print an array */
    private static void printArray(int[] arr)
    {
        for (int value : arr) System.out.print(value + " ");
    }

    /* Driver program to test above functions */
    public static void main(String[] args)
    {
        int[] arr;
        arr = new int[]{ 1, 2, 3, 4, 5, 6, 7 };
        int n = arr.length;
        int d;
        d = 2;

        // in case the rotating factor is
        // greater than array length
        d %= n;
        leftRotate(arr, d); // Rotate array by d
        printArray(arr);
    }
}
