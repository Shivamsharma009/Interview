package Arrays;
import java.util.Arrays;

public class Seperate0and1 {
    public void Seperate0and1(int arr[],int size){
        int leftindex = 0,rightindex =size-1;
        while(leftindex < rightindex)
        {
            while(arr[leftindex] == 0 && leftindex < rightindex)
            {
                leftindex++;
            }
            while(arr[rightindex] == 1 && rightindex >leftindex)
            {
                rightindex--;
            }

            if(leftindex < rightindex)
            {
                arr[leftindex] = 0;
                arr[rightindex] = 1;
                leftindex++;
                rightindex--;
            }
        }
    }

    //Driver Program
    public static void main(String[] args){
        int arr[] = {0,0,1,1,0,0,1,1};
        int size =  arr.length;
        Seperate0and1 seg = new Seperate0and1();
        seg.Seperate0and1(arr,size);
        System.out.print("Array after Seperating");
        System.out.println(Arrays.toString(arr));
    }
}

