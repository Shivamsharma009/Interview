package Arrays;
/** Java Program to Detect only Two Repeating Number Using XOR**/
public class TwoRepeatingNumber {
    //Function to print Two Repeating Number
   private static void printTwoRepeating(int arr[], int size)
    {
        /* will hold xor of all element */
        int xor = arr[0];
        /* Will have only single bit of XOR */
        int set_bit_no;
        int i ;
        int n = size-2;
        int x = 0,y = 0;
        /*Get the Xor element of all elements in arr[] and {1,2,3,4,.....} */
        for(i=1;i<size;i++)
            xor ^= arr[i];
        for(i=1;i<=n;i++)
            xor ^= i;

        /* Get the rightmost set bit no */

        set_bit_no = (xor & ~(xor -1));

        /* Now the divide in two sets by computing rightmost set bit
        /  of xor with bit at same position in each element
         */

        for(i=0;i<size;i++)
        {
            int a = arr[i] & set_bit_no;
            if(a!=0)
                x = x ^ arr[i];
            else
                y = y ^ arr[i];
        }
        for(i=1;i<=n;i++)
        {
            int a = i & set_bit_no;
            if(a!=0)
                x = x ^ i;
            else
                y = y ^ i;
        }
        System.out.println("Two Repeating Element");
        System.out.println(x+"  "+y);
    }
    //Driver Program
    public static  void main(String[] args)
    {
        int []arr = new int[]{2,4,2,5,4,3,1};
        int size = arr.length;
        printTwoRepeating(arr,size);
    }
}
