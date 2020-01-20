package Arrays;
import java.util.HashSet;
import java.util.Set;

/** Java Program to check if a array contain the Duplicate within K indices*/
public class DuplicatewithinKindices {

    //Function to find duplicate with in k indices
 static  boolean DuplicateKIndices(int []arr,int k)
    {
        int size = arr.length;
        Set<Integer> set = new HashSet<>();

        for(int i =0;i< size;i++)
        {
            if(set.contains(arr[i]))
                return true;
            else {
                set.add(arr[i]);
            }
            if(i>=k)
                set.remove(arr[i-k]);
        }
        return  false;
    }

    //Driver Program
    public static void main(String[] args)
    {
        int []arr = new int[]{10,5,3,4,3,5,6};
        int k = 3;
       boolean res = DuplicateKIndices(arr,k);
       if(res)
           System.out.println("yes");
       else
           System.out.print("No");

    }
}
