package Arrays;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.max;

/**
 * Java Program to find Out Maximum
 * Sum of HourGlass in a Matrix
 */
public class MaxSumInHourGlass {

    //Global Constant
    static final int R = 5;
    static final int C  = 5;

    //Function to Find Max Sum of Hour-Glass in Matrix
   static  int FindMaxSumOfHourGlass(int [][]mat)
    {
        if(R < 3 || C < 3)
            return -1;
        int maxSum = MIN_VALUE;
        for(int i = 0; i < R-2; i++)
        {
            for(int j = 0 ;j < R-2 ;j++)
            {
                int sum = (mat[i][j] + mat[i][j+1] + mat[i][j+2] +
                           mat[i+1][j+1] +mat[i+2][j]+mat[i+2][j+1]+mat[i+2][j+2]);

                maxSum = max(maxSum,sum);
            }
        }
        return maxSum;
    }

    //Driver Program
    public static void main(String[] args)
    {
        int mat[][] ={{1, 2, 3, 0, 0},
                        {0, 0, 0, 0, 0},
                        {2, 1, 4, 0, 0},
                        {0, 0, 0, 0, 0},
                        {1, 1, 0, 1, 0}};

        int result = FindMaxSumOfHourGlass(mat);
        if(result == -1 )
            System.out.println("No Sum in Hour Glass Possible ");
        else
            System.out.println("Maximum  Sum  in Hour Glass Possible =  " +result);





    }
}
