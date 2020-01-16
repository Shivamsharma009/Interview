package Arrays;

public class MooreVoting {

    //Function to print majority element
    void printMajority(int arr[],int size)
    {
        //Find majority candidate
        int cand = findMajorityCandidate(arr,size);

        //check the cand if it is majority or not
        if(isMajorityElement(arr,size,cand))
        {
            System.out.print("  "+cand +" ");
        }
        else
        {
            System.out.print("No Majority Element");
        }
    }

    //Function to find the majority Candidate
    public int findMajorityCandidate(int arr[],int size)
    {
        int majorityindex = 0,count =1;
        for(int i =1;i<size;i++)
        {
            if(arr[majorityindex] == arr[i])
                count++;
            else
                count--;

            if(count == 0)
            {
                majorityindex = i;
                count = 1;
            }
        }
        return arr[majorityindex];
    }

    //Function to find the Element is majority elment or not
    public boolean isMajorityElement(int arr[],int size,int cand)
    {
        int count = 0;
        for(int i =0;i<size;i++)
        {
            if(arr[i] == cand)
                count++;
        }
        if(count > size/2)
            return true;
        else
            return  false;

    }

    //Driver Program
    public static  void main(String[] args)
    {
        MooreVoting moore = new MooreVoting();
        int arr[] = new int[]{1,1,1,1,2,3,4};
        int size = arr.length;
        moore.printMajority(arr,size);

    }
}

