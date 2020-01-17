package Arrays;

/**
 * Java Program to find Equilbrium index in an array
 * Time - O(n)
 * space -O(1)
 */
public class EquilbriumIndex {
    //Function to find and print Equilbrium index in an array
    private  static  void EquilbriumIndex(int[] arr,int size)
    {
        int index,Leftsum=0,RightSum=0;
        for(index=0;index<size;index++)
             RightSum+= arr[index];
        for(index=0;index<size;index++) {
            RightSum -= arr[index];
            if (Leftsum == RightSum)
                System.out.println("Equilbrium index is " + index);
            Leftsum += arr[index];
        }
    }
    //Driver Program
    public static  void main(String[] args)
    {
        int[] arr = new int[]{7,2,1,4,6,4,0};
        int size = arr.length;
        EquilbriumIndex(arr,size);
    }

}
