package Arrays;

public class SubarraywithGivenSumPositive {

    public static void SubarraySum(int arr[],int size,int sum)
    {
        int curr_sum = arr[0],start =0,index;
        for(index = 1; index <size;index++)
        {
            while(curr_sum > sum && start < index-1){
                curr_sum = curr_sum - arr[start];
                start++;
            }

            if(curr_sum == sum){
                System.out.println("Sum found Between Indexes "+  start + "to  "  +(index-1));
                break;
            }
            if(index < size)
            {
                curr_sum = curr_sum + arr[index];
            }
        }
    }

    //Driver Program
    public static void main(String[] args){
        int arr[] = new int[]{5,4,6,7,9,8,3,1,2};
        int size = arr.length;
        int sum = 21;
        SubarraySum(arr,size,sum);
    }
}
