package Arrays;
/**
 * Duplicate Number Detection using Floyd Cycle Detection Algorithm.
 * that program works on only when only one number is repeated multiple times.
 */
public class DuplicateNumberDetection {
    public int findDuplicateNumber(int input[])
    {
        //Corner Cases
        if(input.length == 0 ||input.length == 1)
            return -1;

        int slow = input[0];
        int fast = input[input[0]];

        //for Cycle Detection
        while (slow!=fast)
        {
            slow = input[slow];
            fast = input[input[fast]];
        }
        fast = 0;
        //For Entry point detection
        while(slow != fast)
        {
            slow = input[slow];
            fast = input[fast];
        }
        return  fast;
    }

    //Driver Program
    public static  void main(String[] args)
    {
        int input[] = {1,2,3,4,5,6,3};
        DuplicateNumberDetection dn = new DuplicateNumberDetection();
        System.out.println(dn.findDuplicateNumber(input));
    }
}

